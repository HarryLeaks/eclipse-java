
class pessoa{
	//Criacao construtor - vai ser executado sempre que criamos um objeto
	//No entanto caso queiramos colocar paramentos vai dar erro se na criacao do objeto nao colocarmos o valor do parametro
	public pessoa(String nome) {
		System.out.println("Contrutor " + nome);
	}
}

public class Main {
	public static void main(String[] args) {
		//pessoa() -> construtor da classe pois o java cria um construtor caso nao encontre nenhum
		pessoa kiko = new pessoa("Francisco"); 
		
		pessoa santi = new pessoa("Santi");
	}
}
