package dashboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import car.Car;
import lorry.Lorry;
import minibus.MiniBus;
import user.User;

public class StaffDashboardView {
	JButton jBtnAddVehicle, jBtnRegisterCustomer, jBtnRemoveVehicle, jBtnRegisterStaff, jBtnAddCar, jBtnAddMiniBus,
			jBtnAddLorry, jBtnDisplayAllCustomer, jBtnDisplayHireRequest, jBtnHireOut, jBtnReturnVehicle,
			jBtnHiredVehicle;
	JPanel panel, displayVehicleData, displayCustomerData, displayHireRequestPanel, displayHiredVehiclePanel,
			customerListPanel, carListPanel, lorryListPanel, minibusListPanel;
	JFrame frame;

	JList<String> list1, list2, list3, list4, list5, list6, list7, list10;

	JPanel carPanel;

	JLabel jLblMakeValue, jLblMake, jLblModel, jLblModelValue, jLblTopSpeed, jLblTopSpeedValue, jLblRegistrationNumber,
			jLblRegistrationNumberValue, jLblDailyHireRate, jLblDailyHireRateValue, jLblFuelType, jLblFuelTypeValue,
			jLblNumberOfDoors, jLblNumberOfDoorsValue, jLblLoadCapacity, jLblLoadCapacityValue, jLblSeatingCapacity,
			jLblSeatingCapacityValue, jLblCarTitle, jLblLorryTitle, jLblMinibusTitle, jLblIdentificationNumber,
			jLblIdentificationNumberValue, jLblCorporationName, jLblCorporationNameValue, jLblAddress, jLblAddressValue,
			jLblPhoneNumber, jLblPhoneNumberValue, jLblEmail, jLblEmailValue, jLblVehicleDetails, jLblCustomerListTitle,
			jLblCustomerDetailsTitle, jLblUsername, jLblUsernameValue;

	public void GUI(JFrame frame) {
		this.frame = frame;
		panel = new JPanel();
		panel.setLayout(null);

		jLblCarTitle = new JLabel("CARS");
		jLblLorryTitle = new JLabel("LORRY");
		jLblMinibusTitle = new JLabel("MINIBUS");

		jBtnRegisterCustomer = new JButton("Register a new Customer");
		jBtnRegisterStaff = new JButton("Register a new Staff");
		jBtnAddVehicle = new JButton("Add new Vehicle");
		jBtnRemoveVehicle = new JButton("Remove Vehicle");
		jBtnAddCar = new JButton("Add Car");
		jBtnAddMiniBus = new JButton("Add Mini Bus");
		jBtnAddLorry = new JButton("Add Lorry");
		jBtnDisplayAllCustomer = new JButton("Display all customers");
		jBtnDisplayHireRequest = new JButton("Hire Request");
		jBtnHireOut = new JButton("Hire Out");
		jBtnReturnVehicle = new JButton("Return Vehicle");
		jBtnHiredVehicle = new JButton("View all Hired Vehicles");

		jBtnAddVehicle.setBounds(10, 90, 200, 30);
		jBtnRemoveVehicle.setBounds(10, 130, 200, 30);
		jBtnRegisterCustomer.setBounds(10, 170, 200, 30);
		jBtnRegisterStaff.setBounds(10, 210, 200, 30);

		jBtnHireOut.setBounds(260, 10, 170, 30);
		jBtnReturnVehicle.setBounds(230, 10, 200, 30);
		jBtnDisplayHireRequest.setBounds(440, 10, 170, 30);
		jBtnDisplayAllCustomer.setBounds(620, 10, 170, 30);
		jBtnHiredVehicle.setBounds(800, 10, 170, 30);

		jBtnAddCar.setBounds(10, 290, 200, 30);
		jBtnAddMiniBus.setBounds(10, 330, 200, 30);
		jBtnAddLorry.setBounds(10, 370, 200, 30);

		jLblCarTitle.setBounds(450, 80, 200, 30);
		jLblCarTitle.setFont(new Font("Serif", Font.BOLD, 20));

		jLblLorryTitle.setBounds(450, 240, 200, 30);
		jLblLorryTitle.setFont(new Font("Serif", Font.BOLD, 20));

		jLblMinibusTitle.setBounds(450, 400, 200, 30);
		jLblMinibusTitle.setFont(new Font("Serif", Font.BOLD, 20));

		displayVehicleData = new JPanel();

		jLblMake = new JLabel("Make: ");
		jLblMakeValue = new JLabel("--");
		jLblModel = new JLabel("Model: ");
		jLblModelValue = new JLabel("--");
		jLblTopSpeed = new JLabel("Top Speed: ");
		jLblTopSpeedValue = new JLabel("--");
		jLblRegistrationNumber = new JLabel("Registration Number: ");
		jLblRegistrationNumberValue = new JLabel("--");
		jLblDailyHireRate = new JLabel("Daily Hire Rate: ");
		jLblDailyHireRateValue = new JLabel("--");
		jLblFuelType = new JLabel("Fuel Type: ");
		jLblFuelTypeValue = new JLabel("--");
		jLblNumberOfDoors = new JLabel("Number of Doors: ");
		jLblNumberOfDoorsValue = new JLabel("--");
		jLblLoadCapacity = new JLabel("Load Capacity: ");
		jLblLoadCapacityValue = new JLabel("--");
		jLblSeatingCapacity = new JLabel("Seating Capacity: ");
		jLblSeatingCapacityValue = new JLabel("--");

		jLblVehicleDetails = new JLabel("DETAILS");

		displayVehicleData.setLayout(new BoxLayout(displayVehicleData, BoxLayout.Y_AXIS));
		displayVehicleData.add(jLblMake);
		displayVehicleData.add(jLblMakeValue);
		displayVehicleData.add(jLblModel);
		displayVehicleData.add(jLblModelValue);
		displayVehicleData.add(jLblTopSpeed);
		displayVehicleData.add(jLblTopSpeedValue);
		displayVehicleData.add(jLblRegistrationNumber);
		displayVehicleData.add(jLblRegistrationNumberValue);
		displayVehicleData.add(jLblDailyHireRate);
		displayVehicleData.add(jLblDailyHireRateValue);
		displayVehicleData.add(jLblFuelType);
		displayVehicleData.add(jLblFuelTypeValue);
		displayVehicleData.add(jLblNumberOfDoors);
		displayVehicleData.add(jLblNumberOfDoorsValue);
		displayVehicleData.add(jLblLoadCapacity);
		displayVehicleData.add(jLblLoadCapacityValue);
		displayVehicleData.add(jLblSeatingCapacity);
		displayVehicleData.add(jLblSeatingCapacityValue);
		displayVehicleData.setBounds(770, 150, 200, 600);

		jLblVehicleDetails.setBounds(770, 100, 200, 30);
		jLblVehicleDetails.setFont(new Font("Serif", Font.BOLD, 20));

		panel.add(displayVehicleData);

		panel.add(jLblVehicleDetails);
		panel.add(jLblCarTitle);
		panel.add(jLblLorryTitle);
		panel.add(jLblMinibusTitle);
		panel.add(jBtnAddVehicle);
		panel.add(jBtnRemoveVehicle);
		panel.add(jBtnRegisterCustomer);
		panel.add(jBtnRegisterStaff);
		panel.add(jBtnDisplayAllCustomer);
		panel.add(jBtnDisplayHireRequest);
		panel.add(jBtnHireOut).setVisible(false);
		panel.add(jBtnReturnVehicle).setVisible(false);
		panel.add(jBtnHiredVehicle);

		panel.add(jBtnAddCar).setVisible(false);
		panel.add(jBtnAddMiniBus).setVisible(false);
		panel.add(jBtnAddLorry).setVisible(false);

		panel.setSize(1000, 700);

		frame.add(panel);
	}

	public JPanel getPanel() {
		return this.panel;
	}

	public void displayVehicles(ArrayList<Car> cars, ArrayList<MiniBus> minibuses, ArrayList<Lorry> lorries) {
		int i = 1;
		// display cars on JList

		carListPanel = new JPanel();
		lorryListPanel = new JPanel();
		minibusListPanel = new JPanel();
		final DefaultListModel<String> l1 = new DefaultListModel<>();
		l1.addElement(
				"S.N                              Make                              Model                              Registration Number");
		if (cars == null) {
			l1.addElement("No Cars Added!");
		} else {
			if (cars.isEmpty()) {
				l1.addElement("No Cars Added!");
			}
			for (Car car1 : cars) {
				l1.addElement(
						i + "                                 " + car1.getMake() + "                              "
								+ car1.getModel() + "                              " + car1.getRegistrationNumber());
				i++;
			}
		}
		list1 = new JList<>(l1);
		carListPanel.add(new JScrollPane(list1));
		carListPanel.setBounds(240, 120, 500, 100);
		panel.add(carListPanel);

		i = 1;
		// display Lorry on JList
		final DefaultListModel<String> l2 = new DefaultListModel<>();
		l2.addElement(
				"S.N                              Make                              Model                              Registration Number");
		if (lorries == null) {
			l2.addElement("No Lorry Added!");
		} else {
			if (lorries.isEmpty()) {
				l2.addElement("No Lorry Added!");
			}
			for (Lorry lorry1 : lorries) {
				l2.addElement(i + "                                 " + lorry1.getMake()
						+ "                              " + lorry1.getModel() + "                              "
						+ lorry1.getRegistrationNumber());
				i++;
			}
		}
		list2 = new JList<>(l2);
		lorryListPanel.add(new JScrollPane(list2));
		lorryListPanel.setBounds(240, 280, 500, 100);
		panel.add(lorryListPanel);

		// display Minibus on JList
		int k = 1;
		final DefaultListModel<String> l3 = new DefaultListModel<>();
		l3.addElement(
				"S.N                              Make                              Model                              Registration Number");
		if (minibuses == null) {
			l3.addElement("No Minibus Added!");
		} else {
			if (minibuses.isEmpty()) {
				l3.addElement("No Minibus Added!");
			}
			for (MiniBus minibus1 : minibuses) {
				l3.addElement(k + "                              " + minibus1.getMake()
						+ "                              " + minibus1.getModel() + "                              "
						+ minibus1.getRegistrationNumber());
				k++;
			}
		}
		list3 = new JList<>(l3);
		minibusListPanel.add(new JScrollPane(list3));
		minibusListPanel.setBounds(240, 440, 500, 100);
		panel.add(minibusListPanel);
	}

	public void displayError(String error) {
		JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.WARNING_MESSAGE);
	}

	public JPanel getVehicleDataDisplayPanel() {
		return displayVehicleData;
	}

	public void displayCustomerList(ArrayList<User> customers) {
		jLblCustomerListTitle = new JLabel("Customers");
		customerListPanel = new JPanel();
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
				l4.addElement(i + "          " + user.getIdentificationNumber() + "          " + user.getUsername()
						+ "          " + user.getCorporationName() + "          " + user.getPhoneNumber());
				i++;
			}
		}
		list4 = new JList<>(l4);
		customerListPanel.add(new JScrollPane(list4));
//		customerListPanel.setBackground(Color.black);

		jLblCustomerListTitle.setFont(new Font("Serif", Font.BOLD, 20));

		customerListPanel.setBounds(240, 130, 500, 400);
		jLblCustomerListTitle.setBounds(440, 80, 200, 30);
		panel.add(customerListPanel);
		panel.add(jLblCustomerListTitle);

	}

	public void displayCustomerDetail() {
		displayCustomerData = new JPanel();

		jLblCustomerDetailsTitle = new JLabel("Customer's Detail");

		jLblIdentificationNumber = new JLabel("Identification Number: ");
		jLblIdentificationNumberValue = new JLabel("--");
		jLblCorporationName = new JLabel("Corporation Name: ");
		jLblCorporationNameValue = new JLabel("--");
		jLblUsername = new JLabel("Username: ");
		jLblUsernameValue = new JLabel("--");
		jLblAddress = new JLabel("Address : ");
		jLblAddressValue = new JLabel("--");
		jLblPhoneNumber = new JLabel("Phone Number: ");
		jLblPhoneNumberValue = new JLabel("--");
		jLblEmail = new JLabel("Email: ");
		jLblEmailValue = new JLabel("--");

		displayCustomerData.setLayout(new BoxLayout(displayCustomerData, BoxLayout.Y_AXIS));

		displayCustomerData.add(jLblIdentificationNumber);
		displayCustomerData.add(jLblIdentificationNumberValue);
		displayCustomerData.add(jLblCorporationName);
		displayCustomerData.add(jLblCorporationNameValue);
		displayCustomerData.add(jLblUsername);
		displayCustomerData.add(jLblUsernameValue);
		displayCustomerData.add(jLblAddress);
		displayCustomerData.add(jLblAddressValue);
		displayCustomerData.add(jLblPhoneNumber);
		displayCustomerData.add(jLblPhoneNumberValue);
		displayCustomerData.add(jLblEmail);
		displayCustomerData.add(jLblEmailValue);
		displayCustomerData.setBounds(770, 130, 200, 600);

		jLblCustomerDetailsTitle.setFont(new Font("Serif", Font.BOLD, 20));
		jLblCustomerDetailsTitle.setBounds(770, 80, 200, 30);

		panel.add(displayCustomerData);
		panel.add(jLblCustomerDetailsTitle);
	}

	public void displayHireRequests(ArrayList<String> list, ArrayList<String> hiredVechicles) {
		displayHireRequestPanel = new JPanel();
		displayHireRequestPanel.setLayout(null);

		String[] a = list.toArray(new String[0]);

		int i = 1;

		final DefaultListModel<String> l5 = new DefaultListModel<>();
		l5.addElement("S.N      Vehicle Registration Number   Vehicle Request By       ");
		for (int k = 0; k < list.size(); k++) {
			String[] val = list.get(k).split(" ");
			if (val[0].contentEquals("car")) {
				if (hiredVechicles != null) {
					for (int j = 0; j < hiredVechicles.size(); j++) {
						String[] val1 = hiredVechicles.get(j).split(" ");
						if (val1[0].contentEquals("car")) {
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
				String val9[] = x.split(" ");
				if (val9[0].contentEquals("car")) {
					l5.addElement(x);
				}
			}

		}

		list5 = new JList<>(l5);
		list5.setBounds(0, 0, 600, 150);

		String[] b = list.toArray(new String[0]);

		i = 1;

		final DefaultListModel<String> l6 = new DefaultListModel<>();
		l6.addElement("S.N      Vehicle Registration Number   Vehicle Request By       ");
		for (int k = 0; k < list.size(); k++) {
			String[] val = list.get(k).split(" ");
			if (val[0].contentEquals("lorry")) {
				if (hiredVechicles != null) {
					for (int j = 0; j < hiredVechicles.size(); j++) {
						String[] val1 = hiredVechicles.get(j).split(" ");
						if (val1[0].contentEquals("lorry")) {
							if ((val1[1].contentEquals(val[1]))) {
								b[k] = null;
							}
						}
					}
				}
			}
		}
		for (String x : b) {
			if (x != null) {
				String val9[] = x.split(" ");
				if (val9[0].contentEquals("lorry")) {
					l6.addElement(x);
				}
			}

		}

		list6 = new JList<>(l6);
		list6.setBounds(0, 170, 600, 150);

		String[] c = list.toArray(new String[0]);

		i = 1;

		final DefaultListModel<String> l7 = new DefaultListModel<>();
		l7.addElement("S.N      Vehicle Registration Number   Vehicle Request By       ");
		for (int k = 0; k < list.size(); k++) {
			String[] val = list.get(k).split(" ");
			if (val[0].contentEquals("minibus")) {
				if (hiredVechicles != null) {
					for (int j = 0; j < hiredVechicles.size(); j++) {
						String[] val1 = hiredVechicles.get(j).split(" ");
						if (val1[0].contentEquals("minibus")) {
							if ((val1[1].contentEquals(val[1]))) {
								c[k] = null;
							}
						}
					}
				}
			}
		}
		for (String x : c) {
			if (x != null) {
				String val9[] = x.split(" ");
				if (val9[0].contentEquals("minibus")) {
					l7.addElement(x);
				}
			}

		}

		list7 = new JList<>(l7);
		list7.setBounds(0, 340, 600, 150);

		displayHireRequestPanel.add(list5);
		displayHireRequestPanel.add(list6);
		displayHireRequestPanel.add(list7);

		displayHireRequestPanel.setBounds(250, 100, 500, 600);

		panel.add(displayHireRequestPanel);
	}

	public void displayHiredVehicles(String[] hiredVehicles) {
		jBtnReturnVehicle.setVisible(true);
		displayHiredVehiclePanel = new JPanel();

		int i = 1;
		// display Customers on JList
		final DefaultListModel<String> l10 = new DefaultListModel<>();
		l10.addElement(
				"S.N                              Registration Number                              Hired By                              Vehicle Type");
		String vehicleType;
		if (hiredVehicles == null) {
			l10.addElement("No Vehicle has been Hired!");
		} else {
			for (String data : hiredVehicles) {
				String[] splittedData = data.split(" ");
				if (splittedData[0].contentEquals("car")) {
					vehicleType = "Car";
				} else if (splittedData[0].contentEquals("lorry")) {
					vehicleType = "Lorry";
				} else {
					vehicleType = "Minibus";
				}
				l10.addElement(i + "                              " + splittedData[1] + "                              "
						+ splittedData[2] + "                              " + vehicleType);
				i++;
			}
		}
		list10 = new JList<>(l10);
		displayHiredVehiclePanel.add(new JScrollPane(list10));

		displayHiredVehiclePanel.setBounds(250, 100, 600, 500);

		panel.add(displayHiredVehiclePanel);
	}
}
