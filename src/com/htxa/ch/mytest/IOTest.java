package com.htxa.ch.mytest;

import java.io.*;

public class IOTest {
    public static void main(String[] args){
        try {
            BufferedReader br=new BufferedReader(new FileReader(""));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader=new FileReader("");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//
//        try {
//            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("")));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        try {
            PrintWriter pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream("")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter pw=new PrintWriter("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream os=new ObjectInputStream(new FileInputStream(""));
            os.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
