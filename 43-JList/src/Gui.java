import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame{
	private JList list;
	private static String[] colornames = {"black", "blue", "red", "white"}; //string's array
	private static Color[] colors = { Color.BLACK, Color.BLUE, Color.RED, Color.white }; //colors's array
	
	private JScrollPane ScrollPane;

	public Gui() {
		super("WIN");
		setLayout(new FlowLayout());
		
		list = new JList(colornames); //name that will be in the list
		list.setVisibleRowCount(4); //number of items in a row
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ScrollPane = new JScrollPane(list); //add the items to the Scroll Pane
		add(ScrollPane); //creates a ScrollPane View
		
		/*list.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						Color color = colors[list.getSelectedIndex()]; //gets the color in the respective list index
						getContentPane().setBackground(color); //set the background of the window the color gotten
					}
				}
		);*/
		
		Handler handler = new Handler();
		list.addListSelectionListener(handler);
	}
	
	public class Handler implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent event) {
			if(event.getSource() == list) {
				Color color = colors[list.getSelectedIndex()];
				getContentPane().setBackground(color);
			}
		}
	}
}
