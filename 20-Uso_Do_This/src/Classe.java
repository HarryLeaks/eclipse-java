
public class Classe{
	public int idade = 5;
	
	void mostrar(int idade) {
		System.out.println("Idade sem this: " + idade);
		System.out.println("Idade com this: " + this.idade); //ao usarmos oo this ele busca nao as variaveis do parametos e sim as variaveis da classe
	}
}
