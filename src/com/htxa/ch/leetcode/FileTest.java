package com.htxa.ch.leetcode;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 统计一个目录下所有类型的文件数目
 */
public class FileTest {

    public static void main(String[] args) {
        FileTest fileTest=new FileTest();
        fileTest.analyse(new File("D:\\project"));
        System.out.println(fileTest.map);
    }

    Map<String,Integer> map=new HashMap();

    private void analyse(File file){
        if(file.isFile()){
            String ext=getExtension(file);
            if(map.get(ext)==null){
                map.put(ext,1);
            }else {
                map.put(ext,map.get(ext)+1);
            }
        }else {
            for(File fi:file.listFiles()){
                analyse(fi);
            }
        }
    }

    private String getExtension(File file){
        String fileName=file.getName();
        String[] arrrays=fileName.split("\\.");
        return arrrays[arrrays.length-1];
    }
}
