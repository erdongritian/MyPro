package com.htxa.ch.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheV3 {
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCacheV3(int capacity) {
        this.cache = new LinkedHashMap(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return this.cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        this.cache.put(key, value);
    }
}
