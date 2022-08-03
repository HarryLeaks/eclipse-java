import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;

public class Server {
	private static Socket SoC = null;
	
	public static void main(String[] args) {
		ServerSetup(9806);
		
		try {
		BufferedReader in = new BufferedReader(new InputStreamReader(SoC.getInputStream()));
		String str = in.readLine();
		PrintWriter out = new PrintWriter(SoC.getOutputStream(), true);
		out.println("Server says: " + str);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ServerSetup(int port) {
		System.out.println("Waiting for connection!!!");
		
		try {
			ServerSocket ss = new ServerSocket(port);
			SoC = ss.accept();
			System.out.println("Connection established!!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
