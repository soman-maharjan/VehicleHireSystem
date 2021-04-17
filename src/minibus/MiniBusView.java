package minibus;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

public class MiniBusView {
		JButton jBtnAddMiniBus;
		JTextField jTxtMake, jTxtModel, jTxtTopSpeed, jTxtRegistrationNumber, jTxtDailyHireRate, jTxtSeatingCapacity;
		JPanel panel;
		JFrame frame;

		public void addMiniBusGUI(JFrame frame) {
			this.frame = frame;

			panel = new JPanel();
			JPanel addMinibusPanel = new JPanel();

			
			JLabel jLblTitle = new JLabel("Enter Minibus Details");
			
			Font font1 = new Font("SansSerif", Font.BOLD, 25);
			jLblTitle.setFont(font1);
			
			JLabel jLblMake = new JLabel("Make (Honda, Ford): ");
			JLabel jLblModel = new JLabel("Model (2015): ");
			JLabel jLblTopSpeed = new JLabel("Top Speed (150): ");
			JLabel jLblRegistrationNumber = new JLabel("Registration Number: ");
			JLabel jLblDailyHireRate = new JLabel("Daily Hire Rate: ");
			JLabel jLblSeatingCapacity = new JLabel("Seating Capacity: ");

			jTxtMake = new JTextField(8);
			jTxtModel = new JTextField(8);
			jTxtTopSpeed = new JTextField(8);
			jTxtRegistrationNumber = new JTextField(8);
			jTxtDailyHireRate = new JTextField(8);
			jTxtSeatingCapacity = new JTextField(8);
			jBtnAddMiniBus = new JButton("Add");

			jBtnAddMiniBus.setMaximumSize(new Dimension(280, 50));
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
			panel.add(jLblSeatingCapacity);
			panel.add(jTxtSeatingCapacity);
			panel.add(Box.createRigidArea(new Dimension(0, 20)));
			panel.add(jBtnAddMiniBus);
			
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.setBounds(370, 10, 250, 500);
			addMinibusPanel.add(panel);
			frame.add(addMinibusPanel);
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

		public int getSeatingCapacity() {
			return Integer.parseInt(jTxtSeatingCapacity.getText());
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
