package car;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import vehicle.Vehicle;

public class Car extends Vehicle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4306439855426601691L;
	private String fuelType;
	private int numberOfDoors;

	//Car constructor
	public Car(String make, int model, int topSpeed, String registrationNumber, double dailyHireRate, String fuelType,
			int numberOfDoors) {
		super(make, model, topSpeed, registrationNumber, dailyHireRate);
		this.fuelType = fuelType;
		this.numberOfDoors = numberOfDoors;
	}

	//validating car input data before storing it in the file
	public ArrayList<String> validateCar(String make, String model, String topSpeed, String registrationNumber,
			String dailyHireRate, String fuelType, String numberOfDoors) {
		//errors arraylist to store errors and display it to the users
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
			try {
				//if the input is lower than 0 then display error
				if (Integer.parseInt(topSpeed) < 0) {
					errors.add("Top Speed cannot be Negative!");
				}
			} catch (NumberFormatException e) {
				errors.add("Top Speed must be an integer!");
			}

		}
		if (registrationNumber.isEmpty()) {
			errors.add("Registration Number cannot be Empty!");
		} else {
			//check if the registration number already exists
			File file = new File("./src/resources/carObjects.dat");
			if (file.exists()) {
				ArrayList<Car> carObj = getObjects("./src/resources/carObjects.dat");
				for (Car car : carObj) {
					//foreach car object from the file, check if registration number equals the user entered registration number
					if (registrationNumber.contentEquals(car.getRegistrationNumber())) {
						errors.add("Registration Number Already Exists!");
					}
				}
			}
		}
		if (dailyHireRate.isEmpty()) {
			errors.add("Daily Hire Rate cannot be Empty!");
		} else {
			try {
				if (Integer.parseInt(dailyHireRate) < 0) {
					errors.add("Daily Hire Rate cannot be Negative!");
				}
			} catch (NumberFormatException e) {
				errors.add("Daily Hire Rate must be integer!");
			}
		}
		if (fuelType.isEmpty()) {
			errors.add("Full Type cannot be Empty!");
		}
		if (numberOfDoors.isEmpty()) {
			errors.add("Number of Doors cannot be Empty!");
		} else {
			try {
				//number of doors cannot be less than or equals to 0
				if (Integer.parseInt(numberOfDoors) <= 0) {
					errors.add("Number of Doors cannot be Negative or Zero!");
				}
			} catch (NumberFormatException e) {
				errors.add("Number of Doors must be an integer!");
			}
		}
			return errors;
	}

	public String getFuelType() {
		return fuelType;
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}
}
