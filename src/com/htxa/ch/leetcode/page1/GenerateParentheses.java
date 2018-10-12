package com.htxa.ch.leetcode.page1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses generateParentheses=new GenerateParentheses();
        generateParentheses.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();

//        char[] strList=new char[n*2];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//
//            }
//        }
//        new String(strList);
        LinkedList<Character> characters=new LinkedList<>();

        characters.add('(');
        characters.add(')');


        int x=1; //()内的index
        int y=2; //()外的index


        for (int i = 0; i < n-1; i++) {

//            for (int j = 0; j < n - 1; j++) {
//                if(i==0){
//                    //内
//                    characters.add(x,'(');
//                    x++;
//                    characters.add(x,')');
//                    y=y+2;
//                }else {
//                    //外
//                    characters.add(y,'(');
//                    y++;
//                    characters.add(y,')');
//                    y++;
//                    x=x+2;
//                }
//            }

//            if(i==0){
//                //内
//                characters.add(x,'(');
//                x++;
//                characters.add(x,')');
////                y=y+2;
//                y++;
//            }else {
//                //外
//                characters.add(y,'(');
//                y++;
//                characters.add(y,')');
//                y++;
//                x=x+2;
//            }

            if(i==1){
                //内
                characters.add(x,'(');
                x++;
                characters.add(x,')');
//                y=y+2;
                y++;
            }else {
                //外
                characters.add(y,'(');
                y++;
                characters.add(y,')');
                y++;
//                x=x+2;
            }





        }

//        new String();

        System.out.println(characters);


        return result;
    }
}
