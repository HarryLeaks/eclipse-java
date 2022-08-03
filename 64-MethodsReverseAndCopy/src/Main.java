import java.util.*;

public class Main {
	public static void main(String[] args) {
		Character[] ray = {'p', 'w', 'n'};
		
		List<Character> l = Arrays.asList(ray);
		System.out.println("List is: ");
		output(l);
		
		//reverse and print put the list
		Collections.reverse(l);
		System.out.println("After reverse: ");
		output(l);
		
		//create a new array and a new list
		Character[] newRay = new Character[ray.length];
		List<Character> listCopy = Arrays.asList(newRay);
		
		//copy contents of list into listcopy
		Collections.copy(listCopy, l);
		System.out.println("Copy of list: ");
		output(listCopy);
		
		//reverse copied content
		System.out.println("Reverse copied list: ");
		ReverseOutput(listCopy);
		
		//fill collection with crap
		Collections.fill(l, 'X');
		System.out.println("After filling the list: ");
		output(l);
	}
	
	private static void output(List<Character> thelist) {
		for(Character thing : thelist) {
			System.out.printf("%s ", thing);
		}
		System.out.printf("\n\n");
	}
	
	private static void ReverseOutput(List<Character> thelist) {
		ListIterator it = thelist.listIterator(thelist.size());
		
		while(it.hasPrevious()) {
			System.out.printf("%s ", it.previous());
		}
		System.out.println();
		System.out.println();
	}
}
