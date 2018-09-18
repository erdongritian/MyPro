package com.htxa.ch.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();

        System.out.println(permutations.getLength(5));
//        permutations.permute(new int[]{1, 2});
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int numsLength=nums.length;

        int loopLength=getLength(numsLength);

        for (int i = 0; i < loopLength; i++) {
            int[] array = new int[numsLength];
            for (int j = 0; j < numsLength; j++) {
//                array[j]=
            }
        }

        return result;
    }


    private int getInt(int i,int j,int[] nums,int length){
        if(i<getLength(length-1)&&j==0){
            return nums[i];
        }else if(i==1){

        }
        return 0;
    }



    private int getLength(int n){
        if(n==1){
            return 1;
        }else {
            return n * getLength(n - 1);
        }
    }


}
