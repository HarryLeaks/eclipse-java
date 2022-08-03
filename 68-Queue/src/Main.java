import java.util.*;

public class Main {
	public static void main(String[] args) {
		PriorityQueue<String> queue = new PriorityQueue<String>();
		//queue the first element to be insert is the first element to be removed 
		queue.offer("first");
		queue.offer("second");
		queue.offer("third");
		
		System.out.printf("%s ", queue);
		System.out.println();
		
		System.out.printf("%s ", queue.peek()); //returns the head of the queue(First element)
		System.out.println();
		
		queue.poll(); //removes the head of the queue
		System.out.printf("%s ", queue);
	}
}
