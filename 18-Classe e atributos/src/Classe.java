
//isto é uma classe publica
public class Classe {
	//metodo responsavel pela entry point do programa
	public static void main(String[] args) {
		print(nome);
	}
	
	//atributos
	int numero;
	static String nome = "ola";
	
	//metodo da classe
	static void print(String nome) {
		System.out.println(nome);
	}
}