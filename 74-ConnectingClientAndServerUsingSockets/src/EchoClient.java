//client side
import java.net.Socket;

public class EchoClient {
	public static void main(String[] args) {
		System.out.println("Client started");
		
		try {
			//sends a request to the server (ip, port)
			Socket soc = new Socket("192.168.1.86", 9806); //instead the ip we can put localhost
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
