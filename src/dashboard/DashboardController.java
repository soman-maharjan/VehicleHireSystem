package dashboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import car.Car;
import car.CarController;
import car.CarView;
import login.Login;
import login.LoginController;
import login.LoginView;
import lorry.Lorry;
import lorry.LorryController;
import lorry.LorryView;
import minibus.MiniBus;
import minibus.MiniBusController;
import minibus.MiniBusView;
import user.User;
import user.UserController;
import user.UserView;

public class DashboardController implements ActionListener {
	private StaffDashboardView staffView;
	private CustomerDashboardView customerView;
	private Dashboard model;
	private JFrame frame;
	ArrayList<Car> cars;
	ArrayList<MiniBus> minibuses;
	ArrayList<Lorry> lorries;
	ArrayList<User> customers;
	Car car;
	MiniBus minibus;
	Lorry lorry;
	User user;
	String username;

	public DashboardController(StaffDashboardView staffView, CustomerDashboardView customerView, Dashboard model,
			JFrame frame, String accountType, String username) {
		this.staffView = staffView;
		this.customerView = customerView;
		this.model = model;
		this.frame = frame;
		this.username = username;

		car = new Car("", 0, 0, "", 0, "", 0);
		minibus = new MiniBus("", 0, 0, "", 0, 0);
		lorry = new Lorry("", 0, 0, "", 0, 0);
		user = new User();

		File file1 = new File("./src/resources/carObjects.dat");
		File file2 = new File("./src/resources/minibusObjects.dat");
		File file3 = new File("./src/resources/lorryObjects.dat");
		File file4 = new File("./src/resources/customerObjects.dat");
		if (file1.exists()) {
			cars = car.getObjects("./src/resources/carObjects.dat");
		} else {
			cars = null;
		}
		if (file2.exists()) {
			minibuses = minibus.getObjects("./src/resources/minibusObjects.dat");
		} else {
			minibuses = null;
		}
		if (file3.exists()) {
			lorries = lorry.getObjects("./src/resources/lorryObjects.dat");
		} else {
			lorries = null;
		}
		if (file4.exists()) {
			customers = user.getObjects("./src/resources/customerObjects.dat");
		} else {
			customers = null;
		}

		if (accountType.contentEquals("customer")) {
			customerView.GUI(frame);
			customerView.displayVehicles(
					model.getCustomersCarList(cars, model.getHiredVehicles("./src/resources/hiredVehicle.txt")),
					model.getCustomersMinibusList(minibuses,
							model.getHiredVehicles("./src/resources/hiredVehicle.txt")),
					model.getCustomersLorryList(lorries, model.getHiredVehicles("./src/resources/hiredVehicle.txt")),
					model.getHiredVehicles("./src/resources/hiredVehicle.txt"));

			customerView.jBtnRequestVehicle.addActionListener(this);
			customerView.jBtnViewProfile.addActionListener(this);
			customerView.jBtnDisplayHiredVehicles.addActionListener(this);
			customerView.jBtnDisplayVehicles.addActionListener(this);
			customerView.jBtnLogout.addActionListener(this);

		} else {

			staffView.GUI(frame);
			staffView.displayVehicles(model.getStaffVehicleList(cars, "No cars addeed!"),
					model.getStaffVehicleList(lorries, "No Lorry addeed!"),
					model.getStaffVehicleList(minibuses, "No Minibus addeed!"));

			user = new User();
			File file = new File("./src/resources/customerObjects.dat");
			ArrayList<User> users = null;
			if(file.exists()) {
				users = user.getObjects("./src/resources/customerObjects.dat");
			}
			
			staffView.displayCustomerList(model.getCustomersList(users));
			staffView.displayCustomerDetail();

			staffView.displayCustomerData.setVisible(false);
			staffView.customerScrollPane.setVisible(false);
			staffView.jLblCustomerListTitle.setVisible(false);
			staffView.jLblCustomerDetailsTitle.setVisible(false);

			staffView.jBtnRegisterStaff.addActionListener(this);
			staffView.jBtnRegisterCustomer.addActionListener(this);
			staffView.jBtnAddVehicle.addActionListener(this);
			staffView.jBtnRemoveVehicle.addActionListener(this);
			staffView.jBtnDisplayAllCustomer.addActionListener(this);

			staffView.jBtnAddCar.addActionListener(this);
			staffView.jBtnAddMiniBus.addActionListener(this);
			staffView.jBtnAddLorry.addActionListener(this);
			staffView.jBtnDisplayHireRequest.addActionListener(this);
			staffView.jBtnHireOut.addActionListener(this);
			staffView.jBtnHiredVehicle.addActionListener(this);
			staffView.jBtnReturnVehicle.addActionListener(this);
			staffView.jBtnLogout.addActionListener(this);
			staffView.jBtnDisplayVehicles.addActionListener(this);

			staffView.list1.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						if (staffView.list1.getSelectedIndex() > 0) {
							if (!(staffView.list1.getSelectedValue().contentEquals("No Cars Added!"))) {
								Car carObj = cars.get(staffView.list1.getSelectedIndex() - 1);
								staffView.jLblNumberOfDoorsValue.setVisible(true);
								staffView.jLblNumberOfDoors.setVisible(true);
								staffView.jLblFuelTypeValue.setVisible(true);
								staffView.jLblFuelType.setVisible(true);
								staffView.jLblMakeValue.setText(carObj.getMake());
								staffView.jLblModelValue.setText(String.valueOf(carObj.getModel()));
								staffView.jLblTopSpeedValue.setText(String.valueOf(carObj.getTopSpeed()));
								staffView.jLblRegistrationNumberValue.setText(carObj.getRegistrationNumber());
								staffView.jLblDailyHireRateValue.setText(String.valueOf(carObj.getDailyHireRate()));
								staffView.jLblFuelTypeValue.setText(carObj.getFuelType());
								staffView.jLblNumberOfDoorsValue.setText(String.valueOf(carObj.getNumberOfDoors()));
								staffView.jLblLoadCapacity.setVisible(false);
								staffView.jLblLoadCapacityValue.setVisible(false);
								staffView.jLblSeatingCapacity.setVisible(false);
								staffView.jLblSeatingCapacityValue.setVisible(false);
							}
						}
					}
				}
			});

			staffView.list2.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						if (staffView.list2.getSelectedIndex() > 0) {
							if (!(staffView.list2.getSelectedValue().contentEquals("No Lorry Added!"))) {
								Lorry lorryObj = lorries.get(staffView.list2.getSelectedIndex() - 1);
								staffView.jLblLoadCapacity.setVisible(true);
								staffView.jLblLoadCapacityValue.setVisible(true);
								staffView.jLblMakeValue.setText(lorryObj.getMake());
								staffView.jLblModelValue.setText(String.valueOf(lorryObj.getModel()));
								staffView.jLblTopSpeedValue.setText(String.valueOf(lorryObj.getTopSpeed()));
								staffView.jLblRegistrationNumberValue.setText(lorryObj.getRegistrationNumber());
								staffView.jLblDailyHireRateValue.setText(String.valueOf(lorryObj.getDailyHireRate()));
								staffView.jLblLoadCapacityValue.setText(String.valueOf(lorryObj.getLoadCapacity()));
								staffView.jLblNumberOfDoorsValue.setVisible(false);
								staffView.jLblNumberOfDoors.setVisible(false);
								staffView.jLblSeatingCapacity.setVisible(false);
								staffView.jLblSeatingCapacityValue.setVisible(false);
								staffView.jLblFuelTypeValue.setVisible(false);
								staffView.jLblFuelType.setVisible(false);
							}
						}
					}
				}
			});

			staffView.list3.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						if (staffView.list3.getSelectedIndex() > 0) {
							if (!(staffView.list3.getSelectedValue().contentEquals("No Minibus Added!"))) {
								MiniBus minibus = minibuses.get(staffView.list3.getSelectedIndex() - 1);
								staffView.jLblSeatingCapacity.setVisible(true);
								staffView.jLblSeatingCapacityValue.setVisible(true);
								staffView.jLblMakeValue.setText(minibus.getMake());
								staffView.jLblModelValue.setText(String.valueOf(minibus.getModel()));
								staffView.jLblTopSpeedValue.setText(String.valueOf(minibus.getTopSpeed()));
								staffView.jLblRegistrationNumberValue.setText(minibus.getRegistrationNumber());
								staffView.jLblDailyHireRateValue.setText(String.valueOf(minibus.getDailyHireRate()));
								staffView.jLblSeatingCapacityValue
										.setText(String.valueOf(minibus.getSeatingCapacity()));
								staffView.jLblNumberOfDoorsValue.setVisible(false);
								staffView.jLblNumberOfDoors.setVisible(false);
								staffView.jLblLoadCapacity.setVisible(false);
								staffView.jLblLoadCapacityValue.setVisible(false);
								staffView.jLblFuelTypeValue.setVisible(false);
								staffView.jLblFuelType.setVisible(false);
							}
						}
					}
				}
			});

			staffView.list4.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						if (staffView.list4.getSelectedIndex() > 0) {
							if (!(staffView.list4.getSelectedValue().contentEquals("No Customers Added!"))) {
								User user = customers.get(staffView.list4.getSelectedIndex() - 1);
								staffView.jLblIdentificationNumberValue.setText(user.getIdentificationNumber());
								staffView.jLblCorporationNameValue.setText(user.getCorporationName());
								staffView.jLblAddressValue.setText(user.getAddress());
								staffView.jLblPhoneNumberValue.setText(user.getPhoneNumber());
								staffView.jLblEmailValue.setText(user.getEmail());
								staffView.jLblUsernameValue.setText(user.getUsername());
							}
						}
					}
				}
			});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == staffView.jBtnRegisterCustomer) {
			staffView.getPanel().setVisible(false);
			User user = new User();
			UserView userView = new UserView();
			UserController userController = new UserController(userView, user, frame, "customer");
		} else if (e.getSource() == staffView.jBtnRegisterStaff) {
			staffView.getPanel().setVisible(false);
			User user = new User();
			UserView userView = new UserView();
			UserController userController = new UserController(userView, user, frame, "staff");
		} else if (e.getSource() == staffView.jBtnAddVehicle) {
			staffView.jBtnAddCar.setVisible(true);
			staffView.jBtnAddMiniBus.setVisible(true);
			staffView.jBtnAddLorry.setVisible(true);
		} else if (e.getSource() == staffView.jBtnAddCar) {
			staffView.getPanel().setVisible(false);
			CarView carView = new CarView();
			Car carModel = new Car("", 0, 0, "", 0, "", 0);
			CarController carController = new CarController(carView, carModel, frame, username);
		} else if (e.getSource() == staffView.jBtnAddMiniBus) {
			staffView.getPanel().setVisible(false);
			MiniBus minibus = new MiniBus("", 0, 0, "", 0, 0);
			MiniBusView minibusView = new MiniBusView();
			MiniBusController minibusController = new MiniBusController(minibusView, minibus, frame, username);
		} else if (e.getSource() == staffView.jBtnAddLorry) {
			staffView.getPanel().setVisible(false);
			Lorry lorry = new Lorry("", 0, 0, "", 0, 0);
			LorryView lorryView = new LorryView();
			LorryController lorryController = new LorryController(lorryView, lorry, frame, username);
		} else if (e.getSource() == staffView.jBtnRemoveVehicle) {
			if (staffView.list1.getSelectedIndex() < 1 && staffView.list2.getSelectedIndex() < 1
					&& staffView.list3.getSelectedIndex() < 1) {

				staffView.displayError("Select One from the list");
			} else {
				if (staffView.list1.getSelectedIndex() > 0
						&& !(staffView.list1.getSelectedValue().contentEquals("No Cars Added!"))) {
					car.delete(cars, cars.get(staffView.list1.getSelectedIndex() - 1),
							"./src/resources/carObjects.dat");

					staffView.getPanel().setVisible(false);

					DashboardController dashboardController = new DashboardController(staffView, customerView, model,
							this.frame, "staff", username);
				}
				if (staffView.list2.getSelectedIndex() > 0
						&& !(staffView.list2.getSelectedValue().contentEquals("No Lorry Added!"))) {
					lorry.delete(lorries, lorries.get(staffView.list2.getSelectedIndex() - 1),
							"./src/resources/lorryObjects.dat");

					staffView.getPanel().setVisible(false);

					DashboardController dashboardController = new DashboardController(staffView, customerView, model,
							this.frame, "staff", username);
				}
				if (staffView.list3.getSelectedIndex() > 0
						&& !(staffView.list3.getSelectedValue().contentEquals("No Minibus Added!"))) {
					minibus.delete(minibuses, minibuses.get(staffView.list3.getSelectedIndex() - 1),
							"./src/resources/minibusObjects.dat");

					staffView.getPanel().setVisible(false);

					DashboardController dashboardController = new DashboardController(staffView, customerView, model,
							this.frame, "staff", username);
				}
			}
		} else if (e.getSource() == staffView.jBtnDisplayAllCustomer) {
			staffView.jBtnDisplayVehicles.setVisible(true);
			staffView.displayCustomerData.setVisible(true);
			staffView.customerScrollPane.setVisible(true);
			staffView.jLblCustomerListTitle.setVisible(true);
			staffView.jLblCustomerDetailsTitle.setVisible(true);
			if (staffView.displayHireRequestPanel != null) {
				staffView.displayHireRequestPanel.setVisible(false);
			}

			if (staffView.displayHiredVehiclePane != null) {
				staffView.displayHiredVehiclePane.setVisible(false);
			}
			hideVehiclesList();
		} else if (e.getSource() == customerView.jBtnRequestVehicle) {
			if (customerView.list1.getSelectedIndex() < 1 && customerView.list2.getSelectedIndex() < 1
					&& customerView.list3.getSelectedIndex() < 1) {
				customerView.displayError("Select One from the list");
			} else {
				if (customerView.list1.getSelectedIndex() > 0
						&& !(customerView.list1.getSelectedValue().contentEquals("No Cars Added!"))) {

					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to hire this vehicle?",
							"Confirm", dialogButton);
					if (dialogResult == 0) {
						PrintWriter outputFile;
						try {
							outputFile = new PrintWriter(
									new FileWriter("./src/resources/vehicleHireRequests.txt", true));
							outputFile.println(
									"car " + cars.get(customerView.list1.getSelectedIndex() - 1).getRegistrationNumber()
											+ " " + username);
							outputFile.close();
							customerView.list1.clearSelection();

							customerView.displaySuccessMessage();

						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
				if (customerView.list2.getSelectedIndex() > 0
						&& !(customerView.list2.getSelectedValue().contentEquals("No Lorry Added!"))) {
					try {
						int loadWeight = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Load Weight: ",
								JOptionPane.INFORMATION_MESSAGE));
						if (loadWeight > 0) {
							PrintWriter outputFile;
							try {
								outputFile = new PrintWriter(
										new FileWriter("./src/resources/vehicleHireRequests.txt", true));
								outputFile.println("lorry "
										+ lorries.get(customerView.list2.getSelectedIndex() - 1).getRegistrationNumber()
										+ " " + username + " " + loadWeight);
								outputFile.close();
								customerView.list2.clearSelection();

							} catch (IOException e1) {
								e1.printStackTrace();
							}
						} else {
							customerView.displayError("Load Weight cannot be negative!");
						}
					} catch (NumberFormatException e1) {
						customerView.displayError("Load Weight must be integer!");
					}

				}
				if (customerView.list3.getSelectedIndex() > 0
						&& !(customerView.list3.getSelectedValue().contentEquals("No Minibus Added!"))) {
					int seats = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number of seats required: ",
							JOptionPane.INFORMATION_MESSAGE));
					if (seats > 0) {
						PrintWriter outputFile;
						try {
							outputFile = new PrintWriter(
									new FileWriter("./src/resources/vehicleHireRequests.txt", true));
							outputFile.println("minibus "
									+ minibuses.get(customerView.list3.getSelectedIndex() - 1).getRegistrationNumber()
									+ " " + username + " " + seats);
							outputFile.close();
							customerView.list3.clearSelection();

						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else {
						customerView.displayError("Seats cannot be negative!");
					}
				}
			}
		} else if (e.getSource() == staffView.jBtnDisplayHireRequest) {
			staffView.jBtnDisplayVehicles.setVisible(true);
			hideVehiclesList();
			if (staffView.displayCustomerData != null) {
				staffView.displayCustomerData.setVisible(false);
				staffView.customerScrollPane.setVisible(false);
				staffView.jLblCustomerListTitle.setVisible(false);
				staffView.jLblCustomerDetailsTitle.setVisible(false);
			}
			if (staffView.displayHiredVehiclePane != null) {
				staffView.displayHiredVehiclePane.setVisible(false);
				staffView.jBtnReturnVehicle.setVisible(false);
			}
			staffView.jBtnHireOut.setVisible(true);
			ArrayList<String> list = new ArrayList<String>();
			File requestFile = new File("./src/resources/vehicleHireRequests.txt");
			if (requestFile.exists()) {

				Scanner inputFile;
				try {
					inputFile = new Scanner(requestFile);
					while (inputFile.hasNext()) {
						list.add(inputFile.nextLine());
					}
					inputFile.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

			} else {
				list = null;
			}
			ArrayList<String> hiredVehicleList = model.getHiredVehicles("./src/resources/hiredVehicle.txt");
			staffView.displayHireRequests(model.getVehiceHireRequestList(list, hiredVehicleList, "car"),
					model.getVehiceHireRequestList(list, hiredVehicleList, "lorry"),
					model.getVehiceHireRequestList(list, hiredVehicleList, "minibus"));

		} else if (e.getSource() == staffView.jBtnHireOut) {
			if (staffView.list5.getSelectedIndex() < 1 && staffView.list6.getSelectedIndex() < 1
					&& staffView.list7.getSelectedIndex() < 1) {

				staffView.displayError("Select One from the list");
			} else {
				if (staffView.list5.getSelectedIndex() > 0
						&& !(staffView.list5.getSelectedValue().contentEquals("No Vehicle Hire Request!"))) {

					model.writeHiredVehicle("./src/resources/hiredVehicle.txt", staffView.list5.getSelectedValue(),
							"car");

					staffView.getPanel().setVisible(false);

					JOptionPane.showMessageDialog(frame, "The vehicle has been hired out to customer!",
							"Vehicle Hire System", JOptionPane.INFORMATION_MESSAGE);

					DashboardController dashboardController = new DashboardController(staffView, customerView, model,
							this.frame, "staff", username);
				}
				if (staffView.list6.getSelectedIndex() > 0
						&& !(staffView.list6.getSelectedValue().contentEquals("No Vehicle Hire Request!"))) {

					model.writeHiredVehicle("./src/resources/hiredVehicle.txt", staffView.list6.getSelectedValue(),
							"lorry");

					staffView.getPanel().setVisible(false);

					JOptionPane.showMessageDialog(frame, "The vehicle has been hired out to customer!",
							"Vehicle Hire System", JOptionPane.INFORMATION_MESSAGE);

					DashboardController dashboardController = new DashboardController(staffView, customerView, model,
							this.frame, "staff", username);
				}
				if (staffView.list7.getSelectedIndex() > 0
						&& !(staffView.list7.getSelectedValue().contentEquals("No Vehicle Hire Request!"))) {

					model.writeHiredVehicle("./src/resources/hiredVehicle.txt", staffView.list7.getSelectedValue(),
							"minibus");

					staffView.getPanel().setVisible(false);

					JOptionPane.showMessageDialog(frame, "The vehicle has been hired out to customer!",
							"Vehicle Hire System", JOptionPane.INFORMATION_MESSAGE);

					DashboardController dashboardController = new DashboardController(staffView, customerView, model,
							this.frame, "staff", username);
				}
			}
		} else if (e.getSource() == staffView.jBtnHiredVehicle) {
			staffView.jBtnDisplayVehicles.setVisible(true);
			hideVehiclesList();

			staffView.jBtnReturnVehicle.setVisible(true);

			if (staffView.displayHireRequestPanel != null) {
				staffView.displayHireRequestPanel.setVisible(false);
				staffView.jBtnHireOut.setVisible(false);
			}

			if (staffView.displayCustomerData != null) {
				staffView.displayCustomerData.setVisible(false);
				staffView.customerScrollPane.setVisible(false);
				staffView.jLblCustomerListTitle.setVisible(false);
				staffView.jLblCustomerDetailsTitle.setVisible(false);
			}

			ArrayList<String> hiredVehicles = model.getHiredVehicles("./src/resources/hiredVehicle.txt");
			if (hiredVehicles != null) {
				staffView.displayHiredVehicles(hiredVehicles.toArray(new String[0]));
			} else {
				staffView.displayHiredVehicles(null);
			}

		} else if (e.getSource() == staffView.jBtnReturnVehicle) {
			if (staffView.list10.getSelectedIndex() > 0
					&& !(staffView.list10.getSelectedValue().contentEquals("No Vehicle has been Hired!"))) {
				ArrayList<String> hiredVehicles = model.getHiredVehicles("./src/resources/hiredVehicle.txt");
				String currentVal1 = staffView.list10.getSelectedValue();
				String[] currentVal = currentVal1.split("\\s+");
				for (int i = 0; i < hiredVehicles.size(); i++) {
					String[] split = hiredVehicles.get(i).split(" ");
					if (currentVal[1].contentEquals(split[1])) {
						hiredVehicles.remove(i);
					}
				}

				model.rewriteHiredVehicle("./src/resources/hiredVehicle.txt", hiredVehicles);

				staffView.getPanel().setVisible(false);

				DashboardController dashboardController = new DashboardController(staffView, customerView, model,
						this.frame, "staff", username);
			}
		} else if (e.getSource() == customerView.jBtnViewProfile) {
			customerView.jBtnRequestVehicle.setVisible(false);
			customerView.jBtnDisplayVehicles.setVisible(true);
			hideCustomerVehicles();
			if (customerView.hiredVehiclePanel != null) {
				customerView.hiredVehiclePanel.setVisible(false);
				customerView.jLblHiredVehicle.setVisible(false);
			}
			User user = model.getUser(username, model.getObjects("./src/resources/customerObjects.dat"));
			customerView.displayUserData(user);
		} else if (e.getSource() == customerView.jBtnDisplayHiredVehicles) {
			customerView.jBtnRequestVehicle.setVisible(false);
			customerView.jBtnDisplayVehicles.setVisible(true);
			if (customerView.userDataPanel != null) {
				customerView.userDataPanel.setVisible(false);
				customerView.jLblProfileTitle.setVisible(false);
			}

			hideCustomerVehicles();

			customerView.displayHiredVehicles(model.getCustomersHiredVehicle(username, cars, lorries, minibuses));
		} else if (e.getSource() == staffView.jBtnLogout) {
			staffView.getPanel().setVisible(false);
			Login loginModel = new Login();
			LoginView loginView = new LoginView();
			LoginController loginController = new LoginController(loginView, loginModel, frame);
		} else if (e.getSource() == staffView.jBtnDisplayVehicles) {
			staffHomepage();
		} else if (e.getSource() == customerView.jBtnDisplayVehicles) {
			customerHomepage();
		} else if (e.getSource() == customerView.jBtnLogout) {
			customerView.getPanel().setVisible(false);
			Login loginModel = new Login();
			LoginView loginView = new LoginView();
			LoginController loginController = new LoginController(loginView, loginModel, frame);
		}
	}

	public void hideVehiclesList() {
		if (staffView.carScrollPane != null) {
			staffView.getVehicleDataDisplayPanel().setVisible(false);
			staffView.carScrollPane.setVisible(false);
			staffView.minibusScrollPane.setVisible(false);
			staffView.lorryScrollPane.setVisible(false);
			staffView.jLblCarTitle.setVisible(false);
			staffView.jLblLorryTitle.setVisible(false);
			staffView.jLblMinibusTitle.setVisible(false);
			staffView.jLblVehicleDetails.setVisible(false);
		}
	}

	public void staffHomepage() {
		staffView.getPanel().setVisible(false);

		DashboardController dashboardController = new DashboardController(staffView, customerView, model, this.frame,
				"staff", username);
	}

	public void customerHomepage() {
		customerView.getPanel().setVisible(false);

		DashboardController dashboardController = new DashboardController(staffView, customerView, model, this.frame,
				"customer", username);
	}

	public void hideCustomerVehicles() {
		//hide components
		customerView.carScrollPane.setVisible(false);
		customerView.lorryScrollPane.setVisible(false);
		customerView.minibusScrollPane.setVisible(false);
		customerView.jLblMinibusTitle.setVisible(false);
		customerView.jLblCarTitle.setVisible(false);
		customerView.jLblLorryTitle.setVisible(false);
	}
}
