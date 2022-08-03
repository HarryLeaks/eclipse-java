import java.io.*;
import java.net.*;

public class Client {
	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream out = null;
	
	//constructor to put an address and port
	public Client(String address, int port) {
		//established the connection
		try {
			socket = new Socket(address, port); //sends the client request to the server
			System.out.println("Connected");
			
			//takes input from terminal
			input = new DataInputStream(System.in); //variable that will receive input form the terminal
			
			//send output to the socket
			out = new DataOutputStream(socket.getOutputStream()); //variable that will send the inputs from the terminal to the server
		}catch(UnknownHostException u) {
			System.out.println(u);
		}catch(IOException i) {
			System.out.println(i);
		}
		
		//string to read message from input
		String line = "";
		
		//keep reading until "Over" in input
		while(!line.equals("Over")) {
			try {
				line = input.readLine(); //wait for an input and save it in line(string)
				out.writeUTF(line); //send the client input to the server
			}catch(IOException i){
				System.out.println(i);
			}
		}
		
		//close the connection
		try {
			System.out.println("Closing Connection");
			input.close();
			out.close();
			socket.close();
		}catch(IOException i) {
			System.out.println(i);
		}
	}
	
	public static void main(String args[]) {
		//runs the client
		Client client = new Client("localhost", 5000);
	}
}
