package com.interview.prep.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueImpl extends Thread{
	
	
	public static void main(String[] args) {
		
		final BlockingQueue<Integer> sharedqueue = new LinkedBlockingQueue<Integer>();

		Thread t = new Thread(new Producer(sharedqueue));

		Thread t1 = new Thread(new Consumer(sharedqueue));
	
		t.start();
		
		t1.start();
		try {
			t.join();
			System.out.println(t.isAlive());
			t1.join();
			System.out.println(t1.isAlive());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
