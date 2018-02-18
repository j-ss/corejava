package org.jogi.threading;

public class ThreadTest extends Thread
{
		public void run()
		{
			for(int i=0;i<10;i++)
			{
				System.out.println("hello"+i);
				try{
				Thread.sleep(1000);
				}catch(InterruptedException e)
				{
					e.getMessage();
					e.printStackTrace();
				}
			}
		}
}
