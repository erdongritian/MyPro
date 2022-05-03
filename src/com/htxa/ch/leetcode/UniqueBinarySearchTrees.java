package com.htxa.ch.leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        UniqueBinarySearchTrees u=new UniqueBinarySearchTrees();
        System.out.println(u.numTrees(3));
    }

    private static Map<Integer,Integer> cache=new HashMap<>();
    public int numTrees(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        Integer result = cache.get(n);
        if(result!=null){
            return result;
        }
        result=0;
        if (n % 2 == 0) {
            for (int i = 0; i < (n / 2); i++) {
                result += numTrees(n - 1 - i) * numTrees(i);
            }
            cache.put(n,2 * result);
            return 2 * result;
        }

        for (int i = 0; i < ((n - 1) / 2); i++) {
            result += numTrees(n - 1 - i) * numTrees(i);
        }

        cache.put(n,2 * result + numTrees((n - 1) / 2) * numTrees((n - 1) / 2));
        return 2 * result + numTrees((n - 1) / 2) * numTrees((n - 1) / 2);
    }
}
