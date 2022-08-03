import java.awt.Image;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client {
	public static void main(String[] args) throws Exception
	{
		Gui win = new Gui("Client");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(500, 520);
		win.setVisible(true);
		
		try {			
			Socket sock = new Socket("localhost",444);
			SendThread sendThread = new SendThread(sock, win);
			
			Thread thread = new Thread(sendThread);
			thread.start();
			
			RecieveThread recieveThread = new RecieveThread(sock, win);
			
			Thread thread2 =new Thread(recieveThread);
			thread2.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
}

class RecieveThread extends Client implements Runnable
{
	Gui win;
	Socket sock=null;
	BufferedReader recieve=null;
	
	public RecieveThread(Socket sock, Gui win) {
		this.win = win;
		this.sock = sock;
	}//end constructor
	public void run() {
		try{
		recieve = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));//get inputstream
		String msgRecieved = null;
		while((msgRecieved = recieve.readLine()) != null)
		{
			if(msgRecieved.equals("imgJava")) {
				win.area.replaceSelection("From Server: ");
				win.area.selectAll();
				win.area.setSelectionStart(win.area.getSelectionEnd());
				win.area.insertComponent(new JLabel(new ImageIcon(getClass().getResource("transferir.png"))));
				win.area.selectAll();
				win.area.selectAll();
				win.area.setSelectionStart(win.area.getSelectionEnd());
				win.area.replaceSelection("\n");
				win.area.selectAll();
				win.area.setSelectionStart(win.area.getSelectionEnd());
			}else{				
				//System.out.println("From Server: " + msgRecieved);
				//System.out.println("Please enter something to send to server..");
				win.area.replaceSelection("From Server: " + msgRecieved + "\n");
				win.area.selectAll();
				win.area.setSelectionStart(win.area.getSelectionEnd());
			}
		}
		}catch(Exception e){System.out.println(e.getMessage());}
	}//end run
}//end class receivethread

class SendThread extends Client implements Runnable
{
	Gui win;
	Socket sock=null;
	PrintWriter print=null;
	BufferedReader brinput=null;
	
	public SendThread(Socket sock, Gui win)
	{
		this.win = win;
		this.sock = sock;
	}//end constructor
	
	public void run(){
		try{
			if(sock.isConnected())
			{
				//System.out.println("Client connected to "+sock.getInetAddress() + " on port "+sock.getPort());
				String info = "Client Connected to " + sock.getInetAddress() + " on port " + sock.getPort();
				win.area.replaceSelection(info + "\n");
				win.area.selectAll();
				win.area.setSelectionStart(win.area.getSelectionEnd());
				
				this.print = new PrintWriter(sock.getOutputStream(), true);	

				while(true){
					String msgtoServerString = null;
					Icon img = null;
					
					System.out.println();
					//System.out.println("Type your message to send to server..type 'EXIT' to exit");
					//brinput = new BufferedReader(new InputStreamReader(System.in));
					
					if(win.clicked == true) {
						msgtoServerString= win.text.getText();
						win.area.replaceSelection("Client: " + msgtoServerString + "\n");
						win.area.selectAll();
						win.area.setSelectionStart(win.area.getSelectionEnd());
						//System.out.println(msgtoServerString);
						//msgtoServerString = brinput.readLine();
						win.clicked = false;
					}
					if(win.clickedImg == true) {
						img = win.b;
						win.area.replaceSelection("Client: ");
						win.area.selectAll();
						win.area.setSelectionStart(win.area.getSelectionEnd());
						win.area.insertComponent(new JLabel(img));
						win.area.selectAll();
						win.area.setSelectionStart(win.area.getSelectionEnd());
						win.area.replaceSelection("\n");
						win.area.selectAll();
						win.area.setSelectionStart(win.area.getSelectionEnd());
						win.clickedImg = false;
					}
					
					if(msgtoServerString != null) {
						this.print.println(msgtoServerString); //sends the message to the server
						this.print.flush(); //clear the stream 
					}
					if(img != null) {
						this.print.println("imgJava");
						this.print.flush();
					}
				}//end while
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}//end run method
}//end class