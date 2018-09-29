package com.htxa.ch.leetcode;

import java.util.*;

public class NQueensV2 {
    public static void main(String[] args) {
        NQueensV2 nQueens=new NQueensV2();
        System.out.println(nQueens.solveNQueens(4));
    }

    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n==1){
            return Arrays.asList(Arrays.asList("Q"));
        }
        int[] resultArray=new int[n];

        for (int i = 0; i < n; i++) {
            resultArray[0]=i;
            getQueensIndex(1,n,resultArray);
        }
        return result;
    }

    private void getQueensIndex(int index,int total,int[] array){
        if(index==(total-1)){
            for (int i = 0; i < total; i++) {
                if(isLegal(index,array,i)){
                    array[index]=i;

                    List<String> list=new ArrayList<>();
                    for (int j = 0; j < total; j++) {
                        StringBuilder sb=new StringBuilder();
                        for (int k = 0; k < total; k++) {
                            if(array[j]==k){
                                sb.append("Q");
                            }else {
                                sb.append(".");
                            }
                        }
                        list.add(sb.toString());
                    }

                    result.add(list);
                }
            }
        }else {
            for (int i = 0; i < total; i++) {
                if(isLegal(index,array,i)){
                    array[index]=i;
                    getQueensIndex(index+1,total,array);
                }
            }
        }
    }

    //验证合法
    private boolean isLegal(int rowIndex,int[] array,int colIndex){
        int j=1;
        for (int i = rowIndex-1; i >=0; i--) {
            int preColIndex=array[i];
            if(preColIndex==colIndex||(colIndex-j)==preColIndex||(colIndex+j)==preColIndex){
                return false;
            }
            j++;
        }
        return true;
    }
}
