package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dashboard.CustomerDashboardView;
import dashboard.Dashboard;
import dashboard.DashboardController;
import dashboard.StaffDashboardView;
import user.User;
import user.UserController;
import user.UserView;

public class LoginController implements ActionListener {
	private LoginView view;
	private Login model;
	private JFrame frame;

	public LoginController(LoginView view, Login model, JFrame frame) {
		this.view = view;
		this.model = model;
		this.frame = frame;

		view.GUI(frame);
		view.jBtnLoginCustomer.addActionListener(this);
		view.jBtnLoginStaff.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.jBtnLoginCustomer) {
			// creating a User class object to get all the users in the file and then
			// storing in the User ArrayList.
			User userModel = new User();

			if (model.checkIfFileExists("./src/resources/customerObjects.dat")) {
				ArrayList<User> users = userModel.getObjects("./src/resources/customerObjects.dat");

				String status = model.validate(view.getUsername(), view.getPassword(), users);
				if (status.contentEquals("Password Matched!")) {
					view.getPanel().setVisible(false);

					Dashboard dashboard = new Dashboard();
					StaffDashboardView staffDashboardView = new StaffDashboardView();
					CustomerDashboardView customerDashboardView = new CustomerDashboardView();
					DashboardController dashboardController = new DashboardController(staffDashboardView,
							customerDashboardView, dashboard, this.frame, "customer" , view.getUsername());
				} else {
					JOptionPane.showMessageDialog(frame, status, "Error", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(frame, "Username Does not Exist!", "Error", JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource() == view.jBtnLoginStaff) {
			User userModel = new User();

			if (model.checkIfFileExists("./src/resources/staffObjects.dat")) {
				ArrayList<User> users = userModel.getObjects("./src/resources/staffObjects.dat");

				String status = model.validate(view.getUsername(), view.getPassword(), users);
				if (status.contentEquals("Password Matched!")) {
					view.getPanel().setVisible(false);

					Dashboard dashboard = new Dashboard();
					StaffDashboardView staffDashboardView = new StaffDashboardView();
					CustomerDashboardView customerDashboardView = new CustomerDashboardView();
					DashboardController dashboardController = new DashboardController(staffDashboardView,
							customerDashboardView, dashboard, this.frame, "staff" , view.getUsername());
				} else {
					JOptionPane.showMessageDialog(frame, status, "Error", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(frame, "Username Does not Exist!", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
