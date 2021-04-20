package lorry;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

public class LorryView {
	JButton jBtnAddLorry, jBtnCancel;
	JTextField jTxtMake, jTxtModel, jTxtTopSpeed, jTxtRegistrationNumber, jTxtDailyHireRate, jTxtLoadCapacity;
	JPanel panel;
	JFrame frame;

	public void addLorryGUI(JFrame frame) {
		this.frame = frame;

		panel = new JPanel();
		JPanel addLorryPanel = new JPanel();
		panel.setLayout(null);

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
		jBtnCancel = new JButton("Cancel");
		jBtnAddLorry.setMaximumSize(new Dimension(260, 50));
		jBtnCancel.setMaximumSize(new Dimension(260, 50));

		addLorryPanel.add(jLblTitle);
		addLorryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addLorryPanel.add(jLblMake);
		addLorryPanel.add(jTxtMake);
		addLorryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addLorryPanel.add(jLblModel);
		addLorryPanel.add(jTxtModel);
		addLorryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addLorryPanel.add(jLblTopSpeed);
		addLorryPanel.add(jTxtTopSpeed);
		addLorryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addLorryPanel.add(jLblRegistrationNumber);
		addLorryPanel.add(jTxtRegistrationNumber);
		addLorryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addLorryPanel.add(jLblDailyHireRate);
		addLorryPanel.add(jTxtDailyHireRate);
		addLorryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addLorryPanel.add(jLblLoadCapacity);
		addLorryPanel.add(jTxtLoadCapacity);
		addLorryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addLorryPanel.add(jBtnAddLorry);
		addLorryPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		addLorryPanel.add(jBtnCancel);

		addLorryPanel.setLayout(new BoxLayout(addLorryPanel, BoxLayout.Y_AXIS));
		addLorryPanel.setBounds(370, 10, 250, 530);
		panel.add(addLorryPanel);
		frame.add(panel);
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
	
	public void displaySuccessMessage(String success) {
		JOptionPane.showMessageDialog(frame, success, "Success", JOptionPane.INFORMATION_MESSAGE);
	}
}
