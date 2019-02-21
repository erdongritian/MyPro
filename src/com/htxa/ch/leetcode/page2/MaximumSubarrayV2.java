package com.htxa.ch.leetcode.page2;

public class MaximumSubarrayV2 {

    public static void main(String[] args) {
        MaximumSubarrayV2 maximumSubarrayV2=new MaximumSubarrayV2();
        int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums=new int[]{-2,-1,-3};
        System.out.println(maximumSubarrayV2.maxSubArray(nums));
    }


    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i-1] > 0){
                nums[i] += nums[i-1];
            }
            res = Math.max(res,nums[i]);
        }

        return res;
    }
}
