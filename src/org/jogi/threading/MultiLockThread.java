package org.jogi.threading;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultiLockThread {

	private static Object lock1=new Object(); 
	private static Object lock2=new Object();
	private static Random random=new Random();
	private static List<Integer> list1=new ArrayList<>();
	private static List<Integer> list2=new ArrayList<>();
	
		public static void main(String[] args)
		{
			
			Thread t1=new Thread(()->process());
			Thread t2=new Thread(()->process());
			t1.start();
			t2.start();
			
			
			long start=System.currentTimeMillis();
			
			System.out.println(list1);
			System.out.println(list2);
		}
		
		public static void stageOne()
		{
			
			synchronized(lock1)
			{
				for(int i=0;i<10;i++)
				list1.add(random.nextInt(100));
			}
		}
		
		public static void stageTwo()
		{
			synchronized(lock2)
			{
				for(int i=0;i<10;i++)
				list2.add(random.nextInt(100));
			}
		}
		
		public static void process()
		{
			stageOne();
			stageTwo();
		}
		
		
}
