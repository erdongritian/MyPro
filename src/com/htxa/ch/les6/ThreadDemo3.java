package com.htxa.ch.les6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo3 {


	public static void main(String[] args) {
		//  ExecutorService threadPool = Executors.newFixedThreadPool(3);
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		for(int i = 1 ; i <= 10;i++){
			final int task= i;
			threadPool.execute(new Runnable() {

				@Override
				public void run() {
					for(int j = 1; j <= 10;j++){
						System.out.println(Thread.currentThread()+" 执行第"+task+"个任务的第"+j+"次循环");
					}
				}
			});
		}

	}

}
