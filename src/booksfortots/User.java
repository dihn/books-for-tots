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

	public User(String name, String pass) {
		this.userName = name;
		this.userPass = pass;
	}
	
	public int getNumUsers() {
		return userNum;
	}
	
	public void addUser(User user) {
		User.userNum++;
		users.add(user);
	}
	
	public String getUserNameAtIndex(int index) {
		String username = users.get(index).userName;
		return username;
	}
	
	public String getPasswordAtIndex(int index) {
		String password = users.get(index).userPass;
		return password;
	}
	
	public boolean checkLoginDetails(String usernameIn, String passwordIn) {
		String username = usernameIn;
		String password = passwordIn;
		
		for(int i = 0; i < userNum; i++) {
			if(username.equals(users.get(i).userName) && password.equals(users.get(i).userPass)) {
				System.out.println("LOGGED IN\nUsername: " + users.get(i).userName + "Password: " + users.get(i).userPass + "\n");
				return true;
			} else if(username.equals(users.get(i).userName) && !password.equals(users.get(i).userPass)) {
				System.out.println("You have entered the wrong password");
			} else if(!username.equals(users.get(i).userName) && password.equals(users.get(i).userPass)) {
				System.out.println("You have entered the wrong username");
			}
			
			//System.out.println("Username: " + User.this.getUserNameAtIndex(i) + "\nPassword: " + User.this.getPasswordAtIndex(i) + "\n");
		}
		return false;
	}
}
