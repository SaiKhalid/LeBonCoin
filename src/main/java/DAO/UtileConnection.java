package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtileConnection {
	
	public static Connection seConnecter() {
		String DRIVER = "org.postgresql.Driver";
		String URL = "jdbc:postgresql://localhost:5432/LeBonCoin";
		String LOGIN = "postgres";
		String PASSWORD = "19621963";
		
		Connection connection = null;
			
		
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
		} catch (SQLException e) {
			System.out.println("SQLException");
			//e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			System.out.println("ClassNotFoundException");
			//e1.printStackTrace();
		}
		return connection;
		
	}

}
