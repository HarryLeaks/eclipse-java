package importar;

public class Classe {
	//atributos da classe
	public int numero; //quando colocamos public podemos acessar a variavel pelo objeto criado
	private int idade; //private apenas e acessável por esta classe
	
	//metodos da classe
	public void atacar() {
		System.out.println("Atacar");
	}
	
	//private apenas e acessável por esta classe
	private void defender() {
		System.out.println("Defender");
	}
	
	//protected apenas pode utilizado no mesmo pacote ou por classes herdadas
	protected void mudarnome() {
		System.out.println("Mudou nome");
	}
}
