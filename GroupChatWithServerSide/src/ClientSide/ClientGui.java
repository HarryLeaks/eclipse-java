package ClientSide;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ClientGui extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel Porta, Nome;
	private JTextPane textArea;
	private JScrollPane sp;
	private JTextField message, port, name;
	private JButton btn, connect;
	private boolean connected, sent = false;
	HandlerClass handler = new HandlerClass();
	
	public void Janela() {
		setTitle("Client");
		setSize(500, 525);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textArea = new JTextPane();
		textArea.setBounds(0, 0, 400, 400);
		textArea.setPreferredSize(new Dimension(400, 400));
		sp = new JScrollPane(textArea);
		this.getContentPane().add(sp);
		add(sp);
		
		message = new JTextField("Message", 35);
		message.setBounds(10, 430, 100, 50);
		add(message);
		
		btn = new JButton("send");
		btn.setBounds(120, 430, 100, 50);
		btn.addActionListener(handler);
		add(btn);
		
		Menu();
	}
	
	public void login() {
		setTitle("login");
		setSize(200, 180);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Nome = new JLabel("Nome:");
		Nome.setBounds(10, 10, 40, 40);
		add(Nome);
		
		name = new JTextField();
		name.setBounds(53, 22, 100, 20);
		add(name);
		
		Porta = new JLabel("Porta: ");
		Porta.setBounds(10, 45, 40, 40);
		add(Porta);
		
		port = new JTextField();
		port.setBounds(53, 57, 100, 20);
		add(port);
		
		connect = new JButton("Connect");
		connect.setBounds(50, 100, 100, 20);
		connect.addActionListener(handler);
		add(connect);
		
		setVisible(true);
	}
	
	private void Menu() {
		ImageIcon imagem1 = new ImageIcon("src/imagens/img1.jpg");
		ImageIcon imagem2 = new ImageIcon("src/imagens/img2.jpg");
		ImageIcon imagem3 = new ImageIcon("src/imagens/img3.jpg");
		ImageIcon imagem4 = new ImageIcon("src/gifs/gif1.gif");
		ImageIcon imagem5 = new ImageIcon("src/gifs/gif2.gif");
		ImageIcon imagem6 = new ImageIcon("src/gifs/gif3.gif");
				
		JMenuBar menubar = new JMenuBar();
		JMenu opc = new JMenu("Files");
		//JMenu emojis = new JMenu();
		JMenu img = new JMenu("Imagens");
		JMenu gifs = new JMenu("Gifs");
		
		JMenuItem img1 = new JMenuItem("Fox", imagem1);
		JMenuItem img2 = new JMenuItem("Anonymous", imagem2);
		JMenuItem img3 = new JMenuItem("Tunel", imagem3);
		
		JMenuItem gif1 = new JMenuItem("Fire", imagem4);
		JMenuItem gif2 = new JMenuItem("Think", imagem5);
		JMenuItem gif3 = new JMenuItem("Trovao", imagem6);
		
		/*
		JMenuItem emj1 = new JMenuItem();
		JMenuItem emj2 = new JMenuItem();
		JMenuItem emj3 = new JMenuItem();
		*/
		
		opc.add(img1);
		opc.add(img2);
		opc.add(img3);
		opc.add(gif1);
		opc.add(gif2);
		opc.add(gif3);
		
		menubar.add(opc);
		setJMenuBar(menubar);
		
		setVisible(true);
	}
	public String getName() {
		return name.getText();
	}
	
	public String getPort() {
		return port.getText();
	}
	
	public boolean isConnected() {
		return connected;
	}
	
	public boolean isSent() {
		return sent;
	}
	
	public void setSent() {
		sent = false;
	}
	
	public String getMsg() {
		return message.getText();
	}
	
	public void setPaneText(String msg) {
		textArea.replaceSelection(msg + "\n");
		textArea.selectAll();
		textArea.setSelectionStart(textArea.getSelectionEnd());
	}
	
	public class HandlerClass implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == connect) {
				connected = true;
				System.out.println("true");
			}else if(event.getSource() == btn) {
				sent = true;
				textArea.replaceSelection(name.getText() + message.getText() + "\n");
				textArea.selectAll();
				textArea.setSelectionStart(textArea.getSelectionEnd());
			}
		}
	}
}
