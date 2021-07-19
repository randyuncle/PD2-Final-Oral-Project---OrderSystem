package clientServer;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import properties.ListInfo;

/**
 * The connection for client server to main server.
 * It is important that this connects to localhost instead of the author's computer,
 * which means that you need to have a mysql database and a server in use :)
 * @author randy_uncle at NCKU
 *
 */

public class MainClientServer extends Thread
{
	private Socket socket;
	private BufferedReader input;
	private PrintWriter output;
	private String command;
	
	private String serverIP = ClientServer.SERVER_IP;
	private int serverPort = ClientServer.SERVERPORT;
	
	public MainClientServer(String command) 
	{
		this.command = command;
		
		try 
		{
			System.out.println("Connecting to server");
			socket = new Socket(serverIP, serverPort);
			
			System.out.println("Connection succsess");
		} 
		catch (IOException e) 
		{	 
			e.printStackTrace();	
		}
	}
	
	@Override
	public void run() 
	{
		try 
		{	
			while(socket != null) 
			{	
				output = new PrintWriter(socket.getOutputStream());
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
				
				if(command.equals("quit")) 
				{
					socket.close();
					break;
				}
				else 
				{
					if(command.equals("transfer")) 
					{
						output.println(command);
						output.flush();
						
						output.println(ListInfo.tableNum);
						
						output.println(ListInfo.panFriedBun);
						output.println(ListInfo.eightTreasureRice);
						output.println(ListInfo.crab);
						output.println(ListInfo.soup);
						output.println(ListInfo.setOne);
						output.println(ListInfo.setTwo);
						output.println(ListInfo.total);
						output.flush();
						
						output.println("quit");
						
						output.flush();
						
						output.close();
						socket.close();
					}
				}
			}
		} 
		catch(IOException e)
		{
			System.out.println("Connection quit");
			//e.printStackTrace(); 
		}
	}
	
	

}

