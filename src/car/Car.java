package car;

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

import lorry.Lorry;
import user.AppendingObjectOutputStream;
import user.User;
import vehicle.Vehicle;

public class Car extends Vehicle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4306439855426601691L;
	private String fuelType;
	private int numberOfDoors;

	public Car(String make, int model, int topSpeed, String registrationNumber, double dailyHireRate, String fuelType,
			int numberOfDoors) {
		super(make, model, topSpeed, registrationNumber, dailyHireRate);
		this.fuelType = fuelType;
		this.numberOfDoors = numberOfDoors;
	}

	public ArrayList<String> validateCar(String make, String model, String topSpeed, String registrationNumber,
			String dailyHireRate, String fuelType, String numberOfDoors) {
		ArrayList<String> errors = new ArrayList<String>();

		if (make.isEmpty()) {
			errors.add("Make cannot be Empty!");
		}
		if (model.isEmpty()) {
			errors.add("Model cannot be Empty!");
		}
		if (topSpeed.isEmpty()) {
			errors.add("Top Speed cannot be Empty!");
		} else {
			if (Integer.parseInt(dailyHireRate) < 0) {
				errors.add("Top Speed cannot be Negative!");
			}
		}
		if (registrationNumber.isEmpty()) {
			errors.add("Registration Number cannot be Empty!");
		}else {
			File file = new File("./src/resources/carObjects.dat");
			if (file.exists()) {
				ArrayList<Car> carObj = getObjects("./src/resources/carObjects.dat");
				for (Car car : carObj) {
					if (registrationNumber.contentEquals(car.getRegistrationNumber())) {
						errors.add("Registration Number Already Exists!");
					}
				}
			}
		}
		if (dailyHireRate.isEmpty()) {
			errors.add("Daily Hire Rate cannot be Empty!");
		} else {
			if (Integer.parseInt(dailyHireRate) < 0) {
				errors.add("Daily Hire Rate cannot be Negative!");
			}
		}
		if (fuelType.isEmpty()) {
			errors.add("Full Type cannot be Empty!");
		}
		if (numberOfDoors.isEmpty()) {
			errors.add("Number of Doors cannot be Empty!");
		} else {
			if (Integer.parseInt(numberOfDoors) < 0) {
				errors.add("Number of Doors cannot be Negative!");
			}
		}
		if (errors.size() == 0) {
			return errors;
		} else {
			return errors;
		}
	}

	public String getFuelType() {
		return fuelType;
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}
}
