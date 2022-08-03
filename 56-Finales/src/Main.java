
public class Main {
	public static void main(String[] args) {
		String a = "apples";
		String b = "bucky";
		String c = "BUCKY";
		
		System.out.println(a.length());//number of characters of the string
		
		//check if its exactly the same string
		if(a.equals("apples"))
			System.out.println("Its equals apples");
		
		//check if both Strings have the characters
		if(b.equalsIgnoreCase(c)) {
			System.out.println("buckys match");
		}
	}
}
