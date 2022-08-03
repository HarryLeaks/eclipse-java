import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
	public static final Socket SoC = null;

	public static void main(String[] args) {
		ClientRequest("localhost", 9806);
		
		try {
			//InputStreamReader -> take the bytes and converts to characters
			//BufferedReader -> take the bytes
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter the string");
			
			String str = userInput.readLine();
			PrintWriter out = new PrintWriter(SoC.getOutputStream(), true);
			out.println(str);
			BufferedReader in = new BufferedReader(new InputStreamReader(SoC.getInputStream()));
			System.out.println(in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ClientRequest(String ip, int port) {
		System.out.println("Client started");
		try {
			Socket SoC = new Socket(ip, port);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
