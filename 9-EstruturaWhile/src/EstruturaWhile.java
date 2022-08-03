
public class EstruturaWhile {
	public static void main(String[] args) {
		int i = 0;
		
		while(i <= 10) {
			i++;
			System.out.println("I: " + i);
		}
		 
		i = 0; 
		do {
			i++;
			System.out.println("I: " + i);
		}while(i < 10);
	}
}
