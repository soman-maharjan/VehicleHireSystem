package user;

import java.io.*;
import java.util.ArrayList;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1854164540782951961L;
	private String identificationNumber;
	private String corporationName;
	private String address;
	private String phoneNumber;
	private String email;
	private String username;
	private String password;
	
	//generic function to store objects 
	public <T> void storeObject(T cl, String fileName) {
		try {
			//creating a file object to check if the file exists or not
			File f = new File(fileName);
			if (f.exists() && !f.isDirectory()) {
				//using the AppendingObjectOutputStream to append object to file
				AppendingObjectOutputStream aoos = new AppendingObjectOutputStream(
						new FileOutputStream(fileName, true));
				//writing the object to file
				aoos.writeObject(cl);
				aoos.close();
			} else {
				//if the file does not exist then use ObjectOutputStream to append object to file without header problem
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName, true));
				oos.writeObject(cl);
				oos.close();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	//generic function to get objects with filename as parameter
	public <T> ArrayList<T> getObjects(String fileName) {
		//using arraylist to store objects 
		ArrayList<T> t = new ArrayList<T>();
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			T obj = null;
			//read object from file until it is empty
			while ((obj = (T) ois.readObject()) != null) {
				//add the object to arraylist
				t.add((obj));
			}
			ois.close();
			//exceptions
		} catch (EOFException ex) {

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return t;
	}

	//validate staff function to validate username and password
	public ArrayList<String> validateStaff(String username, String password) {
		//arraylist to store errors
		ArrayList<String> errors = new ArrayList<String>();
		
		//check if the variables are empty, if it is then store errors in arraylist
		if (username.isEmpty()) {
			errors.add("Username cannot be Empty!");
		} else {
			File file = new File("./src/resources/staffObjects.dat");
			//check if the username already exists using the staffObject file
			if (file.exists()) {
				ArrayList<User> userObj = getObjects("./src/resources/staffObjects.dat");
				//foreach user object in file check if the username matches
				for (User user : userObj) {
					if (username.contentEquals(user.getUsername())) {
						errors.add("Username Already Exists!");
					}
				}
			}
		}
		if (password.isEmpty()) {
			errors.add("Password cannot be Empty!");
		}
		if (errors.size() == 0) {
			return errors;
		} else {
			return errors;
		}
	}

	//function to validate customer 
	public ArrayList<String> validateCustomer(String identificationNumber, String corporationName, String address,
			String phoneNumber, String email, String username, String password) {
		ArrayList<String> errors = new ArrayList<String>();

		//check if the variables are empty, if it is then add error to arraylist
		if (identificationNumber.isEmpty()) {
			errors.add("Identification Number cannot be Empty!");
		} else {
			//check if the identification number exists
			File file = new File("./src/resources/customerObjects.dat");
			if (file.exists()) {
				ArrayList<User> userObj = getObjects("./src/resources/customerObjects.dat");
				for (User user : userObj) {
					if (identificationNumber.contentEquals(user.getIdentificationNumber())) {
						errors.add("Identification Number Already Exists!");
					}
				}
			}
		}
		if (corporationName.isEmpty()) {
			errors.add("Corporation Name cannot be Empty!");
		}
		if (address.isEmpty()) {
			errors.add("Address cannot be Empty!");
		}
		if (phoneNumber.isEmpty()) {
			errors.add("Phone Number cannot be Empty!");
		}
		if (username.isEmpty()) {
			errors.add("Username cannot be Empty!");
		} else {
			File file = new File("./src/resources/customerObjects.dat");
			if (file.exists()) {
				ArrayList<User> userObj = getObjects("./src/resources/customerObjects.dat");
				//foreach user object in file, check if the username matches to the one entered by the user
				for (User user : userObj) {
					if (username.contentEquals(user.getUsername())) {
						// if the username exists then add errors to the arraylist
						errors.add("Username Already Exists!");
					}
				}
			}
		}
		if (email.isEmpty()) {
			errors.add("Email cannot be Empty!");
		}
		if (password.isEmpty()) {
			errors.add("Password cannot be Empty!");
		}
		if (errors.size() == 0) {
			return errors;
		} else {
			return errors;
		}
	}

	//getters and setters
	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getCorporationName() {
		return corporationName;
	}

	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
