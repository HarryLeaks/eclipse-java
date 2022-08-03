//server side
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) {
		System.out.println("Waiting for clients... ");

		//we need to use try catch for exceptions
		try {
			ServerSocket ss = new ServerSocket(9806); //we create the server socket with the 9806 port
			Socket soc = ss.accept(); //will wait for client connection and when one connection is accepted will return a socket object
			System.out.println("Connection established"); //why we don't need a if(ss.acept()){System....} -> because with the try catch the method acept() if something wrong occured will return an exception
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//everything in a method
	public static void serverSetup(int port) {
		//we need to use try catch for exceptions
		try {
			ServerSocket ss = new ServerSocket(port); //we create the server socket with the 9806 port
			Socket soc = ss.accept(); //will wait for client connection and when one connection is accepted will return a socket object
			System.out.println("Connection established"); //why we don't need a if(ss.acept()){System....} -> because with the try catch the method acept() if something wrong occured will return an exception
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
