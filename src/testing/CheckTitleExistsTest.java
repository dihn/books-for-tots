package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import booksfortots.Book;
import database.DatabaseConnect;

public class CheckTitleExistsTest {
	
	@Before
	public void setUp() throws Exception {
		DatabaseConnect.connect("book");
	}

	@Test
	public void test() {
		Book b = new Book();
		
		String title = "test";
		
		assertTrue(b.checkTitleExists(title));
	}
}
