package com.htxa.ch.leetcode;

public class PalindromeTest {


    public boolean isPalindrome(int x) {
//        if(x<0){
//            return false;
//        }
//        List<Integer> list=new ArrayList<>();
//        while (x!=0){
//            list.add(x%10);
//            x/=10;
//        }
//
//        int length=list.size();
//        for(int i=0;i<length/2;i++){
//            if(list.get(i)!=list.get(length-i-1)){
//                return false;
//            }
//        }
//        return true;
        int m=0;
        if(x%10==0){
            return false;
        }
        while (x>m){
            m=m*10+x%10;
            x/=10;
        }
        return x==m||m/10==x;

    }

    public static void main(String[] args) {
        PalindromeTest palindromeTest=new PalindromeTest();
        System.out.println(palindromeTest.isPalindrome(10));
    }
}
