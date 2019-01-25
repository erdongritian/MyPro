package com.htxa.ch.leetcode.page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {

    public static void main(String[] args) {
        Subsets subsets=new Subsets();
        int[] ints=new int[]{1,2,3,4};
        System.out.println(subsets.subsets(ints));
    }


    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        result.add(Collections.EMPTY_LIST);
        getSubset(0, nums,null,0);
        return result;
    }

    public void getSubset(int flag, int[] nums,int[] target,int index) {
        flag++;
        if (flag == 1) {
            for (int i = 0; i < nums.length; i++) {
                int[] intArray = new int[flag];
                intArray[0] = nums[i];
                result.add(Arrays.stream(intArray).boxed().collect(Collectors.toList()));
                if(i<nums.length-1){
                    getSubset(flag,nums,intArray,i);
                }
            }
        }else {
            index++;
            for (int i = index; i < nums.length; i++) {
                int[] intArray = new int[flag];
                System.arraycopy(target,0,intArray,0,target.length);
                intArray[flag-1]=nums[i];
                result.add(Arrays.stream(intArray).boxed().collect(Collectors.toList()));
                if(i<nums.length-1){
                    getSubset(flag,nums,intArray,i);
                }
            }

        }
    }
}
