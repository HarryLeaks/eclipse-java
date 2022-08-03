import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
	public static void main(String[] args) {
		int idade = 0;
		Scanner scanner = new Scanner(System.in);
		
		//tenta correr o programa neste caso se colocarmos uma letra no input da idade vai imprimir o erro InputMismatchException
		//o bom do try catch é que o programa nao termina quando algo de errado ocorre
		try {
			System.out.println("Digite a idade: ");
			idade = scanner.nextInt();
			System.out.println("Idade: " + idade);
		}catch(InputMismatchException e) {
			//e.printStackTrace();
			System.out.println("Voce digitou um caracter invalido");
		}
		
		scanner.close();
	}
	//aula 22
}
