package com.htxa.ch.leetcode;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 摇筛子，一个线程读，一个线程在控制台打印，如果连续出现3个6，则退出。
 */
public class BlockQueueTest {
    public static void main(String[] args) {
        BlockQueueTest blockQueueTest=new BlockQueueTest();
        blockQueueTest.start();
    }

    private void start(){
        Bus bus=new Bus();

        new Thread(bus::send).start();
        new Thread(bus::take).start();
    }

    class Bus{
        BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(1);
        AtomicInteger integer=new AtomicInteger();

        private void send(){
            while (integer.get()<3){
                Random random=new Random();
                int i=random.nextInt(6)+1;
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i==6){
                    int c=integer.get()+1;
                    integer.set(c);
                }else {
                    integer.set(0);
                }
            }
        }

        private void take(){
            while (integer.get()<3||queue.size()!=0){
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
