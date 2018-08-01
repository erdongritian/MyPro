package com.htxa.ch.les6;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo2 {
	public static void main(String[] args) {
		final Bus bus = new Bus();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				bus.send();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				bus.rec();
			}
		});
		t2.setDaemon(true);
		t1.start();
		t2.start();
	}
}
class Bus{
	private boolean flag;
	private int theValue;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	public void send(){
		System.out.println("send:"+flag);
		for(int i = 1; i <= 5;i++){
			lock.lock();
			System.out.println("sendi:"+i);
			try{
				while(flag){
					try {
						//this.wait();
						System.out.println("send:"+44);
						condition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				theValue = new Random().nextInt(1000);
				System.out.println("send the value is :"+theValue);
				flag = true;
				//this.notify();
				condition.signal();

			}finally{
				lock.unlock();
			}
			
		}
	}
	public void rec(){
		System.out.println("rec:"+flag);
		while(true){
			lock.lock();
			System.out.println("rec:"+65);
			try {
				while(!flag){
					try {
						System.out.println("rec:"+69);
						//this.wait();
						condition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("rec the value is :"+theValue);
				flag = false;
				//this.notify();
				condition.signal();
			}finally{
				lock.unlock();
			}
		}
	}
}
