package org.jogi.networking;


import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	public static void main(String[] args){
		
		
		
		while(true)
		{	
			try(ServerSocket serversocket=new ServerSocket(5080)){
				
				new ServerThread(serversocket.accept()).start();
			}catch(IOException e)
			{
				e.getMessage();
			}
		}
		

	}

}
