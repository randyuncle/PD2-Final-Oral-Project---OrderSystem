package mainServer;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer{
	
	public static final int serverPort = 2148;
	
	public static void main(String[] args) {
		try {
			
			ServerSocket serverSock = new ServerSocket(2148);
			System.out.println("Server started...");
			
			while (true) {
				
				Socket socket = serverSock.accept();
				ServerRun serverRun = new ServerRun(socket);
				Thread serverthread = new Thread(serverRun);
				System.out.println("Connection get");
				serverthread.start();
				
				
			}
			
		} catch (IOException e) { 
			
			System.out.println("disconnected..."); 
			e.printStackTrace();
		
		}
	
	}
	
}
