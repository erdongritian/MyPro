package com.htxa.ch.leetcode.page1;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman integerToRoman=new IntegerToRoman();
        System.out.printf(integerToRoman.intToRoman(58));
    }

    Map<Integer, String> entryMap = new HashMap<>();
    {
        entryMap.put(1, "I");
        entryMap.put(2, "II");
        entryMap.put(3, "III");
        entryMap.put(4, "IV");
        entryMap.put(5, "V");
        entryMap.put(6, "VI");
        entryMap.put(7, "VII");
        entryMap.put(8, "VIII");

        entryMap.put(9, "IX");
        entryMap.put(10, "X");
        entryMap.put(20, "XX");
        entryMap.put(30, "XXX");
        entryMap.put(40, "XL");
        entryMap.put(50, "L");
        entryMap.put(60, "LX");
        entryMap.put(70, "LXX");
        entryMap.put(80, "LXXX");

        entryMap.put(90, "XC");
        entryMap.put(100, "C");
        entryMap.put(200, "CC");
        entryMap.put(300, "CCC");
        entryMap.put(400, "CD");
        entryMap.put(500, "D");
        entryMap.put(600, "DC");
        entryMap.put(700, "DCC");
        entryMap.put(800, "DCCC");

        entryMap.put(900, "CM");
        entryMap.put(1000, "M");
        entryMap.put(2000, "MM");
        entryMap.put(3000, "MMM");
        entryMap.put(3000, "MMM");
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int flag = 1;
        int n;

        while (num  > 0 ) {

            n = (num % 10) * flag;
            num = num / 10;

            if(n==0){
                flag*=10;
                continue;
            }
            flag*=10;
            sb.insert(0,entryMap.get(n));
        }

        return sb.toString();
    }
}
