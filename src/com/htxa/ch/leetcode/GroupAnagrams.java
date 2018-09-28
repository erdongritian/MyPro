package com.htxa.ch.leetcode;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> resultMap = new HashMap<>();

        List<String> tempList = new ArrayList<>();

        for (String string : strs) {
            char[] strArray=string.toCharArray();
            TreeMap<Character, Integer> map = new TreeMap<>();
            for(char c:strArray){
                if(map.get(c)!=null){
                    int num=map.get(c);
                    num++;
                    map.put(c,num);
                }else {
                    map.put(c,1);
                }
            }
            StringBuilder sb=new StringBuilder();
            for(Map.Entry<Character, Integer> entry:map.entrySet()){
                sb.append(entry.getKey()).append(entry.getValue());
            }
            String temStr=sb.toString();

            Boolean flag=true;
            for(String tmpMap:tempList){
                if(temStr.equals(tmpMap)){
                    List<String> listStr=resultMap.get(tmpMap);
                    listStr.add(string);
                    flag=false;
                    break;
                }
            }
            if(tempList.size()==0||flag){
                List list=new ArrayList<>();
                list.add(string);
                resultMap.put(temStr,list);
                tempList.add(temStr);
            }
        }

        for(List<String> t:resultMap.values()){
            result.add(t);
        }

        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams=new GroupAnagrams();
        String[] strs=new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }
}
