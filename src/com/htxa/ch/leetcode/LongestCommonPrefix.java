package com.htxa.ch.leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length==0) return "";
        if (strs.length==1) return strs[0];

        int strLength=strs[0].length();

        for(int j=0;j<strLength;j++){
            for(int i=0;i<strs.length-1;i++){
                try {
                    if(strs[i].charAt(j)!=strs[i+1].charAt(j)){
                        return strs[0].substring(0,j);
                    }
                    if(i==strs.length-2&&j==strLength-1){
                        return strs[0].substring(0,j+1);
                    }
                }catch (IndexOutOfBoundsException e){
                    return strs[0].substring(0,j);
                }
            }
        }
        return "";

    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix=new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"c","c"}));
    }
}
