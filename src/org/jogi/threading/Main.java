package org.jogi.threading;

public class Main {

	public static void main(String[] args) {
		
		ThreadTest object =new ThreadTest();
		object.start();
		
		Thread thread=new Thread(new RunnableThread());
		thread.start();
		
		for(int i=0;i<10;i++)
		{
			System.out.println("main thread"+i);
		}

		// anony,ous class
				Thread t=new Thread(new Runnable()
				{
				public void run()
				{
					System.out.println("class name of anonymous"+getClass().getName());
					for(int i=0;i<10;i++)
					{
						System.out.println("anonymous thread"+i);
					}
				}
				});
				t.start();
				
				//lambada
				
				Thread t1=new Thread(()->System.out.println("inside lambada"));
				t1.start();
	}

}

class RunnableThread implements Runnable
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("Runnable"+i);
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
