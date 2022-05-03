package com.htxa.ch.leetcode;

public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord=new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("a "));
    }

    public int lengthOfLastWord(String s) {
        if(s.isEmpty()){
            return 0;
        }
        while (s.endsWith(" ")){
            s=s.substring(0,s.length()-1);
        }
        int index=s.lastIndexOf(' ');

        return s.substring(index+1).length();
    }
}
