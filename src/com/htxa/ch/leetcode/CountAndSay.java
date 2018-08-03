package com.htxa.ch.leetcode;

public class CountAndSay {

    public static String countAndSay(int n) {
        if(n==1) {
            return "1";
        }else {
            String preStr=countAndSay(n-1);
            char[] preStrArray=preStr.toCharArray();
            char preChar='0';
            int j=0;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<preStrArray.length;i++){
                if(preChar==preStrArray[i]){
                    j++;
                }else {
                    if(preChar!='0'){
                        sb.append(j).append(preStrArray[i-1]);
                    }
                    j=1;
                    preChar=preStrArray[i];
                }
            }
            sb.append(j).append(preStrArray[preStrArray.length-1]);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

}
