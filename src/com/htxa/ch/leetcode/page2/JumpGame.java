package com.htxa.ch.leetcode.page2;


//Time Limit Exceeded
public class JumpGame {
    public boolean canJump(int[] nums) {
        return jump(nums,0);
    }

    public boolean jump(int[] nums,int index){
        if(nums[index]+index+1>=nums.length){
            return true;
        }

        for (int i = index+1; i <index+nums[index]+1 ; i++) {
             if(jump(nums,i)) return true;
        }
        return false;
    }
}
