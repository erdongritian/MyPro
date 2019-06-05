package com.htxa.ch.leetcode.page1;

public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger stringToInteger=new StringToInteger();
        System.out.println(stringToInteger.myAtoi("  -0012a42"));
//        System.out.println(Integer.MIN_VALUE);
    }

    public int myAtoi(String str) {

        char[] charArray=str.trim().toCharArray();
        int result;

        for (int i = 0; i < charArray.length; i++) {
            if(i==0&&charArray[i]=='-'){
                result=-1;
            }else {
                result=Integer.valueOf(charArray[0]);
            }
        }
        return 0;

//        str=str.trim();
//        String[] arr=str.split(" ");
//        int result=0;
//        long temp;
//        try {
//            arr[0]=arr[0].split("\\.")[0];
//            temp=Long.parseLong(arr[0]);
//            if(temp>Integer.MAX_VALUE){
//                result= Integer.MAX_VALUE;
//            }else if(temp<Integer.MIN_VALUE){
//                result= Integer.MIN_VALUE;
//            }else {
//                result=Integer.parseInt(arr[0]);
//            }
//
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }finally {
//            return result;
//        }

    }
}
