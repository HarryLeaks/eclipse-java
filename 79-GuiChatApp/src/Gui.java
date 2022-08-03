import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.StyledDocument;

public class Gui extends JFrame{
	public JButton btn;
	public JTextField text;
	public JTextPane area;
	//public StyledDocument doc;
	private JScrollPane sp; //For scroll bar
	
	public JButton btnImg;
	public ImageIcon b;
	
	public boolean clicked = false;
	public boolean clickedImg = false;
	
	public Gui(String title) throws Exception{
		super(title);
		setLayout(new FlowLayout());
		
		area = new JTextPane();
		area.setBounds(0,0,400,400);
		area.setPreferredSize(new Dimension(400, 400));
		sp = new JScrollPane(area);
		this.getContentPane().add(sp);
		add(sp);
		
		//doc = area.getStyledDocument();
		
		text = new JTextField("Message", 35);
		add(text);
		
		btn = new JButton("Send");
		add(btn);
		
		b = new ImageIcon(getClass().getResource("transferir.png"));
		btnImg = new JButton("Image");
		add(btnImg);
		
		HandlerClass handler = new HandlerClass();
		btn.addActionListener(handler);
		btnImg.addActionListener(handler);
	}
	
	public class HandlerClass implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == btn) {
				//System.out.println("True");
				clicked = true;
			}else if(event.getSource() == btnImg) {
				clickedImg = true;
			}
		}
	}
}
