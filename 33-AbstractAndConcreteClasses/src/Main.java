abstract class Dog{
	public void bark() {
		System.out.println("C Bark!");
	}
	
	//abstract method - method that is not implemented yet
	//it's just to organize the code
	public abstract void poop();
}

class Chihuahua extends Dog {
	public void poop() {
		System.out.println("C Dog pooped!");
	}
}

////////////////////////////////////////////////////////////////////////////////////

//An interface assumes that all methods are abstracted
interface DogInterface{
	public void bark();
	public void poop();
	
}

//need to use implements with interface
class Rotvieler implements DogInterface{
	public void poop() {
		System.out.println("R Dog pooped!");
	}

	public void bark() {
		System.out.println("R Bark!");
	}
}

////////////////////////////////////////////////////////////////////////////////////

public class Main {
	public static void main(String[] args) {
		Chihuahua c = new Chihuahua();
		c.bark();
		c.poop();
		
		Rotvieler r = new Rotvieler();
		r.bark();
		r.poop();
	}
}
