
public class Classes {
	private String first;
	private String last;
	
	private static int members = 0; //every time we change this value in one object all objects will change too
	
	//constructor
	public Classes(String fn, String ln) {
		first = fn;
		last = ln;
		members++;
		System.out.println("Members: " + members);
	}
	
	public String getFirst() {
		return this.first;
	}
	
	public String getLast() {
		return this.last;
	}
	
	//
	public static int getMembers() {
		return members;
	}
}
