package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	// check user e password
	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=silvana";
	
	//jdbc:mysql://localhost/iscritticorsi?user=root&password=silvana

	public static Connection getConnection() {

		try {
				Connection connection = DriverManager.getConnection(jdbcUrl);
				return connection;

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("ERRORE CONNECTION");
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}

}
