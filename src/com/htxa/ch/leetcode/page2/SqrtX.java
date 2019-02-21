package com.htxa.ch.leetcode.page2;

public class SqrtX {

    public static void main(String[] args) {
        SqrtX sqrtX=new SqrtX();
        System.out.println(sqrtX.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if(x<=1)return x;

        int start=1,end=x;
        int flag=(end-start)/2;

        while (flag>=1){
            int s=x/(flag+start);
            if(s<(flag+start)){
                end=start+flag;
            }else if(s>(flag+start)){
                start=start+flag;
            }else {
                return flag+start;
            }
            flag=(end-start)/2;
        }
        return start;
    }
}
