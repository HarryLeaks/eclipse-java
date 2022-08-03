import java.util.EnumSet; //allows us to pick a range from the enumerator

public class Main {
	public static void main(String[] args) {
		//class enumerator name and the variable that we want to use 
		for(Enumerator people : Enumerator.values()) {
			System.out.printf("%s\t%s\t%s\n", people, people.getDesc(), people.getYear());
		}
		
		System.out.printf("\n");
		
		//using EnumSet
		for(Enumerator people: EnumSet.range(Enumerator.bucky, Enumerator.julia)) {
			System.out.printf("%s\t%s\t%s\n", people, people.getDesc(), people.getYear());
		}
	}
}
