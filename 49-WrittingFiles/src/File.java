import java.lang.*;
import java.util.*;

public class File {
	private Formatter x;
	
	//method that will create the file
	public void openFile() {
		try {
			x = new Formatter("C:\\Users\\kiko\\chinese.txt");
		}
		catch(Exception e) {
			System.out.println("you have an error");
		}
	}
	
	//method that will add something to the file
	public void addRecords() {
		x.format("%s %s %s", "20", "bucky", "roberts");
	}
	
	//method that will close the file (good practice)
	public void closeFile() {
		x.close();
	}
}
