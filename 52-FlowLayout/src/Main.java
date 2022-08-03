import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		Gui win = new Gui();
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(300, 100);
		win.setResizable(false); //user can't resize the window
		win.setVisible(true);
	}
}
