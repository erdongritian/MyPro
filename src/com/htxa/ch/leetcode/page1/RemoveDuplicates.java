package com.htxa.ch.leetcode.page1;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        int j=0;
        for(int i=1;i<nums.length;i++){
            if(nums[j]!=nums[i]){
                j++;
                nums[j]=nums[i];
            }
        }

        return j+1;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,1,1,2,2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
//        int[] nums=new int[]{0,0,1,1,1,2,2,3,3,4};

    }

}
