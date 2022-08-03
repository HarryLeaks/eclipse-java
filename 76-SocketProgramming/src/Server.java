import java.io.*;
import java.net.*;

//server side
public class Server {
	private Socket socket = null; //socket 
	private ServerSocket server = null; //server socket
	private DataInputStream in = null; //variable that will receive the client input
	
	public Server(int port) {
		try {
			server = new ServerSocket(port); //starts the server with the respective port
			System.out.println("Server Started");
			
			System.out.println("Wating for a client ...");
			
			socket = server.accept(); //accept the client request
			System.out.println("Client request accepted");
			
			//takes input from the client socket
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream())); //receives the inputs from the client
			
			String line = ""; //string that will save the message
			
			//loop that stops when the server receives "Over" input 
			while(!line.equals("Over")) {
				try {
					line = in.readUTF(); //convert bytes in characters and save in line
					System.out.println(line);
				}catch(IOException i) {
					System.out.println(i);
				}
			}
			System.out.println("Closing Connection");
			
			//close Connection
			socket.close(); //close the socket
			in.close(); //close the client socket input
		}
		catch(IOException i) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		//runs the server
		Server server = new Server(5000);
	}
}
