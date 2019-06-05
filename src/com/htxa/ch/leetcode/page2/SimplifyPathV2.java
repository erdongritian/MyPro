package com.htxa.ch.leetcode.page2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SimplifyPathV2 {

    public static void main(String[] args) {
//        String str="/a/./b/../../c/";
//        String str="/home//foo/";
        String str="/a/../../b/../c//.//";
        SimplifyPathV2 simplifyPath=new SimplifyPathV2();

        System.out.println(simplifyPath.simplifyPath(str));
    }


    public String simplifyPath(String path) {
        String[] strArray=path.split("/");

        for (int i = 0; i < strArray.length; i++) {
            String s=strArray[i];

            if("".equals(s)||".".equals(s)){
                strArray[i]="";
            }else if("..".equals(s)){
                int flag=i-1;
                while (flag>-1) {
                    if(!strArray[flag].equals("")){
                        strArray[flag]="";
                        break;
                    }else {
                        flag--;
                    }
                }
                strArray[i]="";
            }
        }

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            if(!strArray[i].equals("")){
                sb.append("/");
                sb.append(strArray[i]);
            }
        }

        return sb.toString();
    }
}
