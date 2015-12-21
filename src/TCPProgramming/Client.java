package TCPProgramming;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;

import java.net.*;
public class Client extends JFrame implements ActionListener{
	JTextArea txtMessage;
	JTextField txtSend;
	JButton send;
	PrintWriter toServer;
	Client(){
		send = new JButton("Send");
		JPanel p = new JPanel();
		txtMessage = new JTextArea();
		txtSend = new JTextField();
		txtMessage.setFont(new Font("Tahoma",Font.PLAIN,20));
		p.setLayout(new BorderLayout());
		p.add(txtSend,BorderLayout.CENTER);
		p.add(send,BorderLayout.EAST);
		setTitle("Client Side");
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		add(new JScrollPane(txtMessage),BorderLayout.CENTER);
		add(p,BorderLayout.SOUTH);
		txtSend.requestFocus();
		txtSend.addActionListener(this);
		send.addActionListener(this);
		validate();
		runner();
	}
	private void runner(){
		try {
			Socket MyClient = new Socket(InetAddress.getLocalHost(),4567);
			txtMessage.setText("Connected\n");
			toServer = new PrintWriter(MyClient.getOutputStream(),true);
			
		} catch (IOException e) {
			txtMessage.setText("Can't conect to server\n");
		}
	}
	public static void main(String[] args) {
		new Client();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()instanceof JTextField||e.getSource()==send){
			String Message = txtSend.getText();
			
			if(!Message.isEmpty()){
				txtMessage.append(Message+"\n");
				toServer.println(Message);
				txtSend.setText("");
			}
		}
	}
}
