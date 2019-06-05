package com.htxa.ch.leetcode.page1;

public class ZigZagConversion {

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion=new ZigZagConversion();
        System.out.println(zigZagConversion.convert("PAYPALISHIRING",4));
    }

    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        char[] charArray=s.toCharArray();
        int charLength=charArray.length;
        char[] resultChar=new char[charLength];
        int i=0;
        int resultIndex=0;
        while (i < numRows) {

            for (int j = 0; j < charLength; j++) {

                if(i>0){
                    if(resultIndex>charLength){
                        break;
                    }

                    if(i<charLength&&j==0){
                        //最左
                        resultChar[resultIndex]=charArray[i];
                        resultIndex++;
                    }

                    if((2*numRows-2)*(j+1)-i<charLength){

                        if(i<numRows-1){
                            //左
                            resultChar[resultIndex]=charArray[(2*numRows-2)*(j+1)-i];
                            resultIndex++;
                        }

                        if((2*numRows-2)*(j+1)+i<charLength){
                            //右
                            resultChar[resultIndex]=charArray[(2*numRows-2)*(j+1)+i];
                        }else {
                            break;
                        }

                    }else {
                        break;
                    }


                }else {

                    //第一行
                    if((2*numRows-2)*j>charArray.length-1){
                        break;
                    }
                    resultChar[resultIndex]=charArray[(2*numRows-2)*j];
                }

                resultIndex++;

            }
            i++;
        }


        return new String(resultChar);
    }
}
