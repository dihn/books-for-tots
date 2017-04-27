package booksfortots;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Book {

	private String BookTitle;
	private String BookAuthor;
	private String BookPublisher;
	private String BookCondition;
	private String BookReleaseDate;
	private int BookID;

	private static int numBooks;

	private static List<Book> books = new ArrayList<Book>();

	/**
	 * Get the id of a book
	 * 
	 * @return integer BookID id of the book
	 */
	public int getBookID() {
		return BookID;
	}

	/**
	 * Get the id of a book at a specific index
	 * 
	 * @param integer
	 *            index the index value of the book requested
	 * @return integer id the id of the book requested
	 */
	public int getBookIDAtIndex(int index) {
		int id = books.get(index).BookID;
		return id;
	}

	/**
	 * Set the id of the book
	 * 
	 * @param integer
	 *            bookID the id to be set for the book
	 */
	public void setBookID(int bookID) {
		BookID = bookID;
	}

	/**
	 * Get the title of the book
	 * 
	 * @return - String BookTitle the title of the book
	 */
	public String getBookTitle() {
		return BookTitle;
	}

	/**
	 * Get the title of a book at a specific index
	 * 
	 * @param index
	 *            the index value requested
	 * @return String title the title of the book at the index value
	 */
	public String getBookTitleAtIndex(int index) {
		String title = books.get(index).BookTitle;
		return title;
	}

	/**
	 * Set the title of the book
	 * 
	 * @param bookTitle
	 *            String value of the book title to be set
	 */
	public void setBookTitle(String bookTitle) {
		BookTitle = bookTitle;
	}

	/**
	 * Get the book author
	 * 
	 * @return BookAuthor String value of the book author
	 */
	public String getBookAuthor() {
		return BookAuthor;
	}

	/**
	 * Get a book author at a specific index
	 * 
	 * @param index
	 *            integer value of the index
	 * @return author String value of the author name
	 */
	public String getBookAuthorAtIndex(int index) {
		String author = books.get(index).BookAuthor;
		return author;
	}

	/**
	 * Set the book author name
	 * 
	 * @param bookAuthor
	 *            String value of the authors name
	 */
	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}

	/**
	 * Get the name of the publisher
	 * 
	 * @return BookPublisher String value of the name of the publisher
	 */
	public String getBookPublisher() {
		return BookPublisher;
	}

	/**
	 * Get the name of a publisher at a specific index
	 * 
	 * @param index
	 *            integer value for the index
	 * @return publisher String value of the publishers name
	 */
	public String getBookPublisherAtIndex(int index) {
		String publisher = books.get(index).BookPublisher;
		return publisher;
	}

	/**
	 * Set the book publisher name
	 * 
	 * @param bookPublisher
	 *            String value of the publishers name
	 */
	public void setBookPublisher(String bookPublisher) {
		BookPublisher = bookPublisher;
	}

	/**
	 * Get the condition of a book
	 * 
	 * @return BookCondition String value of the condition of the book
	 */
	public String getBookCondition() {
		return BookCondition;
	}

	/**
	 * Get the condition of a book at a specific index
	 * 
	 * @param index
	 *            integer value for the index
	 * @return conditionstr String value of the condition
	 */
	public String getBookConditionAtIndex(int index) {
		String conditionstr = books.get(index).BookCondition;
		return conditionstr;
	}

	/**
	 * Set the condition of a book
	 * 
	 * @param bookCondition
	 *            String value for the condition of a book
	 */
	public void setBookCondition(String bookCondition) {
		BookCondition = bookCondition;
	}

	/**
	 * Get the book release date
	 * 
	 * @return BookReleaseDate String value of the book release date
	 */
	public String getBookReleaseDate() {
		return BookReleaseDate;
	}

	/**
	 * Get the book release date at a specific index
	 * 
	 * @param index
	 *            integer value of the index
	 * @return release String value of the release date
	 */
	public String getBookReleaseDateAtIndex(int index) {
		String release = books.get(index).BookReleaseDate;
		return release;
	}

	/**
	 * Set the book release date
	 * 
	 * @param bookReleaseDate
	 *            String value of the book release date
	 */
	public void setBookReleaseDate(String bookReleaseDate) {
		BookReleaseDate = bookReleaseDate;
	}

	/**
	 * Add a book
	 * 
	 * @param book
	 *            A book object
	 */
	public void addBook(Book book) {
		Book.numBooks++;
		books.add(book);
	}
	
	public void addNewBook(String bookTitle, String bookAuthor, String bookPublisher, String bookCondition,
			String bookReleaseDate) {
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/booksfortots", "root", "");
			String query = "INSERT into books (BookTitle, BookAuthor, BookPublisher, BookCondition, BookReleaseDate)"
					+ " values (?, ?, ?, ?, ?)";
			
			// create the mysql instert preparedstatement
			PreparedStatement prepareStmt = conn.prepareStatement(query);
			prepareStmt.setString(1, bookTitle);
			prepareStmt.setString(2, bookAuthor);
			prepareStmt.setString(3, bookPublisher);
			prepareStmt.setString(4, bookCondition);
			prepareStmt.setString(5, bookReleaseDate);
			
			prepareStmt.execute();
			
			conn.close();
		} catch (Exception e) {
			System.err.println("Exception!");
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Get the number of books currently in the library
	 * 
	 * @return integer value of the number of books held in the library
	 */
	public int getNumBooks() {
		return numBooks;
	}

	/**
	 * Book object
	 * 
	 * @param bookID
	 *            integer value of the book id
	 * @param bookTitle
	 *            String value of the book title
	 * @param bookAuthor
	 *            String value of the book author
	 * @param bookPublisher
	 *            String value of the book publisher
	 * @param bookCondition
	 *            String value of the book condition
	 * @param bookReleaseDate
	 *            String value of the book release date
	 */
	public Book(int bookID, String bookTitle, String bookAuthor, String bookPublisher, String bookCondition,
			String bookReleaseDate) {
		super();
		BookID = bookID;
		BookTitle = bookTitle;
		BookAuthor = bookAuthor;
		BookPublisher = bookPublisher;
		BookCondition = bookCondition;
		BookReleaseDate = bookReleaseDate;
	}

	/**
	 * Blank implementation of a book object
	 */
	public Book() {
	}
}
