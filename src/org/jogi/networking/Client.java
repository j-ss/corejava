package org.jogi.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
		
	public static void main(String[] args) throws IOException
	{
		String host="localhost";
		//int port=Integer.parseInt(args[1]);
		Socket socket=new Socket(host,5080);
		
		PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
		BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println("start conversation : yes & no");
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String s=input.readLine();
		boolean flag=false;
		if(s.equalsIgnoreCase("yes"))
		{
			flag=true;
		}
		String response="";
		while(flag){
		System.out.print("client : ");
		s=input.readLine();
		if(response==null||s.equalsIgnoreCase("no"))
		{
			break;
		}
		writer.println(s);
		response=reader.readLine();
		System.out.println("server : "+response);
		}
		writer.close();
		reader.close();
		input.close();
		socket.close();
	}

}
