package vehicle;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import user.AppendingObjectOutputStream;

public class Vehicle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 273916715134010626L;
	private String make;
	private int model;
	private int topSpeed;
	private String registrationNumber;
	private double dailyHireRate;

	public Vehicle(String make, int model, int topSpeed, String registrationNumber, double dailyHireRate) {
		this.make = make;
		this.model = model;
		this.topSpeed = topSpeed;
		this.registrationNumber = registrationNumber;
		this.dailyHireRate = dailyHireRate;
	}

	public String getMake() {
		return make;
	}

	public int getModel() {
		return model;
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public double getDailyHireRate() {
		return dailyHireRate;
	}

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

	public <T> void delete(ArrayList<T> arrList, T delObj, String fileName) {
		ArrayList<T> newArrList = new ArrayList<T>();
		for (T cl : arrList) {
			if (!(cl.equals(delObj))) {
				newArrList.add(cl);
			}
		}

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName, false));
			for (T cl : newArrList) {
				oos.writeObject(cl);
			}
			oos.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
