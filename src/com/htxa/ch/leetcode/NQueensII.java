package com.htxa.ch.leetcode;

import java.util.*;

public class NQueensII {
    public static void main(String[] args) {
        NQueensII nQueens=new NQueensII();
        System.out.println(nQueens.totalNQueens(4));
    }

    int totalCount=0;
    public int totalNQueens(int n) {
        if(n==1){
            return 1;
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> resultSet=new HashSet<>();
            resultSet.add(i);
            Map<Integer,Set<Integer>> map=new HashMap();
            map.put(0,getHava(0,i,n));

            M(n-1,n,map,resultSet);
        }

        return totalCount;
    }


    private void M(int count,int n,Map<Integer,Set<Integer>> map,Set<Integer> resultSet){

        if(count==1){
            for (int j = 0; j < n; j++) {
                boolean tag=true;
                for(Set<Integer> tempSet:map.values()){
                    if(tempSet.contains(count*10 + j)){
                        tag=false;
                        break;
                    }
                }
                if(tag){
                    totalCount++;
                }
            }
        }else {
            for (int j = 0; j < n; j++) {

                boolean tag=true;
                for(Set<Integer> tempSet:map.values()){
                    if(tempSet.contains(count*10 + j)){
                        tag=false;
                        break;
                    }
                }

                if(tag){
                    Set<Integer> tMap=getHava(count, j, n);
                    map.put(count,tMap);
                    resultSet.add(count*10+j);
                    M(count-1,n,map,resultSet);

                    resultSet.remove(count*10+j);
                    map.remove(count);
                }

            }
        }
    }

    private Set<Integer> getHava(int x,int y,int n){

        Set<Integer> haveData=new HashSet<>();

        //第一种情况（x,n）
        int i=0;
        while (i<n){
            haveData.add(x*10+i);
            i++;
        }
        //第二种情况（y,n）
        i=0;
        while (i < n) {
            haveData.add(i * 10 + y);
            i++;
        }
        //第三种情况（x-i,y-i）
        int x1=x-1;
        int y1=y-1;
        while (x1 > -1 && y1 > -1) {
            haveData.add(x1*10+y1);
            x1--;
            y1--;
        }
        //第四种情况（x+i,y+i）
        x1=x+1;
        y1=y+1;
        while (x1 < n && y1 < n) {
            haveData.add(x1*10+y1);
            x1++;
            y1++;
        }
        //第五中情况（x-i,y+i）
        x1=x-1;
        y1=y+1;
        while (x1 > -1 && y1 < n) {
            haveData.add(x1*10+y1);
            x1--;
            y1++;
        }
        //第六种情况（x+i,y-i）
        x1=x+1;
        y1=y-1;
        while (x1 < n && y1 > -1) {
            haveData.add(x1*10+y1);
            x1++;
            y1--;
        }
        return haveData;
    }
}
