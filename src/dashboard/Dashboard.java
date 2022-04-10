package dashboard;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListModel;

import car.Car;
import lorry.Lorry;
import minibus.MiniBus;
import user.User;
import vehicle.Vehicle;

public class Dashboard {
	//returns all hired vehicles
	public ArrayList<String> getHiredVehicles(String fileName) {
		ArrayList<String> list = new ArrayList<String>();
		File requestFile = new File(fileName);
		//check if the file exists
		if (requestFile.exists()) {
			Scanner inputFile;
			//try copying the contents of the file
			try {
				inputFile = new Scanner(requestFile);
				while (inputFile.hasNext()) {
					list.add(inputFile.nextLine());
				}
				inputFile.close();
				return list;
				//catch any exception
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		return list = null;
	}

	public DefaultListModel<String> getCustomersHiredVehicle(String username, ArrayList<Car> cars,
			ArrayList<Lorry> lorries, ArrayList<MiniBus> minibuses) {
		final DefaultListModel<String> l1 = new DefaultListModel<>();
		l1.addElement(
				"S.N          Vehicle Type          Make          Model          Registration Number          Top Speed          Daily Hire Rate");
		ArrayList<String> hiredVehicles = getHiredVehicles("./src/resources/hiredVehicle.txt");
		if (hiredVehicles == null) {
			l1.addElement("You have not hired a vehicle.");
		} else {
			ArrayList<String> hiredVehiclesRegNumbers = new ArrayList<String>();
			for (String vehicle : hiredVehicles) {
				String[] vehicleInfo = vehicle.split("\\s+");
				if (vehicleInfo[2].contentEquals(username)) {
					hiredVehiclesRegNumbers.add(vehicleInfo[1] + " " + vehicleInfo[0]);
				}
			}

			Car car;
			Lorry lorry;
			MiniBus minibus;
			int i = 1;
			if (!(hiredVehiclesRegNumbers.isEmpty()) && (hiredVehiclesRegNumbers != null)) {
				for (String vehicle : hiredVehiclesRegNumbers) {
					String split[] = vehicle.split("\\s+");
					if (split[1].contentEquals("car")) {
						car = getObject(split[0], cars);
						if (car != null) {
							l1.addElement(i + "              " + "Car" + "                    " + car.getMake()
									+ "          " + car.getModel() + "                    "
									+ car.getRegistrationNumber() + "                                        "
									+ car.getTopSpeed() + "                    " + car.getDailyHireRate());
							i++;

						}

					} else if (split[1].contentEquals("lorry")) {
						lorry = getObject(split[0], lorries);
						if (lorry != null) {
							l1.addElement(i + "              " + "Lorry" + "                    " + lorry.getMake()
									+ "          " + lorry.getModel() + "                    "
									+ lorry.getRegistrationNumber() + "                                        "
									+ lorry.getTopSpeed() + "                    " + lorry.getDailyHireRate());
							i++;
						}
					} else {
						minibus = getObject(split[0], minibuses);
						if (minibus != null) {
							l1.addElement(i + "              " + "MiniBus" + "                    " + minibus.getMake()
									+ "          " + minibus.getModel() + "                    "
									+ minibus.getRegistrationNumber() + "                                        "
									+ minibus.getTopSpeed() + "                    " + minibus.getDailyHireRate());
							i++;
						}
					}
				}
			} else {
				l1.addElement("You have not hired a vehicle.");
			}
		}

		return l1;
	}

	//generic function to get object with matching registration number
	public <T> T getObject(String registrationNumber, ArrayList<T> objects) {
		for (T obj : objects) {
			if (((Vehicle) obj).getRegistrationNumber().contentEquals(registrationNumber)) {
				return obj;
			}
		}
		return null;
	}

	//update hired vehicles list
	public void rewriteHiredVehicle(String fileName, ArrayList<String> vehicles) {
		PrintWriter outputFile;
		try {
			outputFile = new PrintWriter(new FileWriter(fileName));
			for (String a : vehicles) {
				outputFile.println(a);
			}

			outputFile.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void writeHiredVehicle(String fileName, String vehicleInfo, String vehicleType) {
		PrintWriter outputFile;
		String[] val = vehicleInfo.split("\\s+");
		try {
			outputFile = new PrintWriter(new FileWriter(fileName, true));
			outputFile.println(vehicleType + " " + val[1] + " " + val[2]);
			outputFile.close();

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

	//function to get currently logged in user
	public User getUser(String username, ArrayList<User> users) {
		for (User user : users) {
			if (user.getUsername().contentEquals(username)) {
				return user;
			}
		}
		return null;
	}

	public DefaultListModel<String> getCustomersCarList(ArrayList<Car> cars, ArrayList<String> list) {
		int i = 1;

		ArrayList<String> regNumList = new ArrayList<String>();
		if (list != null && !(list.isEmpty())) {
			for (String b : list) {
				String[] val = b.split(" ");
				regNumList.add(val[1]);
			}
		}

		final DefaultListModel<String> l1 = new DefaultListModel<>();
		l1.addElement(
				"S.N          Make                    Model                    Registration Number                    Top Speed                    Daily Hire Rate");
		if (cars == null || cars.isEmpty()) {
			l1.addElement("No Cars Added!");
		} else {
			if (list != null && !(list.isEmpty())) {
				for (Car car : cars) {
					if (!(regNumList.contains(car.getRegistrationNumber()))) {
						l1.addElement(i + "              " + car.getMake() + "                     " + car.getModel()
								+ "                      " + car.getRegistrationNumber()
								+ "                                                " + car.getTopSpeed()
								+ "                        " + car.getDailyHireRate());
					}
				}
			} else {
				for (Car car : cars) {
					l1.addElement(i + "              " + car.getMake() + "                     " + car.getModel()
							+ "                      " + car.getRegistrationNumber()
							+ "                                                " + car.getTopSpeed()
							+ "                        " + car.getDailyHireRate());
					i++;
				}
			}
		}

		return l1;
	}

	public DefaultListModel<String> getCustomersMinibusList(ArrayList<MiniBus> minibuses, ArrayList<String> list) {
		int i = 1;
		ArrayList<String> regNumList = new ArrayList<String>();
		if (list != null && !(list.isEmpty())) {
			for (String b : list) {
				String[] val = b.split(" ");
				regNumList.add(val[1]);
			}
		}
		final DefaultListModel<String> l3 = new DefaultListModel<>();
		l3.addElement(
				"S.N          Make          Model          Registration Number          Top Speed          Daily Hire Rate          Seating Capacity");
		if (minibuses == null || minibuses.isEmpty()) {
			l3.addElement("No Minibus Added!");
		} else {
			if (list != null && !(list.isEmpty())) {
				for (MiniBus minibus : minibuses) {
					if (!(regNumList.contains(minibus.getRegistrationNumber()))) {
						l3.addElement(i + "              " + minibus.getMake() + "            " + minibus.getModel()
								+ "               " + minibus.getRegistrationNumber() + "                              "
								+ minibus.getTopSpeed() + "                    " + minibus.getDailyHireRate()
								+ "                              " + minibus.getSeatingCapacity());
					}
				}
			} else {
				for (MiniBus minibus : minibuses) {
					l3.addElement(i + "              " + minibus.getMake() + "            " + minibus.getModel()
							+ "               " + minibus.getRegistrationNumber() + "                              "
							+ minibus.getTopSpeed() + "                    " + minibus.getDailyHireRate()
							+ "                              " + minibus.getSeatingCapacity());
					i++;
				}
			}
		}
		return l3;
	}

	public DefaultListModel<String> getCustomersLorryList(ArrayList<Lorry> lorries, ArrayList<String> list) {
		ArrayList<String> regNumList = new ArrayList<String>();
		if (list != null && !(list.isEmpty())) {
			for (String b : list) {
				String[] val = b.split(" ");
				regNumList.add(val[1]);
			}
		}
		int i = 1;
		final DefaultListModel<String> l2 = new DefaultListModel<>();
		l2.addElement(
				"S.N          Make          Model          Registration Number          Top Speed          Daily Hire Rate          Load Capacity");
		if (lorries == null || lorries.isEmpty()) {
			l2.addElement("No Lorries Added!");
		} else {
			if (list != null && !(list.isEmpty())) {
				for (Lorry lorry : lorries) {
					if (!(regNumList.contains(lorry.getRegistrationNumber()))) {
						l2.addElement(i + "              " + lorry.getMake() + "          " + lorry.getModel()
								+ "            " + lorry.getRegistrationNumber() + "                              "
								+ lorry.getTopSpeed() + "                    " + lorry.getDailyHireRate()
								+ "                              " + lorry.getLoadCapacity());
					}
				}
			} else {
				for (Lorry lorry : lorries) {
					l2.addElement(i + "              " + lorry.getMake() + "          " + lorry.getModel()
							+ "            " + lorry.getRegistrationNumber() + "                              "
							+ lorry.getTopSpeed() + "                    " + lorry.getDailyHireRate()
							+ "                              " + lorry.getLoadCapacity());
					i++;
				}
			}
		}
		return l2;
	}

	public <T> DefaultListModel<String> getStaffVehicleList(ArrayList<T> t, String defaultMessage) {
		int i = 1;
		final DefaultListModel<String> l1 = new DefaultListModel<>();
		l1.addElement(
				"S.N                              Make                              Model                              Registration Number");
		if (t == null) {
			l1.addElement(defaultMessage);
		} else {
			if (t.isEmpty()) {
				l1.addElement(defaultMessage);
			}
			for (T a : t) {
				l1.addElement(i + "                                  " + ((Vehicle) a).getMake()
						+ "                                " + ((Vehicle) a).getModel()
						+ "                                 " + ((Vehicle) a).getRegistrationNumber());
				i++;
			}
		}
		return l1;
	}

	public DefaultListModel<String> getVehiceHireRequestList(ArrayList<String> list, ArrayList<String> hiredVechicles,
			String vehicleType) {
		String[] a = list.toArray(new String[0]);

		int i = 1;

		final DefaultListModel<String> l5 = new DefaultListModel<>();
		if (vehicleType.contentEquals("car")) {
			l5.addElement(
					"S.N                                                       Registration Number                                                                    Request By");
		} else if (vehicleType.contentEquals("lorry")) {
			l5.addElement(
					"S.N                               Registration Number                               Request By                               Load Capacity");
		} else {
			l5.addElement(
					"S.N                               Registration Number                               Request By                               Seating Capacity");
		}

		for (int k = 0; k < list.size(); k++) {
			String[] val = list.get(k).split("\\s+");
			if (val[0].contentEquals(vehicleType)) {
				if (hiredVechicles != null) {
					for (int j = 0; j < hiredVechicles.size(); j++) {
						String[] val1 = hiredVechicles.get(j).split("\\s+");
						if (val1[0].contentEquals(vehicleType)) {
							if ((val1[1].contentEquals(val[1]))) {
								a[k] = null;
							}
						}
					}
				}
			}
		}

		for (String x : a) {
			if (x != null) {
				String val9[] = x.split("\\s+");
				if (val9[0].contentEquals(vehicleType)) {

					if (vehicleType.contentEquals("car")) {
						l5.addElement(i + "                                                            " + val9[1]
								+ "                                                                                      "
								+ val9[2]);
					} else if (vehicleType.contentEquals("lorry")) {
						l5.addElement(i + "                                   " + val9[1]
								+ "                                                   " + val9[2]
								+ "                              " + val9[3]);
					} else {
						l5.addElement(i + "                                   " + val9[1]
								+ "                                                   " + val9[2]
								+ "                              " + val9[3]);
					}
				}
			}
		}
		return l5;
	}

	public DefaultListModel<String> getCustomersList(ArrayList<User> customers) {
		int i = 1;
		// display Customers on JList
		final DefaultListModel<String> l4 = new DefaultListModel<>();
		l4.addElement("S.N          Identification Number          Username          Corporation Name          Number");
		if (customers == null) {
			l4.addElement("No Customers Added!");
		} else {
			if (customers.isEmpty()) {
				l4.addElement("No Customers Added!");
			}
			for (User user : customers) {
				l4.addElement(i + "              " + user.getIdentificationNumber() + "                              "
						+ user.getUsername() + "              " + user.getCorporationName() + "                    "
						+ user.getPhoneNumber());
				i++;
			}
		}
		return l4;
	}
}
