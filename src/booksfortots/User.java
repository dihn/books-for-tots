package booksfortots;

import java.util.ArrayList;
import java.util.List;

public class User {

	private static int userNum = 0;

	private static List<User> users = new ArrayList<User>();

	private String userName;
	private String userPass;

	public User() {
	}

	/**
	 * User object
	 * 
	 * @param name
	 *            String value of the username
	 * @param pass
	 *            String value of the password
	 */
	public User(String name, String pass) {
		this.userName = name;
		this.userPass = pass;
	}

	/**
	 * Get the number of users
	 * 
	 * @return userNum integer value of the number of users
	 */
	public int getNumUsers() {
		return userNum;
	}

	/**
	 * Add a new user
	 * 
	 * @param user
	 *            User object
	 */
	public void addUser(User user) {
		User.userNum++;
		users.add(user);
	}

	/**
	 * Get the username at a specific index
	 * 
	 * @param index
	 *            integer value of the index
	 * @return username String value of the username
	 */
	public String getUserNameAtIndex(int index) {
		String username = users.get(index).userName;
		return username;
	}

	/**
	 * Get the password at a specific index
	 * 
	 * @param index
	 *            integer value of the index
	 * @return password String value of the password
	 */
	public String getPasswordAtIndex(int index) {
		String password = users.get(index).userPass;
		return password;
	}

	/**
	 * Check if the login details provided by a user match those of the database
	 * 
	 * @param usernameIn
	 *            String value of the username provided
	 * @param passwordIn
	 *            String value of the password provided
	 * @return boolean
	 */
	public boolean checkLoginDetails(String usernameIn, String passwordIn) {
		String username = usernameIn;
		String password = passwordIn;

		for (int i = 0; i < userNum; i++) {
			if (username.equals(users.get(i).userName) && password.equals(users.get(i).userPass)) {
				return true;
			} else if (username.equals(users.get(i).userName) && !password.equals(users.get(i).userPass)) {
				System.out.println("Login Error!");
				return false;
			} else if (!username.equals(users.get(i).userName) && password.equals(users.get(i).userPass)) {
				System.out.println("Login Error!");
				return false;
			}
		}
		return false;
	}
}
