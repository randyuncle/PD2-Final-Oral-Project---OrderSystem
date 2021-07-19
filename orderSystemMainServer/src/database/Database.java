package database;

import java.sql.*;

public class Database {
	
	public static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
	public static final String DATASOURCE = "jdbc:mysql://localhost:3306/ORDERSYSTEM?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	public static final String USER = "root";
	public static final String PASSWORD = "randylee60911";
	
	public static Connection getConnection() throws SQLException 
	{
		return DriverManager.getConnection(DATASOURCE,USER,PASSWORD);
		
	}
	

}

