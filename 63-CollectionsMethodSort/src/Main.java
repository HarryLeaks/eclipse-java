import java.util.*;

public class Main {
	public static void main(String[] args) {
		String[] crap = {"apple", "lemons", "geese", "bacon", "youtube" }; //arrays of strings
		
		List<String> l1 = Arrays.asList(crap); //creates a list and receive the elements of the array of strings with the method Arrays.asList that converts an array to a list
		//List<String> l1 = new ArrayList(Arrays.asList(crap)); -> it works too
		//List<String> l1 = new LinkedList(Arrays.asList(crap)); //-> it works too
		
		Collections.sort(l1); //sort the list
		System.out.printf("%s ", l1);
		
		Collections.sort(l1, Collections.reverseOrder()); //sort the list and then reverse it
		System.out.printf("%s ", l1);
	}
}
