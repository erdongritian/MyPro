package com.htxa.ch.mytest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chenh on 2017/1/13.
 */
public class LockTest {

    private Lock lock=new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        final LockTest lockTest=new LockTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.t1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.t2();
            }
        }).start();
    }

    public void t1(){
        try {
            lock.lock();
            System.out.println("t1#########begin");
            condition.await();
            Thread.sleep(3000);
            System.out.println("t1#########end");
        } catch (InterruptedException e) {

        } finally{
            lock.unlock();
        }
    }
    public void t2(){
        try {
            lock.lock();
//            Thread.sleep(3000);
            System.out.println("t2#########");

        }finally{
            lock.unlock();
        }
    }

    public synchronized void t3(){
        System.out.println("t3############begin");
        try {
            Thread.sleep(3000);
            System.out.println("t3############end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void t4(){
        System.out.println("t4############");
    }
}
