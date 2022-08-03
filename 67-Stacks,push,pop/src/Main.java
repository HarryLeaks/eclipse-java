import java.util.*;

public class Main {
	public static void main(String[] args) {
		//Stack - The first element to be insert is the last element to be removed
		Stack<String> stack = new Stack<String>(); //creates a stack of string
		
		stack.push("bottom"); //adds a string to the stack
		printStack(stack);
		
		stack.push("second");
		printStack(stack);
		
		stack.push("third");
		printStack(stack);
		
		for(int i = 0; i < stack.size(); i++) {
			stack.pop(); //remove a string from the stack
			printStack(stack);
		}
	
	}
	
	public static void printStack(Stack<String> sk) {
		//check if the stack is empty
		if(sk.isEmpty())
			System.out.println("you have nothing in your stack");
		else
			System.out.printf("%s \n", sk);
	}
}
