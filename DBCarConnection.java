 package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBCarConnection {
	
	private final static String URL = "jdbc:mysql://localhost:3306/rentcar"; 
	private final static String USERNAME = "root";
	private final static String PASSWORD = "Adrian1964";  //CHANGE THIS TO YOUR PASSWORD***********
	private static Connection connection;
	private static DBCarConnection instance;
	
	
	private DBCarConnection(Connection connection) {
		this.connection = connection; 
		
	}
	public static Connection getConnection() {
		if (instance == null) {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new DBCarConnection(connection);
				System.out.println(" Connection successful.");
			} catch (SQLException e){
				e.printStackTrace();
				
			}
		}
		return DBCarConnection.connection;
	
	}

}

