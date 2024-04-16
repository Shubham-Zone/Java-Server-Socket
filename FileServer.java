// File Server

import java.io.*;
import java.net.*;

class FileServer{


	public static void main(String args[]) throws Exception{

		// Create a server socket
		ServerSocket ss = new ServerSocket(8888);

		// wait till client accepts connection
		Socket s = ss.accept();
		System.out.println("Connection Established");

		// to accept filename from client
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

		// to send file content to client
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		// read filename from client
		String fname = in.readLine();

		FileReader fr = null;
		BufferedReader file = null;
		boolean flag;

		// Create a file class object with fname
		File f = new File(fname);

		if(f.exists()) flag = true;
		else flag = false;

		if(flag) dos.writeBytes("Yes" + "\n");
		else dos.writeBytes("No" + "\n");

		if(flag){

			// Attach the file to FileReader to read data
			fr = new FileReader(fname);

			// Attach FileReader to BufferedReader
			file = new BufferedReader(fr);

			String str;

			while((str = file.readLine()) != null){


				dos.writeBytes(str + "\n");			

			}

			file.close();
			dos.close();
			in.close();
			fr.close();
			s.close();
			ss.close();


		}

	
	}

}