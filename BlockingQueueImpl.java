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
			System.out.println("HERE : "+t.isAlive());  //line 17
			
			t1.join();
			System.out.println(t1.isAlive());
			
			/*
			 * Good concept with join :
			 * Remember join() as the currently running thread will join to the end of the thread on which join is called).
			 * Hence main thread will come to line 17 only when thread t has finished.
			 * So it may appear that t.join will affect thread t1, but it is actually affecting main thread.
			 */
			
			/*
			 * You see Producer Thread  produced number and Consumer thread consumes it in 
			 * FIFO order because blocking queue allows elements to be accessed in FIFO.
             * Read more: http://javarevisited.blogspot.com/2012/02/producer-consumer-design-pattern-with.html#ixzz3nOWzgmKB
			 */
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
