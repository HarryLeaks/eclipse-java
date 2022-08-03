
public class AnimalList {
	public Animal[] animal = new Animal[5];
	private int i = 0;
	
	
	public void add(Animal a) {
		if(i < animal.length) {
			animal[i] = a;
			i++;
		}
	}
	
	public int count() {
		return this.i;
	}
}
