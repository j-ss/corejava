package org.jogi.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemophereClass {

	public static void main(String[] args) {
		//a semophere restrict the number of resource create
		//if we want max 10 connection use it
		//Semaphores are often used to restrict the number of threads than can access some
		//(physical or logical) resource. F
			/*
			 * diff bw cachedThreadPool and FixedThreadPool
			 * cache thread pool is used for short task
			 * it is dynamically growable
			 * fixedthreadpoo is used for long running task
			 * but fixed in size not growable 
			 */
		//true mean waiting thread get permit in the order they come for resource
		//Semaphore sem=new Semaphore(10,true);
		
		//here a t a time max 10 thread accress connection class method
		
		// these are like lock
		//but in lock we unclok from same thread but here we unlock from any thread
		ExecutorService executor=Executors.newCachedThreadPool();
		
		for(int i=0;i<50;i++)
		{
			Thread t1=new Thread(new Runnable(){
				@Override
				public void run()
				{
					Connection.getInstance().connect();	
				}
			});
			
			executor.submit(t1);
			
//			Thread t2=new Thread(()->Connection.getInstance().connect());
//			executor.submit(t2);
		}
		
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Connection
{
	private static Connection instance=new Connection();
	private int connections=0;
	private Connection(){}
	private Semaphore sem=new Semaphore(10,true);
	public static Connection getInstance()
	{
		return instance;
	}
	
	public void connect()
	{
		try{
			doConnect();
		}
		finally {
			sem.release();
		}
		
	}
	public void doConnect()
	{
		
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			
		}
		synchronized (this) {
			connections++;
			System.out.println("i got connection"+connections);
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (this) {
			connections--;
		}
	}
}
