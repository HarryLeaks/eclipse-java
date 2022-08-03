import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean check = false;
		
		do {
			try {
				System.out.println("Enter first num: ");
				int n1 = input.nextInt();
				
				System.out.println("Enter second num: ");
				int n2 = input.nextInt();
				
				int sum = n1 / n2;
				System.out.println(sum);
				
				check = true;
			}
			catch(Exception e) {
				System.out.println("Something went wrong");
			}
		}while(check == false);
	}
}
