package com.htxa.ch.leetcode.page1;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix =new int[][]{
                {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
        };

        RotateImage rotateImage=new RotateImage();
        rotateImage.rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        int matrixLength=matrix.length;

        for (int i = 0; i < matrixLength/2; i++) {
            for (int j = i; j <matrixLength-i-1 ; j++) {
//                int tmpValue1=matrix[i][j];
//                matrix[i][j]=matrix[matrixLength-1-j][i];
//
//                int tmpValue2=matrix[j][matrixLength-1-i];
//                matrix[j][matrixLength-1-i]=tmpValue1;
//
//                tmpValue1=matrix[matrixLength-1-i][matrixLength-1-j];
//                matrix[matrixLength-1-i][matrixLength-1-j]=tmpValue2;
//
//                matrix[matrixLength-1-j][i]=tmpValue1;

                int tmpValue1=matrix[i][j];

                matrix[i][j]=matrix[matrixLength-1-j][i];
                matrix[matrixLength-1-j][i]=matrix[matrixLength-1-i][matrixLength-1-j];
                matrix[matrixLength-1-i][matrixLength-1-j]=matrix[j][matrixLength-1-i];
                matrix[j][matrixLength-1-i]=tmpValue1;
            }
        }
        System.out.println(Arrays.deepToString(matrix));

    }
}
