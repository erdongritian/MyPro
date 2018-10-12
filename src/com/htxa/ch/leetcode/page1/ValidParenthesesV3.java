package com.htxa.ch.leetcode.page1;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParenthesesV3 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            if (c == '{') { stack.push('}'); continue; }
            if (c == '[') { stack.push(']'); continue; }
            if (c == '(') { stack.push(')'); continue; }
            if (stack.isEmpty() || stack.pop() != c) { return false; }
        }
        return stack.isEmpty();
    }
}
