package dashboard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListModel;

import car.Car;
import lorry.Lorry;
import minibus.MiniBus;
import vehicle.Vehicle;

public class Dashboard {
	public ArrayList<String> getHiredVehicles(String fileName) {
		ArrayList<String> list = new ArrayList<String>();
		File requestFile = new File(fileName);
		if (requestFile.exists()) {
			Scanner inputFile;
			try {
				inputFile = new Scanner(requestFile);
				while (inputFile.hasNext()) {
					list.add(inputFile.nextLine());
				}
				inputFile.close();
				return list;
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		return list = null;
	}

	public DefaultListModel<String> getCustomersHiredVehicle(String username, ArrayList<Car> cars, ArrayList<Lorry> lorries,
			ArrayList<MiniBus> minibuses) {
		final DefaultListModel<String> l1 = new DefaultListModel<>();
		ArrayList<String> hiredVehicles = getHiredVehicles("./src/resources/hiredVehicle.txt");
		if (hiredVehicles == null) {
			l1.addElement("You have not hired a vehicle.");
		} else {
			ArrayList<String> hiredVehiclesRegNumbers = new ArrayList<String>();
			for (String vehicle : hiredVehicles) {
				String[] vehicleInfo = vehicle.split(" ");
				if (vehicleInfo[2].contentEquals(username)) {
					hiredVehiclesRegNumbers.add(vehicleInfo[1] + " " + vehicleInfo[0]);
				}
			}

			Car car;
			Lorry lorry;
			MiniBus minibus;

			if (!(hiredVehiclesRegNumbers.isEmpty()) && (hiredVehiclesRegNumbers != null)) {
				for (String vehicle : hiredVehiclesRegNumbers) {
					String split[] = vehicle.split(" ");
					if (split[1].contentEquals("car")) {
						car = getObject(split[0], cars);
						l1.addElement("Car" + " " + car.getRegistrationNumber() + " " + car.getMake() + " "
								+ car.getModel() + " " + car.getDailyHireRate());
					} else if (split[1].contentEquals("lorry")) {
						lorry = getObject(split[0], lorries);
						l1.addElement("Lorry" + " " + lorry.getRegistrationNumber() + " " + lorry.getMake() + " "
								+ lorry.getModel() + " " + lorry.getDailyHireRate());
					} else {
						minibus = getObject(split[0], minibuses);
						l1.addElement("MiniBus" + " " + minibus.getRegistrationNumber() + " " + minibus.getMake() + " "
								+ minibus.getModel() + " " + minibus.getDailyHireRate());
					}
				}
			} else {
				l1.addElement("You have not hired a vehicle.");
			}
		}
		
		return l1;
	}

	public <T> T getObject(String registrationNumber, ArrayList<T> objects) {
		for (T obj : objects) {
			if (((Vehicle) obj).getRegistrationNumber().contentEquals(registrationNumber)) {
				return obj;
			}
		}
		return null;
	}
}
