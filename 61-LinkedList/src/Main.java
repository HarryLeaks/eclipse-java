import java.util.*;

public class Main {
	public static void main(String[] args) {
		String[] things = {"apples", "noobs", "pwnge", "bacon", "goATS"}; //array of strings
		List<String> list1 = new LinkedList<String>(); //linkedlist
		
		//add array string to the likedlist
		for(String x : things)
			list1.add(x);
		
		String[] things2 = { "sausage", "bacon", "goats", "harrypotter" }; //array of strings
		List<String> list2 = new LinkedList<String>(); //linkedlist
		
		//add the array string to the linkedlist
		for(String y : things2)
			list2.add(y);
		
		//add the list1 to the list2 
		list1.addAll(list2);
		list2 = null; //null the list2
		
		printMe(list1); //print list
		removeStuff(list1, 2, 5); //remove an interval of elements from the list1
		printMe(list1); //print list
		
		List<String> list3 = new LinkedList<String>(); //linkedlist
		list3 = reverseMe(list1); //reverse list
		
		//print all the list3
		for(int i = 0;  i < list3.size(); i++) {
			System.out.printf("%s ", list3.get(i));
		}
	}
	
	//method that prints the list
	public static void printMe(List<String> l) {
		for(String i : l)
			System.out.printf("%s ", i);
		
		System.out.println();
	}
	
	//method that will remove elements
	public static void removeStuff(List<String> l, int from, int to) {
		//sublist -> creates and list with a specified interval
		//clear -> clean a list
		l.subList(from, to).clear();
	}
	
	//method that will reverse a list and return that
	public static List<String> reverseMe(List<String> l) {
		ListIterator<String> it = l.listIterator(l.size()); //creates an iterator and it needs to know the size of the list because it will start with the ending
		List<String> list = new LinkedList<String>(); //linked list that will save the reversed elements
		
		//loop that will check if it has a previous element
		while(it.hasPrevious()) {
			list.add(it.previous()); //will add the previous element to the list
		}
		return list; //returns the list
	}
}
