package mainServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

import database.Database;
import holders.IdHolder;

class ServerRun implements Runnable{
	
	private Socket socket;
	
	public ServerRun(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			BufferedReader clientInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter clientOutput = new PrintWriter(socket.getOutputStream());
			
			while(true){
				
				String command = clientInput.readLine();
				System.out.println("From Client: " + command);
				
				//command type
				if(command.equals("quit")) 
				{
					clientOutput.println("Connection close");
					break;
				}
				else
				{
					//Server port Database connection
					try 
					{
						Class.forName(Database.DB_Driver);
						System.out.println("開啟資料庫連線");
					}
					catch(ClassNotFoundException e)
					{
						throw new RuntimeException("找不到指定的類別");
					}
					
					Connection conn = Database.getConnection();
					Statement stat = conn.createStatement();
					
					if(command.equals("transfer"))
					{
						int Id = IdHolder.getId();
						
						int tableNumber = Integer.parseInt(clientInput.readLine());
						
						int dish1 = Integer.parseInt(clientInput.readLine());
						int dish2 = Integer.parseInt(clientInput.readLine());
						int dish3 = Integer.parseInt(clientInput.readLine());
						int dish4 = Integer.parseInt(clientInput.readLine());
						int set1 = Integer.parseInt(clientInput.readLine());
						int set2 = Integer.parseInt(clientInput.readLine());
						int total = Integer.parseInt(clientInput.readLine());
						
						String payed = "no";
						
						stat.executeUpdate("INSERT INTO orderlist(id,tablenumber,panfriedbun,eighttreasurerice,crab,soup,setone,settwo,total,payed) values('"+Id+"','"+tableNumber+"','"+dish1+"','"+dish2+"','"+dish3+"','"+dish4+"','"+set1+"','"+set2+"','"+total+"','"+payed+"') ");
						
						IdHolder.addId();
					}
					else if(command.equals("get bill"))
					{
						int tableNumber = Integer.parseInt(clientInput.readLine());
						
						int dish1 = 0 ;
						int dish2 = 0;
						int dish3 = 0;
						int dish4 = 0;
						int set1 = 0;
						int set2 = 0;
						int total = 0;
						
						String payedPre = "no";
						
						ResultSet rst = stat.executeQuery("select * from orderlist where tablenumber = '"+tableNumber+"' and payed = '"+payedPre+"'");
						
						while(rst.next())
						{
							dish1 = rst.getInt("panFriedBun");
							dish2 = rst.getInt("eightTreasureRice");
							dish3 = rst.getInt("crab");
							dish4 = rst.getInt("soup");
							set1 = rst.getInt("setone");
							set2 = rst.getInt("settwo");
							total = rst.getInt("total");
						}
						
						clientOutput.println(dish1);
						clientOutput.println(dish2);
						clientOutput.println(dish3);
						clientOutput.println(dish4);
						clientOutput.println(set1);
						clientOutput.println(set2);
						clientOutput.println(total);
						
						clientOutput.flush();
						
						
					}
					else if(command.equals("payed")) 
					{
						int tableNumber = Integer.parseInt(clientInput.readLine());
						
						String payedNew = "yes";
						String payedPre = "no";
						
						stat.executeUpdate("update orderlist set payed = '"+payedNew+"' where tablenumber = '"+tableNumber+"' and payed = '"+payedPre+"' ");
					}
					
					stat.close();
					conn.close();
					System.out.println("關閉資料庫連線");
					
				}
				
			}
			
			System.out.println("連線中止");
			clientInput.close();
			socket.close();
			
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		
	}
	
	
}

