// Creating a client in java

import java.io.*;
import java.net.*;

class client{

	public static void main(String args[]) throws Exception{

		// Create a socket with same port no as server
		Socket s = new Socket("localhost", 777);

		// Create input stream obj to receive server output
		InputStream obj = s.getInputStream();

		// Attach this inputStream to bufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(obj));

		String str = "";
		while((str = br.readLine()) != null)
		  System.out.println("From Server "+str);

		s.close();
		br.close();
			

	}

}