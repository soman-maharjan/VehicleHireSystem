package dashboard;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import car.Car;
import lorry.Lorry;
import minibus.MiniBus;

public class CustomerDashboardView {
	JPanel panel, userDataPanel, hiredVehiclePanel;
	JFrame frame;
	JList<String> list1, list2, list3, hiredVehicleList;
	JButton jBtnRequestVehicle, jBtnViewProfile, jBtnDisplayVehicles, jBtnDisplayHiredVehicles;
	JLabel jLblIdentificationNumber, jLblIdentificationNumberValue, jLblCorporationName, jLblCorporationNameValue,
			jLblAddress, jLblAddressValue, jLblPhoneNumber, jLblPhoneNumberValue, jLblEmail, jLblEmailValue,
			jLblUsername, jLblUsernameValue;

	public void GUI(JFrame frame) {
		this.frame = frame;
		panel = new JPanel();
		panel.setLayout(null);

		jBtnRequestVehicle = new JButton("Request to Hire");
		jBtnViewProfile = new JButton("View Profile");
		jBtnDisplayVehicles = new JButton("Display Vehicles");
		jBtnDisplayHiredVehicles = new JButton("Display Hired Vehicles");

		jBtnViewProfile.setBounds(0, 40, 200, 30);
		jBtnRequestVehicle.setBounds(0, 0, 200, 30);
		jBtnDisplayVehicles.setBounds(0, 90, 200, 30);
		jBtnDisplayHiredVehicles.setBounds(220, 20, 200, 30);

		jBtnDisplayVehicles.setVisible(false);

		panel.add(jBtnViewProfile);
		panel.add(jBtnRequestVehicle);
		panel.add(jBtnDisplayVehicles);
		panel.add(jBtnDisplayHiredVehicles);
		panel.setSize(1000, 700);
		frame.add(panel);
	}

	public void displayVehicles(ArrayList<Car> cars, ArrayList<MiniBus> minibuses, ArrayList<Lorry> lorries,
			ArrayList<String> list) {

		ArrayList<String> regNumList = new ArrayList<String>();
		if (list != null && !(list.isEmpty())) {
			for (String b : list) {
				String[] val = b.split(" ");
				regNumList.add(val[1]);
			}
		}
		int i = 1;

		final DefaultListModel<String> l1 = new DefaultListModel<>();
		l1.addElement("S.N             Make                        Model                         Registration Number");
		if (cars == null || cars.isEmpty()) {
			l1.addElement("No Cars Added!");
		} else {
			if (list != null && !(list.isEmpty())) {
				for (Car car : cars) {
					if (!(regNumList.contains(car.getRegistrationNumber()))) {
						l1.addElement(
								i + "                 " + car.getMake() + "                        " + car.getModel()
										+ "                                       " + car.getRegistrationNumber());
					}
				}
			} else {
				for (Car car1 : cars) {
					l1.addElement(
							i + "                 " + car1.getMake() + "                        " + car1.getModel()
									+ "                                       " + car1.getRegistrationNumber());
					i++;
				}
			}
		}

		list1 = new JList<>(l1);
		list1.setBounds(250, 100, 400, 100);
		panel.add(list1);

		// display Lorry on JList
		i = 1;
		final DefaultListModel<String> l2 = new DefaultListModel<>();
		l2.addElement("S.N        Make            Model            Registration Number");
		if (lorries == null || lorries.isEmpty()) {
			l1.addElement("No Lorries Added!");
		} else {
			if (list != null && !(list.isEmpty())) {
				for (Lorry lorry : lorries) {
					if (!(regNumList.contains(lorry.getRegistrationNumber()))) {
						l2.addElement(i + "                 " + lorry.getMake() + "                        "
								+ lorry.getModel() + "                                       "
								+ lorry.getRegistrationNumber());
					}
				}
			} else {
				for (Lorry lorry : lorries) {
					l2.addElement(
							i + "                 " + lorry.getMake() + "                        " + lorry.getModel()
									+ "                                       " + lorry.getRegistrationNumber());
					i++;
				}
			}
		}
		list2 = new JList<>(l2);
		list2.setBounds(250, 240, 400, 100);
		panel.add(list2);

		// display Minibus on JList
		i = 1;
		final DefaultListModel<String> l3 = new DefaultListModel<>();
		l3.addElement("S.N        Make            Model            Registration Number");
		if (minibuses == null || minibuses.isEmpty()) {
			l3.addElement("No Minibus Added!");
		} else {
			if (list != null && !(list.isEmpty())) {
				for (MiniBus minibus : minibuses) {
					if (!(regNumList.contains(minibus.getRegistrationNumber()))) {
						l3.addElement(i + "                 " + minibus.getMake() + "                        "
								+ minibus.getModel() + "                                       "
								+ minibus.getRegistrationNumber());
					}
				}
			} else {
				for (MiniBus minibus : minibuses) {
					l3.addElement(i + "                 " + minibus.getMake() + "                        "
							+ minibus.getModel() + "                                       "
							+ minibus.getRegistrationNumber());
					i++;
				}
			}
		}
		list3 = new JList<>(l3);
		list3.setBounds(250, 370, 400, 100);
		panel.add(list3);
	}

	public void displayUserData() {
		userDataPanel = new JPanel();
		userDataPanel.setBackground(Color.black);
		jLblIdentificationNumber = new JLabel("Identificaiton Number: ");
		jLblIdentificationNumberValue = new JLabel("--");
		jLblCorporationName = new JLabel("Corporation Name: ");
		jLblCorporationNameValue = new JLabel("--");
		jLblAddress = new JLabel("Address: ");
		jLblAddressValue = new JLabel("--");
		jLblPhoneNumber = new JLabel("Phone Number: ");
		jLblPhoneNumberValue = new JLabel("--");
		jLblEmail = new JLabel("Email: ");
		jLblEmailValue = new JLabel("--");
		jLblUsername = new JLabel("Username: ");
		jLblUsernameValue = new JLabel("--");

		userDataPanel.setLayout(new BoxLayout(userDataPanel, BoxLayout.Y_AXIS));

		userDataPanel.add(jLblIdentificationNumber);
		userDataPanel.add(jLblIdentificationNumberValue);
		userDataPanel.add(jLblCorporationName);
		userDataPanel.add(jLblCorporationNameValue);
		userDataPanel.add(jLblAddress);
		userDataPanel.add(jLblAddressValue);
		userDataPanel.add(jLblPhoneNumber);
		userDataPanel.add(jLblPhoneNumberValue);
		userDataPanel.add(jLblEmail);
		userDataPanel.add(jLblEmailValue);
		userDataPanel.add(jLblUsername);
		userDataPanel.add(jLblUsernameValue);

		userDataPanel.setBounds(300, 100, 200, 250);
		panel.add(userDataPanel);
	}

	public void displayError(String error) {
		JOptionPane.showMessageDialog(frame, error, "Error", JOptionPane.WARNING_MESSAGE);
	}

	public JPanel getPanel() {
		return this.panel;
	}

	public void displayHiredVehicles(DefaultListModel<String> l1) {
		hiredVehiclePanel = new JPanel();
		hiredVehiclePanel.setLayout(null);

		hiredVehicleList = new JList<>(l1);
		hiredVehicleList.setBounds(0, 0, 400, 300);
		hiredVehiclePanel.add(hiredVehicleList);

		hiredVehiclePanel.setBounds(300, 100, 400, 300);
		panel.add(hiredVehiclePanel);

	}
}
