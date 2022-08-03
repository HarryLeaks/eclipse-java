
public class Main {
	public static void main(String[] args) {
		System.out.println(average(3,55,76,100)); //inicializa��o do metodo
	}
	
	
	//quando colocamos este tipo de parametro
	//significa que estamos a passar um array diretamente
	//na sua inicializa��o
	public static float average(float...numbers) {
		float total = 0;
		
		for(float x: numbers) 
			total+=x;
		
		return total/numbers.length;
	}
}
