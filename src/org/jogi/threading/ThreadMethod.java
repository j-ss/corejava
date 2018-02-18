package org.jogi.threading;

public class ThreadMethod {

	public static void main(String[] args) {

		ProducerConsumer t=new ProducerConsumer();
		
		
		Thread thread1=new Thread(()->{
			try {
				t.producer();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		});
		Thread thread2=new Thread(()->{
			try {
				t.consumer();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		});
		
		thread1.start();
		thread2.start();
	}

}
//Lock lock=new ReentantLock();
//lock.lock();
//lock.unlock();//put in try catch
