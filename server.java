// Creating a server in java

import java.io.*;
import java.net.*;

class Server{

	public static void main(String args[]) throws Exception{

		// Create a socket
		ServerSocket ss = new ServerSocket(777);
		
		// Wait until client accept the request
		Socket s = ss.accept();
		System.out.println("Connection Established");
		
		// Create object to output stream class
		OutputStream obj = s.getOutputStream();

		// Attach output stream to printstream to send data to client
		PrintStream ps = new PrintStream(obj);

		String str = "Hello Client";
		ps.println(str);
		ps.println("Bye");

		ss.close();
		s.close();
		ps.close();


	}

}