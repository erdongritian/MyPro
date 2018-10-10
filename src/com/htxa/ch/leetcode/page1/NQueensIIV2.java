package com.htxa.ch.leetcode.page1;


public class NQueensIIV2 {
    public static void main(String[] args) {
        NQueensIIV2 nQueens=new NQueensIIV2();
        System.out.println(nQueens.totalNQueens(4));
    }

    int totalCount=0;
    public int totalNQueens(int n) {
        if(n==1){
            return 1;
        }
        int[] resultArray=new int[n];

        for (int i = 0; i < n; i++) {
            resultArray[0]=i;
            getQueensIndex(1,n,resultArray);
        }

        return totalCount;
    }

    private void getQueensIndex(int index,int total,int[] array){
        if(index==(total-1)){
            for (int i = 0; i < total; i++) {
                if(isLegal(index,array,i)){
                    totalCount++;
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
