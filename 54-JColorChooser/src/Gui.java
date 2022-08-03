import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame{
	private JButton b;
	private Color color;
	private JPanel panel;
	
	public Gui() {
		
		super("The title");
		color = (Color.BLACK);
		panel = new JPanel();
		panel.setBackground(color);
		
		b = new JButton("Choose a color");
		b.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
											//(position, title, initial color) 
						color = JColorChooser.showDialog(null, "Pick your color", color); //will open a box to choose a color
						if(color == null)
							color=(Color.WHITE); //if we do not choose a color will set white
						
						panel.setBackground(color); //set the new color
					}
				}
		);
		
		add(panel, BorderLayout.CENTER);
		add(b, BorderLayout.SOUTH);
		setSize(425, 150);
		setVisible(true);
	}
}
