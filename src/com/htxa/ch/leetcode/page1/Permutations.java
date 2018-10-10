package com.htxa.ch.leetcode.page1;

import java.util.*;

public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums=new int[]{1,2,3,4};
        List<List<Integer>> list=permutations.permute(nums);
        System.out.println(list);
    }


    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==1){
            return Arrays.asList(Arrays.asList(nums[0]));
        }

        List<List<Integer>> result = new ArrayList<>();
        if(nums.length==2){
            List<Integer> l1=new ArrayList<>();
            l1.add(nums[0]);
            l1.add(nums[1]);
            result.add(l1);

            List<Integer> l2=new ArrayList<>();
            l2.add(nums[1]);
            l2.add(nums[0]);
            result.add(l2);

            return result;
        }else {
            int numsLength=nums.length;
            for (int i = 0; i < numsLength; i++) {
                int[] tempNums=new int[numsLength-1];
                for (int j = 0; j < numsLength - 1; j++) {
                    if(j<i){
                        tempNums[j]=nums[j];
                    }else {
                        tempNums[j]=nums[j+1];
                    }
                }

                List<List<Integer>> tempList=permute(tempNums);
                for (List<Integer> temp : tempList) {
                    temp.add(0,nums[i]);
                    result.add(temp);
                }
            }
        }

        return result;
    }








}
