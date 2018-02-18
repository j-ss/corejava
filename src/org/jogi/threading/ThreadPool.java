package org.jogi.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	public static void main(String[] args) throws InterruptedException {
		
			ExecutorService executor=Executors.newFixedThreadPool(3);
			
			//3 thread created in thread pool which perform out task
			
			for(int i=0;i<5;i++){
			executor.submit(new ProcessClass(i));
			}
			// we give 5 task to 3 thread
			
			
			executor.shutdown();//this wait for completion of task then terminate
			
			executor.awaitTermination(1, TimeUnit.HOURS);//here 1 hour is max time to complete task otherwise terminate
		
	}

}

class ProcessClass implements Runnable
{
	private int id;
	
	
	public ProcessClass(int id) {
		this.id = id;
	}


	public void run()
	{
		System.out.println("Starting "+id);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	System.out.println("Ending "+id);
	}
}
