package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import booksfortots.User;
import database.DatabaseConnect;

public class UserTest {
	
	@Before
	public void setUp() throws Exception {
		DatabaseConnect.connect("login");
	}

	@Test
	public void test() {
		String username = "admin";
		String password = "adminpass";
		User u = new User();
		assertTrue(u.checkLoginDetails(username, password));
	}

}
