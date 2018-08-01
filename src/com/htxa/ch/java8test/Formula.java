package com.htxa.ch.java8test;

/**
 * Created by chenh on 2017/3/2.
 */
public interface Formula {
    double calculate(int a);
    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
