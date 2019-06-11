package com.htxa.ch.leetcode.page2;

public class MinimumPathSum {

    int maxLength;
    int maxdeep;
    int max;

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum=new MinimumPathSum();
        int[][] grid=new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minimumPathSum.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        maxLength=grid.length;
        maxdeep=grid[0].length;

        max=Integer.MAX_VALUE;
        getSum(0,0,0,grid);

        return max;
    }


    private int getSum(int maxTemp,int x,int y,int[][] grid){

        maxTemp=maxTemp+grid[x][y];

        if(maxTemp>max){
            return maxTemp;
        }

        if(x==maxLength-1&&y==maxdeep-1){
            if(max>maxTemp){
                max=maxTemp;
            }
            return maxTemp;
        }

        //向右
        if(y+1<maxdeep){
            maxTemp=getSum(maxTemp,x,y+1, grid);
            maxTemp-=grid[x][y+1];
        }

        //向下
        if(x+1<maxLength){
            maxTemp=getSum(maxTemp,x+1,y, grid);
            maxTemp-=grid[x+1][y];
        }

        return maxTemp;
    }
}
