package com.htxa.ch.leetcode.page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        Combinations combinations=new Combinations();
        combinations.combine(13,13);
        System.out.println(combinations.result);
    }

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        Integer[] arr=new Integer[k];
        getArray(arr,0,1,n,k);
        return result;
    }

    private void getArray(Integer[] arr,int arrIndex,int currentVal,int n,int k){
        for (int i = 0; i < n-arrIndex&&currentVal<n+1; i++) {
            arr[arrIndex]=currentVal;
            currentVal++;

            if(arrIndex==k-1){
                result.add(Arrays.asList(Arrays.copyOf(arr,k)));
            }else if(arrIndex<k-1){
                arrIndex++;
                getArray(arr,arrIndex,currentVal,n,k);
                arrIndex--;
            }
        }
    }



}
