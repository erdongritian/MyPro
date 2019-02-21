package com.htxa.ch.leetcode.page2;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix=new SpiralMatrix();
        int[][] matrix=new int[][]{new int[]{1},new int[]{2},new int[]{3}};
//        int[][] matrix=new int[][]{new int[]{1,2,3},new int[]{4,5,6},new int[]{7,8,9}};
//        int[][] matrix=new int[][]{new int[]{1,2,3},new int[]{4,5,6}};
//        int[][] matrix=new int[][]{new int[]{1,2,3}};
//        int[][] matrix=new int[][]{new int[]{1,2,3,4,5,6,7,8,9,10}};
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        if(matrix==null||matrix.length==0) return result;

        //行指针
        int startRowIndex=0;
        int endRowIndex=matrix.length-1;

        //列指针
        int startColIndex=0;
        int endColIndex=matrix[0].length-1;

        while (endRowIndex-startRowIndex>=0&&endColIndex-startColIndex>=0) {

            //上
            if(startColIndex!=endColIndex||startRowIndex==endColIndex){
                for (int i = startColIndex; i < endColIndex+1; i++) {
                    result.add(matrix[startRowIndex][i]);
                }
            }

            //右
            for (int i = startRowIndex+1; i < endRowIndex+1; i++) {
                result.add(matrix[i][endColIndex]);
            }
            //下
            if(endRowIndex-startRowIndex>0){
                for (int i = endColIndex-1; i >startColIndex-1; i--) {
                    result.add(matrix[endRowIndex][i]);
                }
            }

            //左
            if(startColIndex<endColIndex){
                for (int i = endRowIndex-1; i >startRowIndex ; i--) {
                    result.add(matrix[i][startRowIndex]);
                }
            }


            startRowIndex++;
            endRowIndex--;

            startColIndex++;
            endColIndex--;
        }

        return result;
    }
}
