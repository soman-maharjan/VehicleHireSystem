package car;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CarView {

	JButton jBtnAddCar, jBtnCancel;
	JTextField jTxtmake, jTxtmodel, jTxttopSpeed, jTxtregistrationNumber, jTxtdailyHireRate, jTxtfuelType,
			jTxtnumberOfDoors;
	JPanel panel, addCarPanel;
	JFrame frame;

	//GUI to add cars in the system
	public void addCarGUI(JFrame frame) {
		this.frame = frame;

		panel = new JPanel();
		addCarPanel = new JPanel();
		addCarPanel.setLayout(null);

		JLabel jLblMake = new JLabel("Make (Honda, Ford): ");
		JLabel jLblModel = new JLabel("Model (2015): ");
		JLabel jLblTopSpeed = new JLabel("Top Speed (150): ");
		JLabel jLblRegistrationNumber = new JLabel("Registration Number: ");
		JLabel jLblDailyHireRate = new JLabel("Daily Hire Rate: ");
		JLabel jLblFuelType = new JLabel("Fuel Type (Petrol/Diesel): ");
		JLabel jLblNumberOfDoors = new JLabel("Number of Doors: ");

		JLabel jLblTitle = new JLabel("Enter Car Details");

		Font font1 = new Font("SansSerif", Font.BOLD, 25);
		jLblTitle.setFont(font1);

		jTxtmake = new JTextField(8);
		jTxtmodel = new JTextField(8);
		jTxttopSpeed = new JTextField(8);
		jTxtregistrationNumber = new JTextField(8);
		jTxtdailyHireRate = new JTextField(8);
		jTxtfuelType = new JTextField(8);
		jTxtnumberOfDoors = new JTextField(8);
		jBtnAddCar = new JButton("Add Car");
		jBtnCancel = new JButton("Cancel");

		jBtnAddCar.setMaximumSize(new Dimension(260, 50));
		jBtnCancel.setMaximumSize(new Dimension(260, 50));

		panel.add(jLblTitle);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblMake);
		panel.add(jTxtmake);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblModel);
		panel.add(jTxtmodel);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblTopSpeed);
		panel.add(jTxttopSpeed);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblRegistrationNumber);
		panel.add(jTxtregistrationNumber);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblDailyHireRate);
		panel.add(jTxtdailyHireRate);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblFuelType);
		panel.add(jTxtfuelType);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblNumberOfDoors);
		panel.add(jTxtnumberOfDoors);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jBtnAddCar);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(jBtnCancel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBounds(370, 10, 250, 600);
		addCarPanel.add(panel);
		frame.add(addCarPanel);
	}

	
	//GETTERS
	public JPanel getPanel() {
		return panel;
	}

	public String getMake() {
		return jTxtmake.getText().trim();
	}

	public int getModel() {
		return Integer.parseInt(jTxtmodel.getText());
	}

	public int getTopSpeed() {
		return Integer.parseInt(jTxttopSpeed.getText());
	}

	public int getNumberOfDoors() {
		return Integer.parseInt(jTxtnumberOfDoors.getText());
	}

	public double getDailyHireRate() {
		return Double.parseDouble(jTxtdailyHireRate.getText());
	}

	public String getFuelType() {
		return jTxtfuelType.getText().trim();
	}

	public String getRegistrationNumber() {
		return jTxtregistrationNumber.getText().trim();
	}

	//display error function that displays errors in JOptionPane
	public void displayError(ArrayList<String> errors) {
		String err = "";
		for (String error : errors) {
			err = err + error + "\n";
		}
		JOptionPane.showMessageDialog(frame, err, "Error", JOptionPane.WARNING_MESSAGE);
	}

	//display success message
	public void displaySuccessMessage() {
		JOptionPane.showMessageDialog(frame, "Car Created!", "Success", JOptionPane.INFORMATION_MESSAGE);

	}
}
