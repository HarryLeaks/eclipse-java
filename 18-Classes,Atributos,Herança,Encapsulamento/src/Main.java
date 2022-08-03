import importar.Pessoa;
import importar.Classe;

public class Main {
	public static void main(String[] args) {
		Pessoa player = new Pessoa(); //criamos o objeto player
		Classe player2 = new Classe(); //crimaos o objeto player2 sem a Herança
		
		String nome = "Kiko";
		
		player.numero = 10; //podemos acessar a variavel numero pois esta public
		player.atacar(); //metodo public
		player.atribuirNome(nome);
	}
}
