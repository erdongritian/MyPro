package com.htxa.ch.leetcode.page2;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static void main(String[] args) {
//        System.out.println(1^1);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList<>();
        result.add(0);
        if(n==0){
            return result;
        }

        int[] ints=new int[n];

        for (int i = 0; i < n; i++) {
            ints[i]=ints[i]^1;
            int value=getTenValue(ints);
            if(result.contains(value)){
                continue;
            }else {
                result.add(value);

            }
        }
        return result;
    }




    private int getTenValue(int[] ints){
        int length=ints.length;
        int sum=0;
        for (int i = 0; i < length; i++) {
            sum+=ints[i]*Math.pow(2,i);
        }
        return sum;
    }




}
