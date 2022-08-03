import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame{
	private JButton lb;
	private JButton cb;
	private JButton rb;
	private FlowLayout layout;
	private Container container;
	
	public Gui() {
		//set the layout with a variable to be able to change it when we want
		super("Window");
		layout = new FlowLayout();
		container = getContentPane();
		setLayout(layout);
		
		//left stuff in here
		lb = new JButton("left");
		add(lb);
		//anonymous instant class
		lb.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//when the button is pressed the layout will put every object in the left
						layout.setAlignment(FlowLayout.LEFT);
						layout.layoutContainer(container);
					}
				}
		);
		
		//center stuff in here
		cb = new JButton("center");
		add(cb);
		cb.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//when the button is pressed the layout will put every object in the center
						layout.setAlignment(FlowLayout.CENTER);
						layout.layoutContainer(container);
					}
				}
		);
		
		//right stuff in here
		rb = new JButton("right");
		add(rb);
		rb.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//when the button is pressed the layout will put every object in the right
						layout.setAlignment(FlowLayout.RIGHT);
						layout.layoutContainer(container);
					}
				}
		);
	}
}
