package com.htxa.ch.leetcode;


public class LongestPalindromicSubstringV4 {

    public static void main(String[] args) {
        LongestPalindromicSubstringV4 lps = new LongestPalindromicSubstringV4();
        long t1=System.currentTimeMillis();
//        System.out.println(lps.longestPalindrome("abcdbbfcba"));
        System.out.println(lps.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(System.currentTimeMillis()-t1);
    }

    //和V3版本比较优化不必要的字符串截取,从运行结果来看，没有比V3时间更短
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        int maxLength=1;
        int start_index=0;
        int end_index=1;

        for (int i = 0; i < s.length()-maxLength; i++) {
            for (int j = s.length(); j > i + 1; j--) {
                if (isPalindromic(s,i,j-1)) {
                    if (j > s.length() - 2) {
                        return s.substring(i, j);
                    } else {
                        if (j-i > maxLength) {
                            start_index=i;
                            end_index=j;
                            maxLength=j-i;
                            break;
                        }
                    }
                }
            }
        }

        return s.substring(start_index, end_index);
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
