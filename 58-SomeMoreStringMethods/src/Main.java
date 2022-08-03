
public class Main {
	public static void main(String[] args) {
		
		String s = "franciscomendesantos";
		
		System.out.println(s.indexOf('s'));	//give the position of the first letter in the string	
		System.out.println(s.indexOf('s', 7)); //give the position of the first letter found in the string, starting 7 position
	
		String a = "Bacon ";
		String b = "Monster";
		
		System.out.println(a + b);
		System.out.println(a.concat(b));
		
		System.out.println(a.replace('n', 'b')); //replace n with B
		System.out.println(a.toUpperCase()); //set all characters to upper
		
		String Sum = "     Trim    ";
		System.out.println(Sum.trim()); //cut all the spaces
	}
}
