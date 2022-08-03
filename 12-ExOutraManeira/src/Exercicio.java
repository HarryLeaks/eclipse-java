import java.util.Random;

public class Exercicio {
	public static void main(String[] args) {
		int alunos[][] = new int[15][2];
		Random rand = new Random();
		int notas = 0;
		
		
		for(int aluno[] : alunos) {
			float media = 0;
			boolean aprovado;
			
			for(int i : aluno) {
				notas = notas + rand.nextInt(10); 
			}
			 media = (float)notas / 2;
			if(media >= 5) {
				aprovado = true;
			}else {
				aprovado = false;
			}
			System.out.println("Media: " + media);
			System.out.println("Aprovado? " + aprovado);
			
			notas = 0;
			System.out.println("");
		}
	}
}
