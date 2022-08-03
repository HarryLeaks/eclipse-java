
public class EstruturaFor {
	public static void main(String[] args) {
		for(int i = 0; i <= 10; i++) {
			System.out.println("I: " + i);
		}
		
		for(int i = 0; ;){
			System.out.println("I: " + i);
			i++;
			if(i > 30) {
				break;
			}
		}
	}
}
