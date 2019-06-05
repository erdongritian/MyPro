package com.htxa.ch.leetcode.page2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SimplifyPath {

    public static void main(String[] args) {
//        String str="/a/./b/../../c/";
//        String str="/home//foo/";
        String str="/a/../../b/../c//.//";
        SimplifyPath simplifyPath=new SimplifyPath();

        System.out.println(simplifyPath.simplifyPath(str));
    }

    public String simplifyPath(String path) {
        String[] strArray=path.split("/");
        List<String> stringList=new ArrayList<>();

        for (int i = 0; i < strArray.length; i++) {
            String s=strArray[i];

            if("".equals(s)||".".equals(s)){
                continue;
            }
            if("..".equals(s)){
                if(stringList.size()>0){
                    stringList.remove(stringList.size()-1);
                }
            }else {
                stringList.add(s);
            }
        }

        return "/"+stringList.stream().collect(Collectors.joining("/"));
    }
}
