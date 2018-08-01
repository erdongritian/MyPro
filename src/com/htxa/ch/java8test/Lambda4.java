package com.htxa.ch.java8test;

/**
 * Created by chenh on 2017/3/2.
 */
public class Lambda4 {
    static int outerStaticNum;
    int outerNum;
    void testScopes(){
        Converter<Integer,String> stringConverter=(from -> {
           outerNum=23;
            return String.valueOf(from);
        });

        Converter<Integer,String> stringConverter1=from -> {
            outerStaticNum=77;
            return String.valueOf(from);
        };
    }
}
