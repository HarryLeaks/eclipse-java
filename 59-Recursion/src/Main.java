import java.math.*;
import java.util.Scanner;

public class Main {
	public static int num;
	
	public static void main(String[] args) {
		System.out.println("Factorial: " + fact(5));
		
		natural(1);
		
		Scanner input = new Scanner(System.in);
		System.out.print("Input number of terms for the Series (< 20) : ");
		num = input.nextInt();
		fibonnaci(0, 1);
	}
	
	public static long fact(long n) {
		if(n <= 1)
			return 1;
		else
			return  n * fact(n-1);
	}
	
	//other example
	public static void natural(int n) {
		if(n == 50)
			System.out.println(n);
		else {
			System.out.println(n + " ");
			natural(n + 1);
		}
	}
	
	//other example
	public static void fibonnaci(int n1, int n2) {
		int aux;
		num--;
		
		if(num >= 1) {
			System.out.printf("%d ", n1+n2);
			aux = n2;
			n2 = n2 + n1;
			n1 = aux;
			fibonnaci(n1, n2);
		}
	}
}
