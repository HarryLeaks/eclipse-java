
public class EstruturaSwitch {
	public static void main(String[] args) {
		int num = 5;
		
		switch(num) {
		case 1:
			System.out.println("Atacar");
			break;
		case 2:
			System.out.println("Defender");
			break;
		case 3:
			System.out.println("Esquivar");
			break;
		default:
			System.out.println("Nao selecionou");
			break;
		}
		
		int menu = 8;
		switch(menu) {
		case 1:
		case 2:
		case 3:
			System.out.println("Intervalo 1-3");
			break;
		case 4:
		case 5:
		case 6:
		case 7:
			System.out.println("Intervalo 4-7");
			break;
		case 8:
		case 9:
		case 10:
			System.out.println("Intervalo 8-10");
			break;
		default:
			System.out.println("Nao selecionou");
			break;		
		}
	}
	
	//aula 14
}
