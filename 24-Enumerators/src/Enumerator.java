//enumerators are constants that at the same time are objects
public enum Enumerator {
	//every time we use an enumerator java creates an array
	//with these objects
	//to call the array we just need to use Enumerator.values()
	bucky("nice", "22"),
	kelsey("cutie", "10"),
	julia("bigmistake", "12"),
	nicole("italian", "12"),
	candy("different", "14"),
	erin("iwish", "16");
	
	//private because are not going to be use outside of the enumerator
	private final String desc;
	private final String year;
	
	//variables receive the values by order
	Enumerator(String description, String birthday){
		desc = description;
		year = birthday;
	}
	
	//public methods that are going to be used outside of the enumerator 
	public String getDesc() {
		return desc;
	}
	
	public String getYear() {
		return year;
	}
}
