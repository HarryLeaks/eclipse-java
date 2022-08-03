class A{
	int i = 10;
	
	public void mostrar_nome() {
		System.out.println("Kiko");
	}
}

class B extends A{
	int i = 5;

	public void show() {
		//com o super podemos utilizar uma variavel da classe pai quando temos uma outra com o mesmo nome na classe filho
		//tambem podemos fazer utilizar o super em metodos
		System.out.println("I com super: " + super.i);
		System.out.println("I sem super: " + i);
	}
	
	@Override
	public void mostrar_nome() {
		super.mostrar_nome(); //utilizacao do super em metodos
		System.out.println("Francisco");
	}
}


public class Main {
	public static void main(String[] args) {
		B show = new B();
		
		show.show();
		show.mostrar_nome();
	}
}
