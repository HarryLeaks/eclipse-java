import java.util.*;

public class Main {
	public static void main(String[] args) {
		//this is used when we want to add more elements to an array, but the array is not diynamic so we have to use a list and then convert to an array
		
		String[] stuff = { "babies", "watermelong", "melons", "fudge" }; //arrays of strings
		LinkedList<String> thelist = new LinkedList<String>(Arrays.asList(stuff)); //creates a linkedlist with the elements of stuff(Arrays.asList(stuff) -> converts the array to a list)
		
		//add to the list more elements
		thelist.add("punmpkinf");
		thelist.addFirst("firstthing");
		thelist.addLast("lastthing");
		
		//converts list to array (able us to add more items to an array of strings)
		stuff = thelist.toArray(new String[thelist.size()]);
		
		for(String x : stuff)
			System.out.printf("%s ", x);
	}
}
