import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame{
	private JList leftList;
	private JList rightList;
	private JButton moveButton;
	private String[] foods = {
			"bacon",
			"wings",
			"ham",
			"beef",
			"morebacon"
	};
	
	public Gui() {
		super("title");
		setLayout(new FlowLayout());
		
		leftList =  new JList(foods); //receive all the strings
		leftList.setVisibleRowCount(5); //5 items in a row
		leftList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //multiple selection we can select more than one item
		add(new JScrollPane(leftList)); //add to the window with scrollpane
		
		moveButton = new JButton("Move -->");
		moveButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						rightList.setListData(leftList.getSelectedValues()); //if we click on button the right list will receive the item or items selected
					}
				}
		);
		add(moveButton); //add the button to the window
		
		rightList = new JList();
		rightList.setVisibleRowCount(5); //5 items in a row
		rightList.setFixedCellWidth(50); //defines width
		rightList.setFixedCellHeight(15); //defines height 
		rightList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //multiple selection we can select more than one item
		add(new JScrollPane(rightList)); //add to the window with scrollpane
		
	}
}
