package lorry;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

public class LorryView {
	JButton jBtnAddLorry;
	JTextField jTxtMake, jTxtModel, jTxtTopSpeed, jTxtRegistrationNumber, jTxtDailyHireRate, jTxtLoadCapacity;
	JPanel panel;
	JFrame frame;

	public void addLorryGUI(JFrame frame) {
		this.frame = frame;

		panel = new JPanel();
		JPanel addLorryPanel = new JPanel();

		JLabel jLblMake = new JLabel("Make (Honda, Ford): ");
		JLabel jLblModel = new JLabel("Model (2015): ");
		JLabel jLblTopSpeed = new JLabel("Top Speed (150): ");
		JLabel jLblRegistrationNumber = new JLabel("Registration Number: ");
		JLabel jLblDailyHireRate = new JLabel("Daily Hire Rate: ");
		JLabel jLblLoadCapacity = new JLabel("Load Capacity: ");

		JLabel jLblTitle = new JLabel("Enter Lorry Details");

		Font font1 = new Font("SansSerif", Font.BOLD, 25);
		jLblTitle.setFont(font1);

		jTxtMake = new JTextField(8);
		jTxtModel = new JTextField(8);
		jTxtTopSpeed = new JTextField(8);
		jTxtRegistrationNumber = new JTextField(8);
		jTxtDailyHireRate = new JTextField(8);
		jTxtLoadCapacity = new JTextField(8);
		jBtnAddLorry = new JButton("Add Lorry");
		jBtnAddLorry.setMaximumSize(new Dimension(260, 50));

		panel.add(jLblTitle);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblMake);
		panel.add(jTxtMake);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblModel);
		panel.add(jTxtModel);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblTopSpeed);
		panel.add(jTxtTopSpeed);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblRegistrationNumber);
		panel.add(jTxtRegistrationNumber);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblDailyHireRate);
		panel.add(jTxtDailyHireRate);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblLoadCapacity);
		panel.add(jTxtLoadCapacity);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jBtnAddLorry);

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBounds(370, 10, 250, 500);
		addLorryPanel.add(panel);
		frame.add(addLorryPanel);
	}

	public JPanel getPanel() {
		return panel;
	}

	public String getMake() {
		return jTxtMake.getText().trim();
	}

	public int getModel() {
		return Integer.parseInt(jTxtModel.getText());
	}

	public int getTopSpeed() {
		return Integer.parseInt(jTxtTopSpeed.getText());
	}

	public int getLoadingCapacity() {
		return Integer.parseInt(jTxtLoadCapacity.getText());
	}

	public double getDailyHireRate() {
		return Double.parseDouble(jTxtDailyHireRate.getText());
	}

	public String getRegistrationNumber() {
		return jTxtRegistrationNumber.getText().trim();
	}

	public void displayError(ArrayList<String> errors) {
		String err = "";
		for (String error : errors) {
			err = err + error + "\n";
		}
		JOptionPane.showMessageDialog(frame, err, "Error", JOptionPane.WARNING_MESSAGE);
	}
}
