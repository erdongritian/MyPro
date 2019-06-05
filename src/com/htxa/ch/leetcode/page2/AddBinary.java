package com.htxa.ch.leetcode.page2;

public class AddBinary {

    public static void main(String[] args) {
        AddBinary addBinary=new AddBinary();
        System.out.println(addBinary.addBinary("1010","1011"));
    }

    public String addBinary(String a, String b) {

        char[] aChars=a.length()>b.length()?a.toCharArray():b.toCharArray();
        char[] bChars=a.length()<=b.length()?a.toCharArray():b.toCharArray();

        int flag=0;
        int bLength=bChars.length;
        for (int i = aChars.length-1; i >-1; i--) {
            if(bLength>0){
                if(bChars[bLength-1]=='1'&&flag==0&&aChars[i]=='1'){
                    aChars[i]='0';
                    flag=1;
                }else if(bChars[bLength-1]=='0'&&flag==1&&aChars[i]=='1'){
                    aChars[i]='0';
                }else if(bChars[bLength-1]=='0'&&flag==1&&aChars[i]=='0'){
                    aChars[i]='1';
                    flag=0;
                }else if(bChars[bLength-1]=='1'&&flag==0&&aChars[i]=='0'){
                    aChars[i]='1';
                }

                bLength--;
            }else {
                if(flag==1){
                    if(aChars[i]=='0'){
                        aChars[i]='1';
                        flag=0;
                    }else {
                        aChars[i]='0';
                    }
                }else {
                    break;
                }
            }

        }
        if(flag==0){
            return new String(aChars);
        }else {
            return "1"+new String(aChars);
        }

    }
}
