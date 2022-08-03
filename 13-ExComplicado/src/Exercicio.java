import java.util.Random;

public class Exercicio {
	public static void main(String[] args) {
		int alunos[][] = new int[15][2];
		
		Random randN = new Random();
		for(int aluno[] : alunos) {
			float media = 0;
			aluno[0] = randN.nextInt(10);
			aluno[1] = randN.nextInt(10);
			media = (float)(aluno[0] + aluno[1]) / 2;
			
			System.out.println("Nota1: " + aluno[0] + "  Nota2: " + aluno[1]);
			System.out.println("Media: " + media);
			if(media < 4) {
				System.out.println("Aluno Reprovado");
			}else if(media >= 4 && media < 5) {
				System.out.println("Aluno para Recuperacao");
				
				aluno[0] = randN.nextInt(10);
				aluno[1] = randN.nextInt(10);
				media = (float)(aluno[0] + aluno[1]) / 2;
				System.out.println("Nota1: " + aluno[0] + "  Nota2: " + aluno[1]);
				System.out.println("Media: " + media);
				if(media < 5)
					System.out.println("Aluno Reprovado");
				else
					System.out.println("Aluno Aprovado");
			}else {
				System.out.println("Aluno Aprovado");
			}
			
			System.out.println("");
			System.out.println("");
		}
	}
}
