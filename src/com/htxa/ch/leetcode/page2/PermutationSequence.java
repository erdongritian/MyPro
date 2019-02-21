package com.htxa.ch.leetcode.page2;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequence permutationSequence=new PermutationSequence();
        permutationSequence.getPermutation(4,9);

    }

    public String getPermutation(int n, int k) {
        int[] ints=new int[n];
        int[] intMax=new int[n];

        int max=1;
        for (int i = 1; i < n + 1; i++) {
            ints[i-1]=i;
            max=max*i;
            intMax[i-1]=max;
        }

        for (int i = 0; i < n; i++) {
//            554
        }
//        int j=k/intMax[]


        System.out.println(max);

        return "";
    }


}
