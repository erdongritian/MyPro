package com.htxa.ch.leetcode.page2;

import java.util.*;

public class SubsetsII {



    public static void main(String[] args) {
        SubsetsII subsetsII=new SubsetsII();
        int[] nums=new int[]{1,1,2,2};
        System.out.println(subsetsII.subsetsWithDup(nums));

    }


    List<List<Integer>> result=new ArrayList<>();
    Set<String> stringSet=new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        //list中加[]
        result.add(new ArrayList<>());

        if(nums.length==0){
            return result;
        }

        for (int i = 1; i < nums.length+1; i++) {
            getList(i,0,0,new Integer[i],nums);
        }

        return result;
    }

    private void getList(int arrayLength,int startIndex,int arrIndex,Integer[] arr,int[] nums){
        if(arrIndex>=arrayLength){
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            arr[arrIndex]=nums[i];
            if(arrIndex+1==arrayLength&&stringSet.add(Arrays.toString(arr))){
                result.add(Arrays.asList(Arrays.copyOf(arr,arrayLength)));
            }else {
                arrIndex++;
                getList(arrayLength,i+1,arrIndex,arr,nums);
                arrIndex--;
            }


        }
    }


}
