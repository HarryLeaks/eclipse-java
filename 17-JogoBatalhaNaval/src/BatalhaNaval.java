import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class BatalhaNaval {
	
	static int TamanhoX;
	static int TamanhoY;
	static String Tabuleiro[][];
	static int NavioX[];
	static int NavioY[];
	
	public static void obterTamanhoDosTabuleiros() {
		Scanner input = null;
		for(;;) {
			boolean tudoOk = false;
			try {
				input = new Scanner(System.in);
				System.out.println("Digite a altura do tabuleiro: ");
				TamanhoX = input.nextInt();
				System.out.println("Digite a largura do tabuleiro: ");
				TamanhoY = input.nextInt();
				tudoOk = true;
			}catch(InputMismatchException erro) {
				System.out.println("Digite um valor numérico");
			}
			if(tudoOk)
				input.close();
				break;
		}
	}
	
	public static int calcularNumeroDeNavios() {
		int numeroDeNavios = TamanhoX * TamanhoY / 3;
		return numeroDeNavios;
	}
	
	public static int[] RandomShips(int numeroDeNavios) {
		int navios[] = new int[numeroDeNavios];
		Random rand = new Random();
		
		for(int i = 0; i < numeroDeNavios; i++) {
			navios[i] = rand.nextInt(numeroDeNavios - 1) + 1;
		}
		return navios;
	}
	
	public static void RandomShipsXY(int numeroDeNavios){
		NavioX = new int[numeroDeNavios];
		NavioY = new int[numeroDeNavios];
		Random rand = new Random();
		
		for(int i = 0; i < numeroDeNavios; i++) {
			if(i == 0) {
				NavioX[i] = rand.nextInt(TamanhoX - 1) + 1;
				NavioY[i] = rand.nextInt(TamanhoY - 1) + 1;
				NavioX[i+1] = rand.nextInt(TamanhoX - 1) + 1;
				NavioY[i+1] = rand.nextInt(TamanhoY - 1) + 1;
				
				System.out.println(NavioX[i]);
				System.out.println(NavioY[i]);
				System.out.println(NavioX[i+1]);
				System.out.println(NavioY[i+1]);
				System.out.println();
			}else {
				for(int a = 0; a < i; a++) {
					if(NavioX[a] == NavioX[i] && NavioY[a] == NavioY[i]) {
						NavioX[i] = rand.nextInt(TamanhoX - 1) + 1;
						NavioY[i] = rand.nextInt(TamanhoY - 1) + 1;
						System.out.println(NavioX[i]);
						System.out.println(NavioY[i]);
						System.out.println(NavioX[a]);
						System.out.println(NavioY[a]);
						System.out.println();
						a = -1;
					}
				}
			}
 		}
	}
	
	public static void disparar(int navios[], int numeroDeNavios) {
		Scanner input = new Scanner(System.in);
		int x, y;
		
		System.out.println("Digite x: ");
		x = input.nextInt();
		System.out.println("Digite y: ");
		y = input.nextInt();
		
		for(int Y = 0; Y < TamanhoY; Y++) {
			for(int i = 0; i < numeroDeNavios; i++) {
				if(NavioY[i] == y) {
					for(int a = 0; a < navios[i]; a++) {
						if(NavioX[i] + a == x) {
							Tabuleiro[y][x] = "X";
							return;
						}
					}
				}
			}
		}
		input.close();
	}
	
	public static void desenhar() {
		for(int y = 0; y < TamanhoY; y++) {
			for(int x = 0; x < TamanhoX; x++) {
				if(Tabuleiro[y][x] == "X")
					System.out.print(Tabuleiro[y][x]);
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		obterTamanhoDosTabuleiros();
		Tabuleiro = new String[TamanhoX][TamanhoY];

		int numeroDeNavios = calcularNumeroDeNavios();		
		
		int navios[] = RandomShips(numeroDeNavios);
		RandomShipsXY(numeroDeNavios);
		
		while(true) {
			desenhar();
			disparar(navios, numeroDeNavios);
		}
	}
}
