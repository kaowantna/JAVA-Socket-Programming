package TCPProgramming;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
public class Server extends JFrame{
	JTextArea txtMessage;
	BufferedReader fromClient;
	Server(){
		txtMessage = new JTextArea();
		txtMessage.setFont(new Font("Tahoma",Font.PLAIN,20));
		setTitle("Server Side");
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new JScrollPane(txtMessage),BorderLayout.CENTER);
		validate();
		runner();
	}
	private void runner(){
		txtMessage.setText("Ready\nWaitting for Connect..");
		try{
			ServerSocket MyServer = new ServerSocket(4567);
			Socket Connected = MyServer.accept();
			txtMessage.setText("Cline has been connected\n");
			fromClient = new BufferedReader(new InputStreamReader(Connected.getInputStream()));
			while(true){
				String MsgClient = fromClient.readLine();
				txtMessage.append(MsgClient+"\n");
			}
		}
		catch(IOException e){System.out.println(e);}
	}
	public static void main(String[]args){
		new Server();
	}
}
