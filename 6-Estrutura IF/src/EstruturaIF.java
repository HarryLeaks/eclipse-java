
public class EstruturaIF {
	public static void main(String[] args) {
		int num = 10;
		int num2 = num + 23;
		
		if(num == 10) {
			System.out.println("NUM: "+ num);
		}
		
		if(num == 10 && num2 == 23) {
			System.out.println("NUM: "+ num);
		}else if(num == 10 && num2 >= 23) {
			System.out.println("NUM2: "+ num2);
		}else {
			System.out.println("NUM: "+ num);
			System.out.println("NUM2: "+ num2);
		}
	}
}
