package com.htxa.ch.leetcode;


public class LongestPalindromicSubstringV3 {

    public static void main(String[] args) {
        LongestPalindromicSubstringV3 lps = new LongestPalindromicSubstringV3();
        long t1=System.currentTimeMillis();
//        System.out.println(lps.longestPalindrome("abcdbbfcba"));
        System.out.println(lps.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(System.currentTimeMillis()-t1);
    }

    //和V1版本比较优化不必要的字符串截取
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        String result = s.substring(0, 1);

        for (int i = 0; i < s.length()-result.length(); i++) {
            for (int j = s.length(); j > i + 1; j--) {
                if (isPalindromic(s,i,j-1)) {
                    if (j > s.length() - 2) {
                        return s.substring(i, j);
                    } else {
                        if (j-i > result.length()) {
                            result = s.substring(i, j);
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }

    public boolean isPalindromic(String str,int low,int high) {
        while (low<=high){
            if(str.charAt(low)!=str.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
