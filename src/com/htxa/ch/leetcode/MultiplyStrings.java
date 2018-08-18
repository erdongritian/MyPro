package com.htxa.ch.leetcode;

public class MultiplyStrings {
    public static void main(String[] args) {
//        char a='5';
//        char b='7';
//        System.out.println((a-'0')*(b-'0'));
        String s1="123";
        String s2="456";
        MultiplyStrings multiplyStrings=new MultiplyStrings();
        System.out.println(multiplyStrings.multiply(s1,s2));

    }

    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int num1Length=num1.length();
        int num2Length=num2.length();

        if(num1Length<num2Length){
            return multiply(num2, num1);
        }else {
            char[] num1Arrays=num1.toCharArray();
            char[] num2Arrays=num2.toCharArray();

            int temp1=0;
            int temp2=0;

            for (int i = 0; i < num1Length; i++) {
                if(i==0){
                    int args1=(num2Arrays[num2Length-1-i]-'0')*(num1Arrays[num1Length-1-i]-'0');
                    temp1=args1%10;
                    temp2=args1/10;
                    sb.append(temp1);
                }else if(i>num2Length-1){
                    int args1=(num2Arrays[0]-'0')*(num1Arrays[num1Length-1-i]-'0');
                    temp1=(temp2+args1%10)%10;
                    temp2=(temp1+args1/10)/10;
                    sb.append(temp1);
                }else {
                    int args1=(num2Arrays[num2Length-i]-'0')*(num1Arrays[num1Length-1-i]-'0');
                    int args2=(num2Arrays[num2Length-1-i]-'0')*(num1Arrays[num1Length-1-i]-'0');
                    temp1=(temp2+args1%10+args2%10)%10;
                    temp2=(temp1+args1/10+args2/10)/10;
                    sb.append(temp1);
                }

            }

            if(temp2!=0){
                sb.append(temp2);
            }

            return sb.reverse().toString();
        }
    }
}
