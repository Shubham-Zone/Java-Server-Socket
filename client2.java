// Client2 - a client that sends data and receives also

import java.io.*;
import java.net.*;

class client2{

	public static void main(String args[]) throws Exception{

		
		// Create client socket
		Socket s = new Socket("localhost", 888);

		// to send data to server
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		// to read data from the server
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

		// to read data from the keyboard
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

		String str, str1;
		while(!(str = kb.readLine()).equals("exit")){

			dos.writeBytes(str + "\n");
			str1 = br.readLine();
			System.out.println(str1);


		}
  		

		// Close Connection
		dos.close();
		kb.close();
		s.close();
		br.close();

	}


}