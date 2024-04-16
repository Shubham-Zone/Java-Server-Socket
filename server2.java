// Server2 - A server that receives data and sends data

import java.io.*;
import java.net.*;

class server2{

	public static void main(String args[]) throws Exception{

		// Create server socket
		ServerSocket ss = new ServerSocket(888);
		
		// Connect it to client socket
		Socket s = ss.accept();
		System.out.println("Connection Established");

		// Create a output stream to send data to client
		OutputStream obj = s.getOutputStream();

		// Attach output stream to printStream
		PrintStream ps = new PrintStream(obj);

		// Create a buffered reader to read data from client
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

		// Create a stream to read data from keyboard
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

		// Server executes continuously
  		while(true){

			String str, str1;
			while((str = br.readLine()) != null){
				
				System.out.println(str);
				str1 = kb.readLine();
				ps.println(str1);

			}

			ps.close();
			br.close();
			kb.close();
			ss.close();
			s.close();
			System.exit(0); // terminate the application
			
			

		}

	}

}