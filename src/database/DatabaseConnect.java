package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import booksfortots.Book;

public class DatabaseConnect {

	final static String DB_URL = "jdbc:mysql://localhost/booksfortots";
	private static String user = "root";
	private static String password = "";

	/**
	 * Connect to the database
	 */
	public static void connect() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, user, password);
			PreparedStatement statement = conn.prepareStatement(
					"SELECT BookID, BookTitle, BookAuthor, BookPublisher, BookCondition, BookReleaseDate FROM books");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				int BookID = resultSet.getInt("BookID");
				String BookTitle = resultSet.getString("BookTitle");
				String BookAuthor = resultSet.getString("BookAuthor");
				String BookPublisher = resultSet.getString("BookPublisher");
				String BookCondition = resultSet.getString("BookCondition");
				String BookReleaseDate = resultSet.getString("BookReleaseDate");

				Book b = new Book(BookID, BookTitle, BookAuthor, BookPublisher, BookCondition, BookReleaseDate);
				b.addBook(b);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}
