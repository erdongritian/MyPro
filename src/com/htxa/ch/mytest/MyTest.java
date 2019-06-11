package com.htxa.ch.mytest;

public class MyTest {
    public static void main(String[] args) {
//        Student s1=new Student();
//        Student s2=s1;
//        s2.a=3;
//        System.out.println(s1.a);

        Singleton singleton=Singleton.getInstance();

    }

    static class Student{
        int a;
        int b;
    }

}
