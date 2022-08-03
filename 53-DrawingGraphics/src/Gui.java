import javax.swing.*;
import java.awt.*;

public class Gui extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g); //var that will create objects in the screen
		this.setBackground(Color.WHITE); //set background with white color
		
		g.setColor(Color.BLUE); //set g object with blue color
		//x, y, width, height
		g.fillRect(25, 25, 100, 30); //create a rect 
		
		//set other color and other rect
		g.setColor(new Color(190, 81, 215));
		g.fillRect(25,  65,  100, 30);	
		
		//set other color 
		g.setColor(Color.RED);
		g.drawString("This is some text", 25, 120); //draw a string 
	}
}
