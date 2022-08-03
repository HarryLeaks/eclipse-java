//classe pai
class Bird{
	public void sing() {
		System.out.println("tweet tweet tweet");
	}
}

//classe filho
class Hunter extends Bird{
	//Override é apenas uma anotacao para indicar que o metodo
	//apos esta anotacao estará em primeiro plano
	@Override 
	public void sing() {
		System.out.println("Shot shot");
	}
}

public class Main {
	public static void main(String[] args) {
		Hunter hunter = new Hunter();
		
		hunter.sing();
	}
}
