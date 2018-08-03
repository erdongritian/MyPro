package com.htxa.ch.leetcode;

import java.util.Arrays;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {

        int j=0;
        int i=0;
        while (i<nums.length){
            if(nums[i]==val){
                i++;
            }else{
                nums[j]=nums[i];
                i++;
                j++;
            }
        }

        return j;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{0,1,2,2,3,0,4,2};
//        int[] nums=new int[]{3,2,2,3};


        System.out.println(removeElement(nums,2));
        System.out.println(Arrays.toString(nums));

    }
}
