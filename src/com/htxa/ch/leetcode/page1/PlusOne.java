package com.htxa.ch.leetcode.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> list= new ArrayList();

        int length=digits.length;
        int current=digits[length-1]+1;
        int temp=0;
        if (current<10) {
            list.add(current);
        }else {
            temp=1;
            list.add(0);
        }

        for(int i=length-2;i>=0;i--){
            if(temp==1){
                int c=digits[i]+1;
                if(c<10){
                    temp=0;
                    list.add(c);
                }else {
                    list.add(0);
                }
            }else {
                list.add(digits[i]);
            }
        }
        if(temp==1){
            list.add(1);
        }


        Collections.reverse(list);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }


    public static void main(String[] args) {
        PlusOne plusOne=new PlusOne();
        int[] ints=new int[]{1,2,3};
        System.out.println(Arrays.toString(plusOne.plusOne(ints)));
    }
}
