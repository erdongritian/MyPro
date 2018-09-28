package com.htxa.ch.leetcode;

import java.util.*;

public class GroupAnagramsV2 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> resultMap = new HashMap<>();

        Set<String> tempSet = new HashSet<>();

        for (String string : strs) {
            char[] strArray=string.toCharArray();
            List<Character> charList=new ArrayList<>();

            for(char c:strArray){
                charList.add(c);
            }
            Collections.sort(charList);
            String temStr= charList.toString();

            if(tempSet.add(temStr)){
                List list=new ArrayList<>();
                list.add(string);
                resultMap.put(temStr,list);
            }else {
                List<String> listStr=resultMap.get(temStr);
                listStr.add(string);
            }
        }

        for(List<String> t:resultMap.values()){
            result.add(t);
        }

        return result;
    }

    public static void main(String[] args) {
        GroupAnagramsV2 groupAnagrams=new GroupAnagramsV2();
        String[] strs=new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }
}
