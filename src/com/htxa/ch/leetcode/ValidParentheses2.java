package com.htxa.ch.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidParentheses2 {
    Map<Character, Character> charMap = new HashMap();
    {
        charMap.put('(', ')');
        charMap.put('[', ']');
        charMap.put('{', '}');
    }

    public boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }
        char[] str = s.toCharArray();
        if (s.length() % 2 == 1) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (charMap.get(str[i]) == null ) {
                if (sb.length()>0&&charMap.get(sb.charAt(sb.length() - 1)) == str[i]) {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    return false;
                }
            } else if (i<str.length-2&&charMap.get(str[i]) == str[i + 1]) {
                i++;
            } else {
                sb.append(str[i]);
            }
        }
        if (sb.length() == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        ValidParentheses2 vp = new ValidParentheses2();
        System.out.println(vp.isValid("){"));
    }
}
