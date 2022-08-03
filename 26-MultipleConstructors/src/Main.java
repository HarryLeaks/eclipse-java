
class watch{
	private int hour;
	private int minute;
	private int second;
	
	public watch() {
		this(0,0,0);
	}
	
	public watch(int h) {
		this(h, 0, 0);
	}
	
	public watch(int h, int m) {
		this(h,m,0);
	}
	
	public watch(int h, int m, int s) {
		System.out.println("Relogio: " + h + ":" + m + ":" + s);
	}
}

public class Main{
	public static void main(String[] args) {
		watch relogio = new watch(10,30,00);
		watch relogio2 = new watch(10);
		watch relogio3 = new watch(10,23);
		
	}
}
