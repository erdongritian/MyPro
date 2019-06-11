package com.htxa.ch.leetcode.page2;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result=new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j]=0;
            }
        }


        return result;
    }
}
