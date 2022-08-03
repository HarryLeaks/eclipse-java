import java.util.*;

public class Main {
	public static void main(String[] args) {
		//generic methods does not work with int and char variables
		Integer[] iray = {1,2,3,4};
		Character[] cray = {'b','u','c','y'};
	
		printMe(iray);
		printMe(cray);
	
		//Generic class
		GenericClass<Integer> obj1 = new GenericClass<Integer>(); //create the generic object
		obj1.printAny(2);
		
		GenericClass<String> obj2 = new GenericClass<String>();
		obj2.printAny("apple");
	}
	
	//Generic method - same method with different parameters
	/*
	 public static void printMe(int[] i) {
		for(int x: i)
			System.out.printf("%s ", x);
		System.out.println();
	}
	
	public static void printMe(char[] i) {
		//if we don't change here too the program would print the ASCII value
		for(char x: i)
			System.out.printf("%s ", x);
		System.out.println();
	}
	*/
	
	//Generic method
	//T -> is the variable type created 
	public static <T> void printMe(T[] x) {
		for(T b : x)
			System.out.printf("%s ", b);
		System.out.println();
	}
}
