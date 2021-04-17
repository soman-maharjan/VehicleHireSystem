package user;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

public class UserView {
	JButton jBtnLogin, jBtnRegisterCustomer, jBtnRegisterStaff;
	JTextField jTxtUsername, jTxtEmail, jTxtIdentificationNumber, jTxtCorporationName, jTxtAddress, jTxtPhoneNumber;
	JPasswordField jTxtPassword;
	JPanel panel;
	JFrame frame;

	public void staffRegisterGUI(JFrame frame) {
		this.frame = frame;

		panel = new JPanel();

		panel.setLayout(null);
		JLabel jLblUsername = new JLabel("Username: ");
		JLabel jLblPassword = new JLabel("Password: ");

		JLabel jLblTitle = new JLabel("Enter Staff's Login Detail");

		Font font1 = new Font("SansSerif", Font.BOLD, 25);
		jLblTitle.setFont(font1);

		jTxtUsername = new JTextField(8);
		jTxtPassword = new JPasswordField(8);
		jBtnRegisterStaff = new JButton("Register");
		jBtnRegisterCustomer = new JButton();
		
		jLblTitle.setBounds(360, 80, 400, 30);
		
		jLblUsername.setBounds(330,180,200,30);
		jTxtUsername.setBounds(490,180,200,30);
		jLblPassword.setBounds(330,250,200,30);
		jTxtPassword.setBounds(490,250,200,30);
		jBtnRegisterStaff.setBounds(420, 330, 200, 40);

		panel.add(jLblTitle);
		panel.add(jLblUsername);
		panel.add(jTxtUsername);
		panel.add(jLblPassword);
		panel.add(jTxtPassword);
		panel.add(jBtnRegisterStaff);

		panel.setSize(1000, 700);
		frame.add(panel);
	}

	public void customerRegisterGUI(JFrame frame) {
		this.frame = frame;

		panel = new JPanel();
		JPanel addCustomerPanel = new JPanel();

		JLabel jLblTitle = new JLabel("Enter Customer's Detail");

		Font font1 = new Font("SansSerif", Font.BOLD, 25);
		jLblTitle.setFont(font1);

		JLabel jLblIdentificationNumber = new JLabel("Customer Identification Number: ");
		JLabel jLblCorporationName = new JLabel("Corporation Name: ");
		JLabel jLblAddress = new JLabel("Address: ");
		JLabel jLblPhoneNumber = new JLabel("Phone Number: ");
		JLabel jLblEmail = new JLabel("Email: ");
		JLabel jLblUsername = new JLabel("Username: ");
		JLabel jLblPassword = new JLabel("Password: ");

		jTxtIdentificationNumber = new JTextField(8);
		jTxtCorporationName = new JTextField(8);
		jTxtAddress = new JTextField(8);
		jTxtPhoneNumber = new JTextField(8);
		jTxtEmail = new JTextField(8);
		jTxtUsername = new JTextField(8);
		jTxtPassword = new JPasswordField(8);
		jBtnRegisterCustomer = new JButton("Register");
		jBtnRegisterStaff = new JButton();

		jBtnRegisterCustomer.setMaximumSize(new Dimension(260, 50));

		panel.add(jLblTitle);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblIdentificationNumber);
		panel.add(jTxtIdentificationNumber);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblCorporationName);
		panel.add(jTxtCorporationName);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblAddress);
		panel.add(jTxtAddress);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblPhoneNumber);
		panel.add(jTxtPhoneNumber);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblEmail);
		panel.add(jTxtEmail);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblUsername);
		panel.add(jTxtUsername);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jLblPassword);
		panel.add(jTxtPassword);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		panel.add(jBtnRegisterCustomer);

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBounds(370, 10, 250, 500);
		addCustomerPanel.add(panel);
		frame.add(addCustomerPanel);
	}

	public String getIdentificationNumber() {
		return this.jTxtIdentificationNumber.getText().trim();
	}

	public String getCorporationName() {
		return this.jTxtCorporationName.getText().trim();
	}

	public String getAddress() {
		return this.jTxtAddress.getText().trim();
	}

	public String getPhoneNumber() {
		return this.jTxtPhoneNumber.getText().trim();
	}

	public String getEmail() {
		return this.jTxtEmail.getText().trim();
	}

	public String getUsername() {
		return this.jTxtUsername.getText().trim();
	}

	public String getPassword() {
		return this.jTxtPassword.getText().trim();
	}

	public void displayError(ArrayList<String> errors) {
		String err = "";
		for (String error : errors) {
			err = err + error + "\n";
		}
		JOptionPane.showMessageDialog(frame, err, "Error", JOptionPane.WARNING_MESSAGE);
	}
}
