package com.htxa.ch.leetcode.page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsV2 {

    public static void main(String[] args) {
        CombinationsV2 combinations=new CombinationsV2();
        combinations.combine(13,13);
        System.out.println(combinations.result);
    }

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        Integer[] arr=new Integer[k];
        getArray(arr,0,0,n,k);
        return result;
    }

    private void getArray(Integer[] arr,int arrIndex,int from,int to,int k){

        if(arrIndex==k){
            result.add(new ArrayList<>(Arrays.asList(arr)));
            return;
        }

        for (int i = from; i < to; i++) {
            arr[arrIndex]=i+1;
            arrIndex++;
            getArray(arr,arrIndex,i+1,to,k);
            arrIndex--;
        }
    }



}
