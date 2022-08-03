import java.util.Random;

public class Funcoes {
	//estrutura de funcao
	//[visibilidade] [tipo de retorno] <nome da funcao>([parametros])
	//temos de colocar o static quando nao estamos estanciado a class funcoes
	public static void exibir() {
		int Money[] = rand(100);
		
		for(int i = 0; i < Money.length; i++) {
			System.out.println("Pessoa " + (i+1) + ": " + Money[i]);
		}
	}
	
	public static float media(int[] Money) {
		float m = 0;
		for(int i = 0; i < Money.length; i++) {
			m = m + Money[i];
		}
		return ((float)m/Money.length);
	}
	
	public static int[] rand(int intervalo) {
		Random aleatorio = new Random();
		int Money[] = new int[10];
		for(int i = 0; i < Money.length; i++) {
			Money[i] = aleatorio.nextInt(intervalo);
		}
		return Money;
	}
	
	public static void main(String[] args) {
		exibir();
		System.out.println("Media: " + media(rand(100)));
	} 
}
