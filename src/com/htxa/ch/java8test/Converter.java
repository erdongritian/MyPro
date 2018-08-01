package com.htxa.ch.java8test;

/**
 * Created by chenh on 2017/3/2.
 */
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);
//    void get();
}
