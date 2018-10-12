package com.htxa.ch.leetcode.page1;

import java.util.Arrays;

//接雨水，代码逻辑应该是对的，但是效率太低，超时
public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater=new TrappingRainWater();
//        int[] nums=new int[]{0,1,0,2,1,0,1,3};
//        int[] nums=new int[]{5,4,1,2};
//        int[] nums=new int[]{5,2,1,2,1,5};
        int[] nums=new int[]{2,3,2,6,9};

        System.out.println(trappingRainWater.trap(nums));
    }

    public int trap(int[] height) {

        int heightLenght=height.length;
        if(heightLenght==0){
            return 0;
        }
        boolean leftFlag=false;
        int result=0;
        int temp=0;

        int isContinue=0;

        while (isContinue>-1){
            int lowFlag=Arrays.stream(height).min().getAsInt();
            isContinue=-2;

            for (int i = 0; i < heightLenght; i++) {
                if(leftFlag){
                    if(height[i]==lowFlag){
                        temp++;
                        height[i]=height[i]-lowFlag;
                    }else {
                        height[i]=height[i]-lowFlag-1;
                        if(temp==0){
                            if(height[i]>0){
                                isContinue++;
                            }
                            continue;
                        }
                        result=result+temp;
                        temp=0;
                        if(height[i]>0){
                            isContinue++;
                        }
                    }
                }else if(height[i]>lowFlag){
                    leftFlag=true;
                    height[i]=height[i]-lowFlag-1;
                    if(height[i]>0){
                        isContinue++;
                    }
                }else if(height[i]==lowFlag){
                    height[i]=height[i]-lowFlag;
                }
            }
            temp=0;
            leftFlag=false;
        }

        return result;

    }
}
