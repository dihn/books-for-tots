/**
package booksfortots;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dataconnection {

	final static String DB_URL = "jdbc:mysql://localhost/booksfortots";
	private static String user = "root";
	private static String password = "";
	public static String username;
	public static String password2;

	
	public static void connect() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, user, password);
			PreparedStatement statement = conn.prepareStatement("SELECT Username, Password FROM users");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				username = resultSet.getString("Username");
				password2 = resultSet.getString("Password");
				
				System.out.println("Username: " + username + "\nPassword: " + password2);

			}

			resultSet.close();
			statement.close();
			conn.close();
			
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

	}

}
*/
