
/**
 *  create url 
 * 1- InputStream stream=url.openStream();  directly connect with input stream of server
 * 2- UrlConnection connection=url.openConnection();
 *  connection.connect();
 *  3-UrlConnection connection=url.openConnection();
 *  connection.getInputStream();  no need to call connect method impicitly call
 *  connection.getOutputStream();
 *  
 *  to send data to server encode it in a specific format like
 *   URLEncoder.encode(args[1], "UTF-8");
 *   
 *   at server decode it
 *   URLDecoder.decode(args[1], "UTF-8");
 *   
 *   
 *   InputStreamReader   InputStreamWriter
 *   
 *   
 *   socket is an end point of two way communication
 *   
 *   socket=ip+port
 *   
 *   connect using url is better but its underline implementation is socket base
 *   
 *   7976020438
 *   
 *   
 *   on connection for byte data type use
 *   
 *   OutputStreamWriter to wite data & InputStreamReader for input
 *   
 *   for character type use
 *   
 *   PrintWriter  & BufferedReader
 */
package org.jogi.networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
public class NetworkingMain {

	public static void main(String[] args) throws IOException {
		URL url=null;
		try {
			 url=new URL("https://www.udemy.com"+""
					+ "/java-the-complete-java-developer-course/learn/v4/t/lecture/4702382?start=0");
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		

		
		///URI uri=new URI("");  URl url=uri.toURL();
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getAuthority());
		System.out.println(url.getFile());
		System.out.println(url.getRef());
		
		InputStream inputStream=url.openStream();
		
		System.out.println(inputStream);
	}

}
