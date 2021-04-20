package minibus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import dashboard.CustomerDashboardView;
import dashboard.Dashboard;
import dashboard.DashboardController;
import dashboard.StaffDashboardView;

public class MiniBusController implements ActionListener{
	private MiniBusView view;
	private MiniBus model;
	private String username;

	public MiniBusController(MiniBusView view, MiniBus model, JFrame frame, String username) {
		this.view = view;
		this.model = model;
		this.username = username;

		view.addMiniBusGUI(frame);

		view.jBtnAddMiniBus.addActionListener(this);
		view.jBtnCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.jBtnAddMiniBus) {

			ArrayList<String> errors = new ArrayList<String>();

			errors = model.validateMiniBus(view.jTxtMake.getText(), view.jTxtModel.getText(), view.jTxtTopSpeed.getText(),
					view.jTxtRegistrationNumber.getText(), view.jTxtDailyHireRate.getText(),
					view.jTxtSeatingCapacity.getText());

			// the error variable is checked if it consists of errors.
			// if it is empty then the user input is used to register a new user
			if (errors.size() == 0) {
				MiniBus minibus = new MiniBus(view.getMake(), view.getModel(), view.getTopSpeed(), view.getRegistrationNumber(),
						view.getDailyHireRate(), view.getSeatingCapacity());
				model.storeObject(minibus, "./src/resources/minibusObjects.dat");
				
				homepage();
				
				view.displaySuccessMessage();
			}else {
				// if the user input contains errors then the errors are displayed in the
				// JOptionPane as Alert
				view.displayError(errors);
			}
		}else if(e.getSource() == view.jBtnCancel) {
			homepage();
		}
	}
	
	public void homepage() {
		view.panel.setVisible(false);
		Dashboard dashboard = new Dashboard();
		StaffDashboardView staffDashboardView = new StaffDashboardView();
		CustomerDashboardView customerDashboardView = new CustomerDashboardView();
		DashboardController dashboardController = new DashboardController(staffDashboardView, customerDashboardView,
				dashboard, view.frame, "staff", username);
	}
}
