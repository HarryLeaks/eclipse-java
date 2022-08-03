import java.util.*;

public class Main {
	public static void main(String[] args) {
		String[] things = { "apple", "bob", "ham", "bob", "bacon" };
		List<String> list = Arrays.asList(things);
		
		System.out.printf("%s ", list);
		System.out.println();
		
		//Creating a hashset
		Set<String> set = new HashSet<String>(list); //remove the duplicated item from the list
		System.out.printf("%s ", set);
	}
}
