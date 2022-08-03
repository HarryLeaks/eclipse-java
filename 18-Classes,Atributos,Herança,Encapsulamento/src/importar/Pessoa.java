package importar;

//atraves do extende herdamos todas as caracteristicas da classe - Herança
//nao obrigatorio ser utilizada para acessarmos a Classe pelo main
//A Classe Pessoa passa a ser a classe filho  
public class Pessoa extends Classe {
	String nome;
	 
	//podemos utilizar este metodos no Main
	public void atribuirNome(String nome) {
		this.nome = nome; //this pega o nome de cima e nao o parametro da funcao
		this.mudarnome(); //atraves do this podemos pegar variaveis e metodos protected 
	}
}
