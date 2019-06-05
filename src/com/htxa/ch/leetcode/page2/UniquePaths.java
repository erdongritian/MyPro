package com.htxa.ch.leetcode.page2;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths uniquePaths=new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(51,9));
    }

    Map<String,Integer> temp=new HashMap<>();

    public int uniquePaths(int m, int n) {

        if(m==1||n==1){
            return 1;
        }

        String key=m+"#"+n;
        if(temp.get(key)!=null){
            return temp.get(key);
        }else {
            int result=uniquePaths(m-1,n)+uniquePaths(m,n-1);
            temp.put(key,result);
            return result;
        }
    }
}
