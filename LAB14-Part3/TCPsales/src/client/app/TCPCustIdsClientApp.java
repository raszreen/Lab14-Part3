package client.app;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import client.view.CustomerViewer;
import model.Customer;

public class TCPCustIdsClientApp {
	
	@SuppressWarnings({ "resource", "unchecked" })
	public static void main (String[] args) {
		
		try {
		
			// Server information
			int serverPortNo = 8088;
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			// 1. Connect to remote machine
			Socket socket = new Socket(serverAddress, serverPortNo);
			
			
			// Create stream to receive response from the server
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			// 3. Read respond from the server - cast the object
			List<Customer> customers = (List<Customer>) ois.readObject();
			
			// 4. Process response - display the object
			CustomerViewer customerViewer = new CustomerViewer();
			customerViewer.displayCustomers(customers);
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
		}
		
	}

}
