package login;

import java.io.*;
import java.util.ArrayList;

import user.User;

public class Login {

	public String validate(String username, String password, ArrayList<User> users) {
		// check if the user exists using the username provided by the user in view and
		// the existing username in the database.
		// checkIfUserExists function returns true if the username is in the database
		// and false if it does not.
		if (checkIfUserExists(username, users)) {
			for (User user : users) {
				if (username.contentEquals(user.getUsername()) && password.contentEquals(user.getPassword())) {
					return "Password Matched!";
				}
			}
			return "Password does not match!";
		}
		return "Username does not Exist!";
	}

	public boolean checkIfUserExists(String username, ArrayList<User> users) {
		//this function returns true if the username exists in the file else false
		for (User user : users) {
			if (username.contentEquals(user.getUsername())) {
				return true;
			}
		}
		return false;
	}

	public boolean checkIfFileExists(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			return true;
		}
		return false;
	}
}
