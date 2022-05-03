package com.htxa.ch.leetcode;

import java.util.*;

public class LRUCache {
    public static void main(String[] args) {

    }

    Map<Integer, Integer> cache = new HashMap<>();
    int capacity = 0;
    LinkedList<Integer> keyList = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = cache.get(key);
        if (value == null) {
            return -1;
        }
        keyList.remove(Integer.valueOf(key));
        keyList.add(key);
        return value;
    }

    public void put(int key, int value) {
        if (cache.put(key, value) == null) {
            if (keyList.size() == capacity) {
                cache.remove(keyList.get(0));
                keyList.remove();
            }
        } else {
            keyList.remove(Integer.valueOf(key));
        }
        keyList.add(key);
    }
}
