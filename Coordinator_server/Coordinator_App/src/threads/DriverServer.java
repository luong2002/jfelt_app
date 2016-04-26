package threads;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class DriverServer implements Runnable {

	private ServerSocket serverSocket;
	private List<Client_Thread> clients;
	
	public DriverServer() {
		this.clients = new ArrayList<Client_Thread>();
	}
	

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(4445); // Server socket

		} catch (IOException e) {
			System.out.println("Could not listen on port: 4445");
			e.printStackTrace();
			System.exit(-1);
		}

		System.out.println("Server started. Listening to the port 4445");

		while (true) {
			try {
				Socket clientSocket = serverSocket.accept(); // accept the client connection
				Client_Thread ct = new Client_Thread(clientSocket);
				ct.start();
				this.clients.add(ct);
				

			} catch (IOException ex) {

				System.out.println("Problem in message reading");
			}
		}

	}
	
	
	public void messageAll(String message)
	{
		Client_Thread ct;
		for(int count1 = 0; count1 < clients.size(); count1++)
		{
			ct = clients.get(count1);
			ct.sendMessage(message);
		}
	}

}