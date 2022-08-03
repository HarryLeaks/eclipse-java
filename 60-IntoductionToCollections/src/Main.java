import java.util.*;

public class Main {
	public static void main(String[] args) {
		String[] things = { "eggs", "lasers", "hats" }; //array of strings
		List<String> list = new ArrayList<String>(); //creating a list

		//add all strings to the list
		for(String x: things) {
			list.add(x); //add to the list
		}
		
		String[] morethings = { "lasers", "hats" }; //array of strings
		List<String> list2 = new ArrayList<String>(); //creating a list
		
		//add all strings to the list
		for(String y: morethings)
			list2.add(y); //add to the list
		
		//will print each element of the list
		for(int i = 0; i < list.size(); i++)
			System.out.printf("%s ", list.get(i));
		
		editlist(list, list2); //run the method
		System.out.println();
		
		for(int i = 0; i < list.size(); i++) 
			System.out.printf("%s", list.get(i));
	}
	
	public static void editlist(List<String> l1, List<String> l2) {
		Iterator<String> it = l1.iterator(); //creating a iterator of the l1
		
		//loop that will go through all the list
		while(it.hasNext()) {
			if(l2.contains(it.next())) //check if l2 has the string of the iterator respective element
				it.remove(); //if if has remove it from the l1
		}
	}
}
