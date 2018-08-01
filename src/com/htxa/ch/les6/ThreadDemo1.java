package com.htxa.ch.les6;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadDemo1 {
	public static void main(String[] args) {
		final Output output = new Output();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					output.print("helloworld");
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					output.print("BYE-BYE");
				}
			}
		}).start();
	}

}
class Output{
	private Lock lock = new ReentrantLock();
	public void print(String name){
		lock.lock();
		try{
			for(int i = 0; i < name.length();i++){
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}finally{
			lock.unlock();
		}
	}
}
class Cache{
	private HashMap<String, String> cache = new HashMap<String,String>();
	private ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
	private String value;//共享数据
	//考虑多线程的情况，读的时候大家都可以来读，有一个写产生，那么就要互斥
	//java5开始提供了读写锁
	//读锁之间不是互斥的，读写是互斥，写和写也是互斥的。
	public String getValue(String key){
		rrwl.readLock().lock();
		try{
			value = cache.get(key);
			if(value==null){
				rrwl.readLock().unlock();
				rrwl.writeLock().lock();
				try{
					if(value==null){
						value = "hello";//后台获取数据
						cache.put(key, value);
					}
				}finally{
					rrwl.writeLock().unlock();
					rrwl.readLock().lock();
				}
			}
		}finally{
			rrwl.readLock().unlock();
		}
		return value;
	}





}