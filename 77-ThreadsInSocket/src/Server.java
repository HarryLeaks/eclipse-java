import java.io.*;
import java.text.*;
import java.util.*;
import java.util.*;
import java.net.*;

//server side
public class Server {
	public static void main(String[] args) throws IOException
	{
		//server is listening on port 5056
		ServerSocket ss = new ServerSocket(5056);
		
		//running infinite loop for getting 
		//client request
		while(true) {
			Socket s = null;
			
			try {
				//Socket object to receive incoming client requests
				s = ss.accept();
				
				System.out.println("A new client is connected: " + s);
				
				//obtaining input and out streams
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
				
				//creates a new thread object
				Thread t = new ClientHandler(s, dis, dos); //we can create the object here because in ClientHandler we extended the thread class
				
				//Invoke the start method
				t.start();
			}catch(Exception e) {
				s.close();
				e.printStackTrace();
			}
		}
	}
}
