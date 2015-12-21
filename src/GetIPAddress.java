import java.net.*;

import org.w3c.dom.events.EventException;
public class GetIPAddress {
	public static void main(String[] args) {
		InetAddress host;
		try{
			host = InetAddress.getLocalHost();
			System.out.println(host);
		}
		catch(Exception e){}
	}

}
