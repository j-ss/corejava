package org.jogi.process;
import java.io.*;
import java.util.function.Function;
public class Processor {

	public static void main(String[] args) throws IOException{
		Runtime runtime=Runtime.getRuntime();
		
		//Process process=runtime.exec("gedit");
		String[] str={"gedit","notepad"};
		runtime.addShutdownHook(new Thread(()->{
			try {
				runtime.exec(str);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}));
		
		//process.destroy();
		
		System.out.println(runtime.availableProcessors());
		System.out.println(runtime.freeMemory());
		System.out.println(runtime.totalMemory());
		System.out.println(runtime.maxMemory());
		
		runtime.runFinalization();
		
		//System.exit(0);
	}
	
	@Override
	protected void finalize() throws Throwable {
		
		Function<String,String> result=(action)->action.toLowerCase();
		
		result.apply("jogendra");
	}

}
