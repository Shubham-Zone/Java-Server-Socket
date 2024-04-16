// File Client

import java.io.*;
import java.net.*;

class FileClient{

	
	public static void main(String args[]) throws Exception{


		// Creata client socket
		Socket s = new Socket("localhost", 8888);
		
		// Accept filename from keyboard
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

		String fname = kb.readLine();

		// Send fileName to the server using DataOutputStream
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		dos.writeBytes(fname + "\n");

		// to read data coming from server
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

		String str;

		// read first line from server
		str = in.readLine();

		if(str.equals("Yes")){

			while((str = in.readLine()) != null)	
                           System.out.println(str);

			kb.close();
			in.close();
			dos.close();
			s.close();
			
		
		}
		else System.out.println("File not found");


	}


}