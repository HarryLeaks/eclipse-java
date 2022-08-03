import java.io.*;
import java.net.*;
import java.awt.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.image.*;

import javax.imageio.ImageIO;

public class Server {
	public static void main(String[] args) throws Exception
	{
		Gui win = new Gui("Server");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(500, 520);
		win.setVisible(true);
		
		final int port = 444;
		
		System.out.println("Server waiting for connection on port "+port);
		ServerSocket ss = new ServerSocket(port);
		Socket clientSocket = ss.accept();
		//System.out.println("Received connection from "+clientSocket.getInetAddress()+" on port "+clientSocket.getPort());
		win.area.replaceSelection("Received connection from " + clientSocket.getInetAddress() + " on port " + clientSocket.getPort() + "\n");
		win.area.selectAll();
		win.area.setSelectionStart(win.area.getSelectionEnd());
		
		//create two threads to send and receive from client
		RecieveFromClientThread recieve = new RecieveFromClientThread(clientSocket, win);
		Thread thread = new Thread(recieve);
		thread.start();
		
		SendToClientThread send = new SendToClientThread(clientSocket, win);
		Thread thread2 = new Thread(send);
		thread2.start();
	}
}

class RecieveFromClientThread extends Server implements Runnable
{
	Socket clientSocket=null;
	Gui win;
	BufferedReader brBufferedReader = null;
	
	public RecieveFromClientThread(Socket clientSocket, Gui win)
	{
		this.clientSocket = clientSocket;
		this.win = win;
	}//end constructor
	
	public void run() {
		try{
			//tiro o while e coloco se click = true
			brBufferedReader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));		
			
			String messageString;
			while((messageString = brBufferedReader.readLine())!= null){//assign message from client to messageString
				if(messageString.equals("imgJava")) {
					win.area.replaceSelection("From Client: ");
					win.area.selectAll();
					win.area.setSelectionStart(win.area.getSelectionEnd());
					win.area.insertComponent(new JLabel(new ImageIcon(getClass().getResource("transferir.png"))));
					win.area.selectAll();
					win.area.selectAll();
					win.area.setSelectionStart(win.area.getSelectionEnd());
					win.area.replaceSelection("\n");
					win.area.selectAll();
					win.area.setSelectionStart(win.area.getSelectionEnd());
				}else {					
					win.area.replaceSelection("From Client: " + messageString + "\n");
					win.area.selectAll();
					win.area.setSelectionStart(win.area.getSelectionEnd());
					//System.out.println("From Client: " + messageString);//print the message from client
					//System.out.println("Please enter something to send back to client..");
				}
			}
		}
		catch(Exception ex){	
			System.out.println(ex.getMessage());	
		}
	}
}//end class RecieveFromClientThread

class SendToClientThread extends Server implements Runnable
{
	Gui win;
	PrintWriter pwPrintWriter;
	Socket clientSock = null;
	
	public SendToClientThread(Socket clientSock, Gui win)
	{
		this.clientSock = clientSock;
		this.win = win;
	}
	public void run() {
		try{
		pwPrintWriter =new PrintWriter(new OutputStreamWriter(this.clientSock.getOutputStream()));//get outputstream
		
		while(true)
		{
			String msgToClientString = null;
			Icon img = null;
			//BufferedReader input = new BufferedReader(new InputStreamReader(System.in));//get userinput
			System.out.println();
			if(win.clicked == true) {
				//msgToClientString = input.readLine();//get message to send to client
				msgToClientString = win.text.getText();
				win.area.replaceSelection("Server: " + msgToClientString + "\n");
				win.area.selectAll();
				win.area.setSelectionStart(win.area.getSelectionEnd());
				
				//System.out.println(msgToClientString);
				win.clicked = false;
			}
			if(win.clickedImg == true) {
				img = win.b;
				win.area.replaceSelection("Server: ");
				win.area.selectAll();
				win.area.setSelectionStart(win.area.getSelectionEnd());
				win.area.insertComponent(new JLabel(img));
				win.area.selectAll();
				win.area.selectAll();
				win.area.setSelectionStart(win.area.getSelectionEnd());
				win.area.replaceSelection("\n");
				win.area.selectAll();
				win.area.setSelectionStart(win.area.getSelectionEnd());
				win.clickedImg = false;
			}
			
			if(msgToClientString != null) {
				pwPrintWriter.println(msgToClientString);//send message to client with PrintWriter
				pwPrintWriter.flush();//flush the PrintWriter (clear the stream of any element)
				//System.out.println("Please enter something to send back to client..");
			}
			if(img != null) {
				pwPrintWriter.println("imgJava");
				pwPrintWriter.flush();
			}
		}//end while
		}
		catch(Exception ex){System.out.println(ex.getMessage());}	
	}//end run
}//end class SendToClientThread