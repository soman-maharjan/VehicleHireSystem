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
	
	public <T> void storeObject(T cl, String fileName) {
		try {
			File f = new File(fileName);
			if (f.exists() && !f.isDirectory()) {
				AppendingObjectOutputStream aoos = new AppendingObjectOutputStream(
						new FileOutputStream(fileName, true));
				aoos.writeObject(cl);
				aoos.close();
			} else {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName, true));
				oos.writeObject(cl);
				oos.close();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public <T> ArrayList<T> getObjects(String fileName) {
		ArrayList<T> t = new ArrayList<T>();
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			T obj = null;
			while ((obj = (T) ois.readObject()) != null) {
				t.add((obj));
			}
			ois.close();
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

	public ArrayList<String> validateStaff(String username, String password) {
		ArrayList<String> errors = new ArrayList<String>();
		if (username.isEmpty()) {
			errors.add("Username cannot be Empty!");
		} else {
			File file = new File("./src/resources/staffObjects.dat");
			if (file.exists()) {
				ArrayList<User> userObj = getObjects("./src/resources/staffObjects.dat");
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

	public ArrayList<String> validateCustomer(String identificationNumber, String corporationName, String address,
			String phoneNumber, String email, String username, String password) {
		ArrayList<String> errors = new ArrayList<String>();

		if (identificationNumber.isEmpty()) {
			errors.add("Identification Number cannot be Empty!");
		} else {
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
				for (User user : userObj) {
					if (username.contentEquals(user.getUsername())) {
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
