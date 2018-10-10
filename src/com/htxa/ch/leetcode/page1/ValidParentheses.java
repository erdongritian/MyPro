package com.htxa.ch.leetcode.page1;

import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    Map<Character,Character> charMap=new HashMap();
    {
        charMap.put('(',')');
        charMap.put('[',']');
        charMap.put('{','}');
    }

    public boolean isValid(String s) {
        String originalStr="";
        if("".equals(s)){
            return true;
        }

        while (!s.equals(originalStr)){
            originalStr=s;
            char[] str=s.toCharArray();

            if(s.length()%2==1){
                return false;
            }

            StringBuilder sb=new StringBuilder();
            for(int i=0;i<str.length;i++){
                if(charMap.get(str[i])==null){
                    sb.append(str[i]);
                }else if(i==str.length-1){
                    sb.append(str[i]);
                }else if(charMap.get(str[i])==str[i+1]){
                    i++;
                }else {
                    sb.append(str[i]);
                }
            }
            if(sb.length()==0){
                return true;
            }
            s=sb.toString();
        }
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses vp=new ValidParentheses();
        System.out.println(vp.isValid("[(({}))}]"));
    }
}
