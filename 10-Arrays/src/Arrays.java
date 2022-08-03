import java.util.Random;

public class Arrays {
	public static void main(String[] args) {
		int idades[] = new int[5];
		String names[] = {"Kiko", "Santi"}; //outra maneira de declarar uma variavel
		
		int idade = 0;
		for(int i = 0; i < 5; i++) {
			idade += 5;
			idades[i] = idade;
			System.out.println((i+1) + " Idade: " + idades[i]);
		}
		
		//other way to use for with arrays
		for(int x: idades) {
			System.out.println("Idade: " + x);
		}
		
		//tmb posso utilizar o lenght para obter o tamanho do array
		System.out.println("Tamanho: " + idades.length);
		
		//tmb podemos clonar o array
		int clone[] = idades.clone();
		for(int i = 0; i < clone.length; i++) {
			System.out.println("Outro: " + clone[i]);
		}
		
		//Array elements as counters
		Random rand = new Random();
		int freq[] = new int[7];
		for(int roll = 1; roll < 1000; roll++) {
			++freq[1+rand.nextInt(6)];
		}
		
		for(int face = 0; face < freq.length; face++) {
			System.out.println(face + "\t" + freq[face]);
		}
	}
}
