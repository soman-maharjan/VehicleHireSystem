package minibus;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

public class MiniBusView {
		JButton jBtnAddMiniBus, jBtnCancel;
		JTextField jTxtMake, jTxtModel, jTxtTopSpeed, jTxtRegistrationNumber, jTxtDailyHireRate, jTxtSeatingCapacity;
		JPanel panel;
		JFrame frame;

		public void addMiniBusGUI(JFrame frame) {
			this.frame = frame;

			panel = new JPanel();
			JPanel addMinibusPanel = new JPanel();
			
			panel.setLayout(null);

			
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
			jBtnCancel = new JButton("Cancel");

			jBtnAddMiniBus.setMaximumSize(new Dimension(300, 70));
			jBtnCancel.setMaximumSize(new Dimension(300, 70));
			addMinibusPanel.add(jLblTitle);
			addMinibusPanel.add(Box.createRigidArea(new Dimension(0, 20)));
			addMinibusPanel.add(jLblMake);
			addMinibusPanel.add(jTxtMake);
			addMinibusPanel.add(Box.createRigidArea(new Dimension(0, 20)));
			addMinibusPanel.add(jLblModel);
			addMinibusPanel.add(jTxtModel);
			addMinibusPanel.add(Box.createRigidArea(new Dimension(0, 20)));
			addMinibusPanel.add(jLblTopSpeed);
			addMinibusPanel.add(jTxtTopSpeed);
			addMinibusPanel.add(Box.createRigidArea(new Dimension(0, 20)));
			addMinibusPanel.add(jLblRegistrationNumber);
			addMinibusPanel.add(jTxtRegistrationNumber);
			addMinibusPanel.add(Box.createRigidArea(new Dimension(0, 20)));
			addMinibusPanel.add(jLblDailyHireRate);
			addMinibusPanel.add(jTxtDailyHireRate);
			addMinibusPanel.add(Box.createRigidArea(new Dimension(0, 20)));
			addMinibusPanel.add(jLblSeatingCapacity);
			addMinibusPanel.add(jTxtSeatingCapacity);
			addMinibusPanel.add(Box.createRigidArea(new Dimension(0, 20)));
			addMinibusPanel.add(jBtnAddMiniBus);
			addMinibusPanel.add(Box.createRigidArea(new Dimension(0, 10)));
			addMinibusPanel.add(jBtnCancel);
			
			addMinibusPanel.setLayout(new BoxLayout(addMinibusPanel, BoxLayout.Y_AXIS));
			addMinibusPanel.setBounds(370, 10, 300, 530);
			panel.add(addMinibusPanel);
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

		public void displaySuccessMessage() {
			JOptionPane.showMessageDialog(frame,"Minibus Created!", "Success", JOptionPane.INFORMATION_MESSAGE);
			
		}
}
