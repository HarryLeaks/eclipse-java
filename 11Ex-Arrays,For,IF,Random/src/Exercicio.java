import java.util.Random;

public class Exercicio {
	public static void main(String[] args) {
		//var
		int alunos[][] = new int[15][2]; //15 alunos e 2 notas
		Random notasRand = new Random(); //variavel random
		
		//este for percorre os 15 alunos automaticamente
		//ele cria um vetor (aluno) para cada aluno para guardar as notas
		for(int aluno[] : alunos) {
			aluno[0] = notasRand.nextInt(10);
			aluno[1] = notasRand.nextInt(10);
			
			float media = (aluno[0] + aluno[1]) / 2;
			boolean aprovado;
			
			System.out.println("Aluno: " + aluno[0] + " " + aluno[1]);
			System.out.println("Media: " + media);
			
			if(media >= 5) 
				aprovado = true;
			else
				aprovado = false;
		
			System.out.println("Aprovado? " + aprovado);
			System.out.println("");
		}
	}
}
