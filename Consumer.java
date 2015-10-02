package com.interview.prep.queue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	private final BlockingQueue<Integer> queue;
	
	Consumer(BlockingQueue<Integer> q){
		this.queue = q;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	try{
		while(true){
			Integer x = queue.take();
			
			System.out.println("Consumer is consuming  "+x);
		}
		
	}	catch(InterruptedException e){
		System.out.println("The thread is interrupted");
	}
		
	}
}
