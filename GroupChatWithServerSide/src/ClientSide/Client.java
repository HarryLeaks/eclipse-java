package ClientSide;

//Java implementation for multithreaded chat client 
//Save file as Client.java 

import java.io.*; 
import java.net.*; 
import java.util.Scanner; 

public class Client  
{  
	static ClientGui win = new ClientGui();
	static ClientGui win2 = new ClientGui();
	
 static void sendName(String name, Socket s) {
	 PrintWriter print;
	 try {
		 if(s.isConnected())
		 {
			 print = new PrintWriter(s.getOutputStream(), true);
			 print.println(name);
			 print.flush();
		 }
	 }catch(Exception e) {
		 System.out.println(e.getMessage());
	 }
 }

 public static void main(String args[]) throws UnknownHostException, IOException  
 {
	 win.login();
	 
	 while(win.isConnected() == false) {
		 System.out.println("False");
	 }
	 System.out.println("true");
	 String name = win.getName();
	 int ServerPort = Integer.parseInt(win.getPort());
		 
	 // getting localhost ip 
     InetAddress ip = InetAddress.getByName("localhost"); 
       
     // establish the connection 
     Socket s = new Socket(ip, ServerPort); 
     sendName(name, s);
     
     win.setVisible(false);
     win2.Janela();
     
     // obtaining input and out streams 
     DataInputStream dis = new DataInputStream(s.getInputStream()); 
     DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

     // sendMessage thread 
     Thread sendMessage = new Thread(new Runnable()  
     { 
         @Override
         public void run() { 
             while (true) { 
            	 System.out.println("isSent");
            	 if(win2.isSent() == true) {	
                 	try {
                 		System.out.println("Sent");
                 		win2.setSent();
                     	// write on the output stream 
                     	dos.writeUTF(name + "#" + win2.getMsg()); 
                 	} catch (IOException e) { 
                 		e.printStackTrace(); 
                 	} 
            	 }
             } 
         } 
     }); 
       
     // readMessage thread 
     Thread readMessage = new Thread(new Runnable()  
     { 
         @Override
         public void run() { 

             while (true) { 
                 try { 
                     // read the message sent to this client 
                     //System.out.println(msg);
                     win2.setPaneText(dis.readUTF());
                 } catch (IOException e) { 

                     e.printStackTrace(); 
                 } 
             } 
         } 
     }); 

     sendMessage.start(); 
     readMessage.start(); 

 } 
} 