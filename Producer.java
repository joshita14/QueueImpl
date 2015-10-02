package com.interview.prep.queue;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	
	private final BlockingQueue<Integer> queue;
	
	Producer(BlockingQueue<Integer> q ){
		this.queue = q;
	}

	@Override
	public void run() {
		try{
			for(int i=0;i<10;i++){
				queue.put(i);
			}
			
			Iterator<Integer> ite = queue.iterator();
			
			while(ite.hasNext()){
				System.out.println("Printing  "+ite.next());
			}
		}catch(InterruptedException e){
			System.out.println("The add operation in blocking queue is interrupted");
		}
		
		System.out.println("Element was added \n");
		
		
	}
}
