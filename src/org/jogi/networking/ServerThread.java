package org.jogi.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

	private Socket socket=null;
	public ServerThread(Socket socket) {
	this.socket=socket;
	}
	
	public void run()
	{
	
		try(PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
				BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedReader input=new BufferedReader(new InputStreamReader(System.in)))
		{
			
			while(true){
				String s=reader.readLine();
				if(s==null)
					break;
			
			System.out.print("client : "+s+"\n"+"server : ");
			writer.println(input.readLine());
			
						}
				
	
		}catch(IOException e)
		{
			e.getMessage();
		}
		finally
		{
			try {
				socket.close();
			} catch (IOException e) {
				e.getMessage();
			}
		}
		
	}
}
