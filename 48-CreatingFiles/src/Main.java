import java.io.File;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		final Formatter x;
		
		//try to create the file 
		try {
			x = new Formatter("fred.txt");
			System.out.println("you crested a file");
		}catch(Exception e) {
			System.out.println("You got an error");
		}
	}
}
