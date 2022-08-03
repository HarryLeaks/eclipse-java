package ServerSide;

//Java implementation of  Server side 
//It contains two classes : Server and ClientHandler 
//Save file as Server.java 

import java.io.*; 
import java.util.*; 
import java.net.*; 

//Server class 
public class Server  
{ 

 // Vector to store active clients 
 static Vector<ClientHandler> ar = new Vector<>(); 
   
 // counter for clients 
 static int i = 0; 
 
 static ServerGui win = new ServerGui();
 
 //method that will receive client name
 static String receiveName(Socket clientSocket) {
	 BufferedReader brBufferedReader = null;
	 
	 try {
		 brBufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		 String messageString;
		 
		 if((messageString = brBufferedReader.readLine()) != null)
		 {
			 return messageString;
		 }
	 }catch(Exception ex) {
		 System.out.println(ex.getMessage());
	 }
	return null;
 }

 public static void main(String[] args) throws IOException  
 { 
	win.menuJanela();
	//Scanner input = new Scanner(System.in);
	//System.out.print("Type port: ");
			
	int Port = 0;
	
	while(win.isSelected() == false) {
		System.out.println(win.isSelected());
	}
	if(win.isSelected())
	{
		Port = Integer.parseInt(win.getPort());
		System.out.println(Port);
	}

	// server is listening on port 
     ServerSocket ss = new ServerSocket(Port);   
     Socket s; 
     String name;
     Thread t;
     
     t = new Thread(){
		 public void run() {
			 while(true) {
				 if(win.isSelected() == false) {
					 System.out.println("close server");
					 try {
						ss.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					 break;
				 }
				 
				 //System.out.println(i);
				 if(win.clientKicked() != -1) {
					 System.out.println("disconnect");
					 try {
						ar.elementAt(win.clientKicked()).s.close();
						win.setlist(win.clientKicked());
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
			 }
		 }
	 };
	 
	 t.start();
     
     // running infinite loop for getting 
     // client request 
     while (true)  
     { 
    	 // Accept the incoming request 
         s = ss.accept(); 

         System.out.println("New client request received : " + s); 
           
         // obtain input and output streams 
         DataInputStream dis = new DataInputStream(s.getInputStream()); 
         DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
         
       //receive client name
         name = receiveName(s);
         
         System.out.println("Client Name: " + name);
         System.out.println("Creating a new handler for this client...");
         
         win.addList(name);
         
         // Create a new handler object for handling this request. 
         ClientHandler mtch = new ClientHandler(s,name, dis, dos, win); 

         // Create a new Thread with this object. 
         t = new Thread(mtch); 
           
         System.out.println("Adding this client to active client list"); 

         // add this client to active clients list 
         ar.add(mtch); 

         // start the thread. 
         t.start(); 

         // increment i for new client. 
         // i is used for naming only, and can be replaced 
         // by any naming scheme 
         i++; 
     } 
 } 
} 

//ClientHandler class 
class ClientHandler implements Runnable  
{ 
 Scanner scn = new Scanner(System.in); 
 private String name; 
 final DataInputStream dis; 
 final DataOutputStream dos; 
 Socket s; 
 boolean isloggedin; 
 ServerGui win;
   
 // constructor 
 public ClientHandler(Socket s, String name, 
                         DataInputStream dis, DataOutputStream dos, ServerGui win) { 
     this.dis = dis; 
     this.dos = dos; 
     this.name = name; 
     this.s = s;
     this.win = win;
     this.isloggedin=true; 
 } 

 @Override
 public void run() { 

     String received; 
     while (true)  
     { 
         try
         { 
             // receive the string 
             received = dis.readUTF(); 
               
             System.out.println(received); 
             win.setTextArea(received);
               
             if(received.equals("logout")){ 
                 this.isloggedin=false; 
                 this.s.close(); 
                 break; 
             } 
               
             // break the string into message and recipient part 
             StringTokenizer st = new StringTokenizer(received, "#"); 
             String MsgToSend = st.nextToken(); 
             String recipient = st.nextToken(); 

             // search for the recipient in the connected devices list. 
             // ar is the vector storing client of active users 
             for (ClientHandler mc : Server.ar)  
             { 
                 // if the recipient is found, write on its 
                 // output stream 
                 if (mc.name.equals(this.name) != true || mc.name.equals(this.name) && mc.isloggedin==true)  
                 { 
                    mc.dos.writeUTF(this.name+": "+recipient); 
                 } 
             } 
         } catch (IOException e) { 
               
             e.printStackTrace(); 
         } 
           
     } 
     try
     { 
         // closing resources 
         this.dis.close(); 
         this.dos.close(); 
           
     }catch(IOException e){ 
         e.printStackTrace(); 
     } 
 } 
} 