package org.jogi.threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDown {

	public static void main(String[] args) {
		
		
		/*
		 * here countdown latch(threadsafe) is 3 it mean first 3 thread complete its task 
		 * then rest of code is execute await() method await untill latch count 
		 * not equal to zero
		 */
			CountDownLatch latch=new CountDownLatch(3);
			
			ExecutorService executor=Executors.newFixedThreadPool(5);
			
			for(int i=0;i<3;i++)
			{
				executor.submit(new Processor(latch));
			}
			
			try {
				latch.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//now put rest code which we want to execute 
			
			executor.submit(new Processor());
			
			
			executor.shutdown();
			try {
				executor.awaitTermination(10, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}


class Processor implements Runnable
{
	private CountDownLatch latch;
	
	public Processor()
	{
		
	}
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}


	public void run()
	{
	
		System.out.println("started");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(latch.getCount());
		System.out.println("completed");
		latch.countDown();
	}
}

