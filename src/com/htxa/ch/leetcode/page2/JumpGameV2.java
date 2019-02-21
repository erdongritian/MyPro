package com.htxa.ch.leetcode.page2;

public class JumpGameV2 {
    public boolean canJump(int[] nums) {
        if(nums.length<=1) return true;
        int step=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(step>0){
                step--;
            }else {
                return false;
            }

            if(nums[i]+i+1>=nums.length){
                return true;
            }

            step=Math.max(step,nums[i]);
        }
        return false;
    }
}
