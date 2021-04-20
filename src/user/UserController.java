package user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dashboard.CustomerDashboardView;
import dashboard.Dashboard;
import dashboard.DashboardController;
import dashboard.StaffDashboardView;

public class UserController implements ActionListener {
	private User model;
	private UserView view;

	public UserController(UserView view, User model, JFrame frame, String accountType) {
		this.view = view;
		this.model = model;

		if (accountType.contentEquals("customer")) {
			this.view.customerRegisterGUI(frame);
		} else {
			this.view.staffRegisterGUI(frame);
		}

		view.jBtnRegisterCustomer.addActionListener(this);
		view.jBtnRegisterStaff.addActionListener(this);
		
		view.jBtnCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.jBtnRegisterCustomer) {
			ArrayList<String> errors = new ArrayList<String>();

			// validate user input
			// the validate function in User model checks if the user input is empty or not
			// and returns error of
			// type ArrayList in errors variable
			errors = model.validateCustomer(view.getIdentificationNumber(), view.getCorporationName(),
					view.getAddress(), view.getPhoneNumber(), view.getEmail(), view.getUsername(), view.getPassword());

			// the error variable is checked if it consists of errors.
			// if it is empty then the user input is used to register a new user
			if (errors.size() == 0) {
				model.setIdentificationNumber(view.getIdentificationNumber());
				model.setCorporationName(view.getCorporationName());
				model.setPhoneNumber(view.getPhoneNumber());
				model.setAddress(view.getAddress());
				model.setEmail(view.getEmail());
				model.setUsername(view.getUsername());
				model.setPassword(view.getPassword());

				// store the User model object in file
				model.storeObject(this.model, "./src/resources/customerObjects.dat");

				staffHomePage();
				
				JOptionPane.showMessageDialog(view.frame, "Customer Record Created!", "Success", JOptionPane.INFORMATION_MESSAGE);
			} else {
				// if the user input contains errors then the errors are displayed in the
				// JOptionPane as Alert
				view.displayError(errors);
			}
		} else if (e.getSource() == view.jBtnRegisterStaff) {
			ArrayList<String> errors = new ArrayList<String>();

			// validate user input
			// the validate function in User model checks if the user input is empty or not
			// and returns error of
			// type ArrayList in errors variable
			errors = model.validateStaff(view.getUsername(), view.getPassword());

			// the error variable is checked if it consists of errors.
			// if it is empty then the user input is used to register a new user
			if (errors.size() == 0) {
				model.setUsername(view.getUsername());
				model.setPassword(view.getPassword());

				// store the User model object in file
				model.storeObject(this.model, "./src/resources/staffObjects.dat");
				
				staffHomePage();
				
				JOptionPane.showMessageDialog(view.frame, "Staff Record Created!", "Success", JOptionPane.INFORMATION_MESSAGE);

			} else {
				// if the user input contains errors then the errors are displayed in the
				// JOptionPane as Alert
				view.displayError(errors);
			}
		}else if(e.getSource() == view.jBtnCancel) {
			staffHomePage();
		}

	}

	public void staffHomePage() {
		view.panel.setVisible(false);
		Dashboard dashboard = new Dashboard();
		StaffDashboardView staffDashboardView = new StaffDashboardView();
		CustomerDashboardView customerDashboardView = new CustomerDashboardView();
		DashboardController dashboardController = new DashboardController(staffDashboardView, customerDashboardView,
				dashboard, view.frame, "staff", view.getUsername());
	}
}
