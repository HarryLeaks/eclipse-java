import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		//we need to do this because we do no thave a constructor in Gui
		JFrame f = new JFrame("Title");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Gui p = new Gui();
		f.add(p);
		f.setSize(400, 250);
		f.setVisible(true);
	}
}
