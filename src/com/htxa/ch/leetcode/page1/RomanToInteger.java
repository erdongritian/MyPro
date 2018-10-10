package com.htxa.ch.leetcode.page1;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    Map<Character,Integer> entryMap=new HashMap<>();
    {
        entryMap.put('I',1);
        entryMap.put('V',5);
        entryMap.put('X',10);
        entryMap.put('L',50);
        entryMap.put('C',100);
        entryMap.put('D',500);
        entryMap.put('M',1000);
    }

    public int romanToInt(String s) {
        char[] charArray=s.toCharArray();
        int result=0;
        for(int i=0;i<charArray.length;i++){
            if(i==charArray.length-1){
                result=result+entryMap.get(charArray[i]);
            }else if(entryMap.get(charArray[i])>=entryMap.get(charArray[i+1])){
                result=result+entryMap.get(charArray[i]);
            }else {
                result=result+entryMap.get(charArray[i+1])-entryMap.get(charArray[i]);
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger=new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }
}
