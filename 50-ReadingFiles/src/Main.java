import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static Scanner x; //var that will pick all file content
	
	public static void main(String[] args) {		
		try {
			//try to open the file and initialized the scanner
			x = new Scanner(new File("C:\\Users\\kiko\\chinese.txt")); 
		}
		catch(Exception e) {
			System.out.println("Could not find file");
		}
		
		//run methods
		readFile();
		closeFile();
	}
	
	//method that will read all the file, save the content in those variables and then print in the screen them 
	public static void readFile() {
		//loop that will end after read all the content
		while(x.hasNext()) {
			String a = x.next();
			String b = x.next();
			String c = x.next();
			
			System.out.printf("%s %s %s\n", a,b,c);
		}
	}
	
	//method that will close the file
	public static void closeFile() {
		x.close();
	}
}
