package com.htxa.ch.mytest;

import java.util.LinkedHashMap;

public class TestMap {
    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        map.put(1,3);
        map.put(12,3);
        map.put(1,3);

        System.out.println(map.keySet());

    }
}
