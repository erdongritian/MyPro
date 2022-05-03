package com.htxa.ch.leetcode;

import java.util.*;

public class LRUCacheV2 {
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>(16,0.75f,true);
    int capacity = 0;

    public LRUCacheV2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        return cache.getOrDefault(key,-1);
//        Integer value = cache.get(key);
//        if (value == null) {
//            return -1;
//        }
//        cache.remove(Integer.valueOf(key));
//        cache.put(key,value);
//        return value;
    }

    public void put(int key, int value) {
        if(cache.keySet().contains(key)){
            cache.remove(key);
        }
        cache.put(key, value);
        if (cache.size() > capacity) {
            cache.remove(cache.keySet().iterator().next());
        }
    }
}
