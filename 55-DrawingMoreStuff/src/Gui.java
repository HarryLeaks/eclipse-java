import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.BLUE);
		g.drawLine(10, 25, 200, 45); //we need to give 2 points
	
		g.setColor(Color.RED);
		g.drawRect(10, 55, 100, 30);
		
		g.setColor(Color.GREEN);
		g.fillOval(10, 95, 100, 30); //create a oval
		
		g.setColor(Color.ORANGE);
		g.fill3DRect(10, 160, 100, 50, true);
	}
}
