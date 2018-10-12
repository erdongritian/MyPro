package com.htxa.ch.leetcode.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.cnblogs.com/grandyang/p/4402392.html
public class TrappingRainWaterV2 {

    public static void main(String[] args) {
        TrappingRainWaterV2 trappingRainWater=new TrappingRainWaterV2();
//        int[] nums=new int[]{0,1,0,2,1,0,1,3};
        int[] nums=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] nums=new int[]{5,4,1,2};
//        int[] nums=new int[]{5,2,1,2,1,5};
//        int[] nums=new int[]{2,3,2,6,9};

        System.out.println(trappingRainWater.trap(nums));
    }

    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int res=0;
        int maxleft=0, maxright=0;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=maxleft) maxleft=height[left];
                else res+=maxleft-height[left];
                left++;
            }
            else{
                if(height[right]>=maxright) maxright= height[right];
                else res+=maxright-height[right];
                right--;
            }
        }
        return res;

    }
}
