package booksfortots;

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
	 * @return integer BookID - id of the book
	 */
	public int getBookID() {
		return BookID;
	}

	/**
	 * 
	 * @param integer
	 *            index - the index value of the book requested
	 * @return integer id - the id of the book requested
	 */
	public int getBookIDAtIndex(int index) {
		int id = books.get(index).BookID;
		return id;
	}

	/**
	 * Set the id of the book
	 * 
	 * @param integer
	 *            bookID - the id to be set for the book
	 */
	public void setBookID(int bookID) {
		BookID = bookID;
	}

	/**
	 * Get the title of the book
	 * 
	 * @return - String BookTitle - the title of the book
	 */
	public String getBookTitle() {
		return BookTitle;
	}

	/**
	 * Get the title of a book at a specific index
	 * 
	 * @param index
	 *            - the index value requested
	 * @return String title - the title of the book at the index value
	 */
	public String getBookTitleAtIndex(int index) {
		String title = books.get(index).BookTitle;
		return title;
	}

	/**
	 * 
	 * @param bookTitle
	 */
	public void setBookTitle(String bookTitle) {
		BookTitle = bookTitle;
	}

	/**
	 * 
	 * @return
	 */
	public String getBookAuthor() {
		return BookAuthor;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public String getBookAuthorAtIndex(int index) {
		String author = books.get(index).BookAuthor;
		return author;
	}

	/**
	 * 
	 * @param bookAuthor
	 */
	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}

	/**
	 * 
	 * @return
	 */
	public String getBookPublisher() {
		return BookPublisher;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public String getBookPublisherAtIndex(int index) {
		String publisher = books.get(index).BookPublisher;
		return publisher;
	}

	/**
	 * 
	 * @param bookPublisher
	 */
	public void setBookPublisher(String bookPublisher) {
		BookPublisher = bookPublisher;
	}

	/**
	 * 
	 * @return
	 */
	public String getBookCondition() {
		return BookCondition;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public String getBookConditionAtIndex(int index) {
		String conditionstr = books.get(index).BookCondition;
		return conditionstr;
	}

	/**
	 * 
	 * @param bookCondition
	 */
	public void setBookCondition(String bookCondition) {
		BookCondition = bookCondition;
	}

	/**
	 * 
	 * @return
	 */
	public String getBookReleaseDate() {
		return BookReleaseDate;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public String getBookReleaseDateAtIndex(int index) {
		String release = books.get(index).BookReleaseDate;
		return release;
	}

	/**
	 * 
	 * @param bookReleaseDate
	 */
	public void setBookReleaseDate(String bookReleaseDate) {
		BookReleaseDate = bookReleaseDate;
	}

	/**
	 * 
	 * @param book
	 */
	public void addBook(Book book) {
		Book.numBooks++;
		books.add(book);
	}

	/**
	 * 
	 * @return
	 */
	public int getNumBooks() {
		return numBooks;
	}

	/**
	 * 
	 */
	public void printBooks() {
		for (int i = 0; i < books.toArray().length; i++) {
			System.out.println(
					"Book Title: " + books.get(i).getBookTitle() + "\nAuthor: " + books.get(i).getBookAuthor());
		}
	}

	/**
	 * 
	 * @param bookID
	 * @param bookTitle
	 * @param bookAuthor
	 * @param bookPublisher
	 * @param bookCondition
	 * @param bookReleaseDate
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
	 * 
	 */
	public Book() {
	}
}
