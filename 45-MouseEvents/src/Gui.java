import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*; 

public class Gui extends JFrame{
	public int sizeX = 600;
	public int sizeY = 600;
	
	private JPanel mousePanel;
	private JLabel statusBar;
		
	public Gui() {
		super("title");
		
		//creating the layout - when we create the layout we need to specify where we want to create the object
		mousePanel = new JPanel();
		mousePanel.setBackground(Color.WHITE); //set the background color of the mouse 
		add(mousePanel, BorderLayout.CENTER); //add the mouse panel to the window in the center
		
		statusBar = new JLabel("default"); //create the label
		add(statusBar, BorderLayout.NORTH); //add the label to the window in the south
		
		HandlerClass handler = new HandlerClass();
		mousePanel.addMouseListener(handler);
		mousePanel.addMouseMotionListener(handler);
	}
	
	//we implemented 2 abstracted classes
	//MouseListener has 5 abstracted methods: keyPress, mouseClick, mouseReleased, mouseEntered, mouseExited
	//MouseMotionListener: mouseDragged, mouseMoved
	private class HandlerClass implements MouseListener, MouseMotionListener{
		//what happens when we click the mouse button
		public void mouseClicked(MouseEvent event) {
			statusBar.setText(String.format("Clicked at: %d %d", event.getX(), event.getY()));
		}
		
		//what happens when we press the mouse button
		public void mousePressed(MouseEvent event) {
			statusBar.setText("You pressed down the mouse");
			
			if(event.getX() <= 50) {
				mousePanel.setBackground(Color.BLUE);
			}else if(event.getX() >= (sizeX-50)) {
				mousePanel.setBackground(Color.RED);
			}
		}
		
		//what happens when we released the mouse button
		public void mouseReleased(MouseEvent event) {
			statusBar.setText("You released the button");
		}
		
		//what happens when we put the mouse in the of window
		public void mouseEntered(MouseEvent event) {
			statusBar.setText("You entered the area");			
		}
		
		//what happens when we put the mouse out of the window
		public void mouseExited(MouseEvent event) {
			statusBar.setText("The mouse has left the window");
			mousePanel.setBackground(Color.WHITE);
		}
		
		//what happens when we holding the mouse and moving at the same time
		public void mouseDragged(MouseEvent event) {
			statusBar.setText("you are dragging the mouse");
		}
		
		//what happens when we mouse the mouse while the mouse is inside the window
		public void mouseMoved(MouseEvent event) {
			statusBar.setText("you moved the mouse");
		}
	}
}
