package org.jogi.threading;

import java.util.Scanner;

public class ProducerConsumer  {

	
	public void producer()throws InterruptedException
	{
		synchronized(this)
		{
			System.out.println("producer is running");
			wait();//stop this thread execution and release lock on object and goes waiting state
			System.out.println("producer resumed");
		}
	}
	
	public void consumer() throws InterruptedException
	{
		/*
		 * thread is in sleep mode and in this time but its not acquire 
		 * lock.
		 */
		Thread.sleep(2000);
		synchronized(this)
		{
			System.out.println("consumer running");
			Scanner scn=new Scanner(System.in);
			System.out.println("press return for resume");
			scn.nextLine();
			/*
			 * notify method inovoke a thread which is waiting on monitor its 
			 * not immediatly invoke thread will be invoke when its execution complte
			 */
			notify();
			
			Thread.sleep(5000);
			//sleep method put thread in sleep mode but lock is still held by this thread
		}
	}
}
