import java.io.File;

public class Main {
	public static void main(String[] args) {
		File x = new File("C:\\greg.txt"); //create a file var with the directory
		
		//check if the file exists
		if(x.exists())
			System.out.println(x.getName() + " exist!"); //print the name of the file
		else
			System.out.println("File does not exist!");
		
	}
}
