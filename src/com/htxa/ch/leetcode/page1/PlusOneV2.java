package com.htxa.ch.leetcode.page1;

import java.util.Arrays;

public class PlusOneV2 {
    public int[] plusOne(int[] digits) {
        int length=digits.length;
        int temp=1;
        for(int i=length-1;i>=0;i--){
            digits[i]=digits[i]+temp;
            if(digits[i]==10){
                digits[i]=0;
            }else {
                temp=0;
                break;
            }
        }
        if(temp==1){
            digits=new int[length+1];
            digits[0]=1;
            for(int i=1;i<length+1;i++){
                digits[i]=0;
            }
        }

        return digits;
    }


    public static void main(String[] args) {
        PlusOneV2 plusOne=new PlusOneV2();
        int[] ints=new int[]{9};
        System.out.println(Arrays.toString(plusOne.plusOne(ints)));
    }
}
