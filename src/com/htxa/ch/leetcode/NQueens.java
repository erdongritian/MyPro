package com.htxa.ch.leetcode;

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        NQueens nQueens=new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }


    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n==1){
            return Arrays.asList(Arrays.asList("Q"));
        }


        for (int i = 0; i < n; i++) {
            Set<Integer> resultSet=new HashSet<>();
            resultSet.add(i);
            Map<Integer,Set<Integer>> map=new HashMap();
            map.put(0,getHava(0,i,n));

            M(n-1,n,map,resultSet);
        }

        return result;
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
                    resultSet.add(count*10+j);

                    if(resultSet.size()==n){
                        List<String> list=new ArrayList<>(n);
                        Map tMap=new HashMap();

                        for(int parms:resultSet){
                            int x=parms/10;
                            int y=parms%10;

                            StringBuilder sb=new StringBuilder();
                            for (int m = 0; m < n; m++) {
                                if(m==y){
                                    sb.append("Q");
                                }else {
                                    sb.append(".");
                                }
                            }
                            tMap.put(x,sb.toString());
                        }

                        for (int m = 0; m < n; m++) {
                            list.add(tMap.get(m).toString());
                        }
                        result.add(list);
                        resultSet.remove(count*10+j);
                    }
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
