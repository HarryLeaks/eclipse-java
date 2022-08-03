import java.util.Scanner;

public class StringsInputs {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite a idade: ");
		int idade = scanner.nextInt(); //nextInt input for integers
		
		System.out.println("Digite o nome: ");
		String nome = scanner.next(); //next input for strings
		
		System.out.println("");
		System.out.println("Nome: " + nome + " Idade: " + idade);
		
		scanner.close();
	}
}
