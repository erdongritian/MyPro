package com.htxa.ch.leetcode.page2;

public class MaximumSubarray {

    int maxNum;
    public int maxSubArray(int[] nums) {
        maxNum=nums[0];

        int numsLength=nums.length;

        for (int i = 0; i < numsLength; i++) {
            getSum(nums,i,numsLength-1);
        }
        return maxNum;
    }

    public int getSum(int[] nums,int startIndex,int endIndex){

        int sum;
        if(endIndex==startIndex){
            sum=nums[startIndex];
        }else{
            sum=getSum(nums,startIndex,endIndex-1)+nums[endIndex];
        }

        maxNum=Math.max(maxNum,sum);
        return sum;

    }
}
