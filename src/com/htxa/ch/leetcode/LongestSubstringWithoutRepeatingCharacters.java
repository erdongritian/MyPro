package com.htxa.ch.leetcode;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        LinkedList<Character> linkedList=new LinkedList<>();
//        linkedList.addLast('a');
//        linkedList.addLast('b');
//        linkedList.addLast('b');
//        System.out.println(linkedList.indexOf('c'));
//
//        LinkedHashSet<Character> charSet = new LinkedHashSet<>();
//        System.out.println(charSet.add('a'));
//        System.out.println(charSet.add('a'));

    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLenght=0;
        char[] strArray=s.toCharArray();
        LinkedList<Character> linkedList=new LinkedList<>();

        for(int i=0;i<strArray.length;i++){
            if(i==0){
                linkedList.addFirst(strArray[i]);
                maxLenght++;
            }else {
                int j=linkedList.indexOf(strArray[i]);
                if(j!=-1){
                    if(linkedList.size()>maxLenght){
                        maxLenght=linkedList.size();
                    }
                    linkedList.addLast(strArray[i]);
                    while (j>-1){
                        j--;
                        linkedList.pop();
                    }
                }else {
                    linkedList.addLast(strArray[i]);
                }
            }
        }

        if(linkedList.size()>maxLenght){
            maxLenght=linkedList.size();
        }

        return maxLenght;
    }
}
