package com.htxa.ch.leetcode;

import java.util.*;

public class GroupAnagramsV3 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Integer,Integer> dicMap = new HashMap<>();

        int[] tempArgs=new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};

        for(String str:strs){
            char[] strArray=str.toCharArray();
            int key=1;
            for(char c:strArray){
                key*=tempArgs[c-'a'];
            }
            Integer pos=dicMap.get(key);
            if(pos==null){
                dicMap.put(key,dicMap.size());
                List tempList=new ArrayList();
                tempList.add(str);
                result.add(tempList);
            }else {
                result.get(pos).add(str);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GroupAnagramsV3 groupAnagrams=new GroupAnagramsV3();
        String[] strs=new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }
}
