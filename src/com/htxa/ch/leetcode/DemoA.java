package com.htxa.ch.leetcode;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 摇筛子，一个线程读，一个线程在控制台打印，如果连续出现3个6，则退出。
 */
public class DemoA {

    LinkedList<Integer> list = new LinkedList<>();
    AtomicInteger count = new AtomicInteger();

    class Thread1 implements Runnable {
        @Override
        public void run() {
            while (count.get() < 3) {
                synchronized (list) {
                    if(list.size()>0){
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    Random random = new Random();
                    int i = random.nextInt(6) + 1;
                    list.push(i);
                    if(i==6){
                        int c=count.get()+1;
                        count.set(c);
                    }else {
                        count.set(0);
                    }

                }
            }
        }
    }

    class Thread2 implements Runnable {
        @Override
        public void run() {
            while (count.get() < 3) {
                synchronized (list) {
                    if (list.size() > 0) {
                        System.out.println(list.removeLast());
                    }else {
                        list.notify();
                    }
                }
            }
        }
    }

    public void start() {
        Thread thr1 = new Thread(new Thread1());
        thr1.start();

        Thread thr2 = new Thread(new Thread2());
        thr2.start();
    }

    public static void main(String[] args) {
        DemoA demoA = new DemoA();
        demoA.start();
    }
}
