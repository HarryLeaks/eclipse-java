import java.util.*;

public class Main {
	public static void main(String[] args) {
		String[] stuff = {"apples", "bear", "banava", "bear" };
		List<String> list = Arrays.asList(stuff);
		
		List<String> list2 = new ArrayList<String>();
		list2.add("youtube");
		list2.add("google");
		list2.add("digg");
		
		//check the string is in the list and return the number of times that string is in
		System.out.println(Collections.frequency(list, "digg"));		
		System.out.println(Collections.frequency(list, "bear"));
		
		boolean tof = Collections.disjoint(list, list2); //returns true if does not have anything in common
		System.out.println(tof); 
		
		if(tof == true)
			System.out.println("These list do not have anything in commom");
		else
			System.out.println("These list must have something in common");
	}
}
