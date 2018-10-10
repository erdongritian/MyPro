package com.htxa.ch.leetcode.page1;

public class IntegerToRomanV2 {
    //网上找的答案
    private static String[][] SYMARRAY = new String[][] {
            {"","I","II","III","IV","V","VI","VII","VIII","IX"}, // 0,1,2,3,...,9
            {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"}, // 0,10,20,30,...,90
            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"}, // 0,100,200,300,...,900
            {"","M","MM","MMM",null,null,null,null,null,null} // 0,1000,2000,3000
    };
    public String intToRoman(int num) {
        return SYMARRAY[3][num/1000] + SYMARRAY[2][num%1000/100] + SYMARRAY[1][num%100/10] + SYMARRAY[0][num%10];
    }
}
