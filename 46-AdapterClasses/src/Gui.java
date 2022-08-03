import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame{
	private String details;
	private JLabel statusBar;
	
	public Gui() {
		super("Window");
		
		statusBar = new JLabel("default");
		add(statusBar, BorderLayout.SOUTH);
		addMouseListener(new Mouseclass());
		
	}
	
	private class Mouseclass extends MouseAdapter{
		public void mouseClicked(MouseEvent event) {
			details= String.format("You clicked %d ", event.getClickCount());
			
			//when the right button mouse is down
			if(event.isMetaDown()) {
				details += "with right mouse button";
			}else if(event.isAltDown()) {
				details += "with center mouse button";
			}else {
				details += "with left mouse button";
			}
			
			statusBar.setText(details);
				
		}
	}
}
