import java.util.*;

public class Main {
	public static void main(String[] args) {
		String[] stuff = {"apples", "beef", "corn", "ham" };
		List<String> list1 = Arrays.asList(stuff);
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("youtube");
		list2.add("google");
		list2.add("digg");
		
		for(String x : list2)
			System.out.printf("%s ", x);
	
		Collections.addAll(list2, stuff); //way to addAll an array of strings into a list
		list2.addAll(list1); //way to addAll a list into other list 
		
		System.out.println("");
		for(String x : list2)
			System.out.printf("%s ", x);
	}
}
