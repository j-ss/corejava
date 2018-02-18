package org.jogi.threading;

import java.util.Scanner;

public class ThreadShareVar {

	
	public static void main(String[] ARG)
	{
		Test t=new Test();
		new Thread(t).start();
		System.out.println("fgfgfhfg");
		Scanner scn=new Scanner(System.in);
		scn.nextLine();
		
		t.shutdown();
	}
}

class Test implements Runnable
{
	private boolean running=true;
	
	public void run()
	{
		while(running)
		System.out.println("thraaea");
	}
	
	public void shutdown()
	{
		running=false;
	}
}
