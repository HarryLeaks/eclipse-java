package ServerSide;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;

import java.time.LocalDate;

public class ServerGui extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JLabel port, title, time, clientes, traffic;
	private JTextField porta;
	private boolean selected;
	private int kicked = -1;
	private JToggleButton btn;
	private JButton disconnect;
	private JProgressBar progressBar;
	private JList<String> clients;
	private JTextArea log;
	private Font ft;
	private LocalDate date;
	private DefaultListModel<String> dlm;
	
	public void menuJanela() {
		setTitle("Servidor");
		setSize(600, 500);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		title = new JLabel("Welcome to xServer");
		ft = new Font("TimesRoman", Font.BOLD, 24);
		title.setFont(ft);
		title.setBounds(200, 5, 200 , 50);
		add(title);
		
		clientes = new JLabel("Clientes: ");
		clientes.setBounds(10, 50, 100, 50);
		add(clientes);
		
		dlm = new DefaultListModel<String>();
		clients = new JList<>(dlm);
		clients.setBounds(10, 100, 265, 200);
		clients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(clients);
		
		BtnClass BtnHandler = new BtnClass();
		
		disconnect = new JButton("Disconnect Client");
		disconnect.setBounds(10, 310, 140, 20);
		disconnect.addActionListener(BtnHandler);
		add(disconnect);
		
		traffic = new JLabel("Tráfico: ");
		traffic.setBounds(300,50, 100, 50);
		add(traffic);
		log = new JTextArea();
		log.setEditable(false);
		log.setBounds(300, 100, 275, 200);
		add(log);
		
		port = new JLabel("Port: ");
		porta = new JTextField();
		port.setBounds(210, 310, 100, 20);
		porta.setBounds(245, 312, 100, 20);
		add(port);
		add(porta);
		
		HandlerClass handler = new HandlerClass();
		
		btn = new JToggleButton("Desactivated");
		btn.setBounds(215, 340, 150, 30);
		btn.addItemListener(handler);
		add(btn);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(215, 375, 150, 15);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		add(progressBar);
		
		date = LocalDate.now();		
		time = new JLabel(date.toString());
		time.setBounds(475, 420, 100, 10);
		add(time);
		
		setVisible(true);
	}
	
	public String getPort() {
		return porta.getText();
	}
	
	public boolean isSelected() {
		return selected;
	}
	public int clientKicked() {
		return kicked;
	}
	
	public void setlist(int i) {
		clients.remove(i);
	}
	
	public void addList(String name) {
		dlm.addElement(name);
	}
	
	public void setTextArea(String msg) {
		log.append(msg + "\n");
	}
	
	private class HandlerClass implements ItemListener{
		public void itemStateChanged(ItemEvent eve) {
			if(btn.isSelected() && porta.getText().equals("") == false) {
				for(int i = 0; i <= 100; i++) {
					progressBar.setValue(i);
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				btn.setText("Activated");
				selected = true;
			}else{
				btn.setText("Desactivated");
				selected = false;
			}
		}
	}
	
	private class BtnClass implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == disconnect && clients.getSelectedIndex() != -1) {
				kicked = clients.getSelectedIndex();
				JOptionPane.showMessageDialog(null, String.format("Client Disconnected!!!"));
			}
		}
	}
}
