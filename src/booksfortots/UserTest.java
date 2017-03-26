package booksfortots;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

import database.DatabaseConnect;

public class UserTest {
	
	@Before
	public void setUp() throws Exception {
		DatabaseConnect.connect("login");
	}

	@Test
	public void testCheckLoginDetails() {
		String username = "mgreen";
		String password = "password";
		User u = new User();
		boolean loginCheck = u.checkLoginDetails(username, password);
		
		if(loginCheck == true) {
			JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL!", "LOGIN", 1);
		}
		else if (loginCheck == false) {
			JOptionPane.showMessageDialog(null, "LOGIN FAILED!", "LOGIN", 0);
		}
	}

}
