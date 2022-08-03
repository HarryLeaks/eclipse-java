import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame{
	private JTextField n1;
	private JTextField n2;
	private JButton button;
	private JTextField result;
	private JComboBox type;
	
	private int i = 0;
	private String[] op = {"+", "-", "*", "/"};
	
	public Gui() {
		super("Calculator");
		setLayout(new FlowLayout());
		
		iHandler ihandler = new iHandler();
		aHandler ahandler = new aHandler();
		
		n1 = new JTextField("Number1", 14);
		add(n1);
		n2 = new JTextField("Number2", 14);
		add(n2);
		
		button = new JButton("Result");
		button.addActionListener(ahandler);
		add(button);
		
		result = new JTextField("", 14);
		add(result);
		
		type = new JComboBox(op);	
		type.addItemListener(ihandler);
		add(type);
	}
	
	public class iHandler implements ItemListener{
		public void itemStateChanged(ItemEvent event) {
			if(event.getStateChange() == ItemEvent.SELECTED)
				i =  type.getSelectedIndex();
		}
	}
	
	public class aHandler implements ActionListener{
		float num1, num2;
		public void actionPerformed(ActionEvent event) {
			if((String.format("%s", event.getActionCommand()).equals("Result")))
			{
				//convert integer - Integer.parseInt(string);
				num1 = Float.parseFloat(n1.getText());
				num2 = Float.parseFloat(n2.getText());
				
				if(i == 0) 
					result.setText(String.format("%s", num1+num2));
				else if(i == 1)
					result.setText(String.format("%s", num1-num2));
				else if(i == 2)
					result.setText(String.format("%s", num1*num2));
				else if(i == 3)
					result.setText(String.format("%s", num1/num2));
			}
		}
	}
}
