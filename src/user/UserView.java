package user;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

public class UserView {
	JButton jBtnLogin, jBtnRegisterCustomer, jBtnRegisterStaff, jBtnCancel;
	JTextField jTxtUsername, jTxtEmail, jTxtIdentificationNumber, jTxtCorporationName, jTxtAddress, jTxtPhoneNumber;
	JPasswordField jTxtPassword;
	JPanel panel;
	JFrame frame;

	//gui for staff to create a new staff account
	public void staffRegisterGUI(JFrame frame) {
		this.frame = frame;

		panel = new JPanel();

		panel.setLayout(null);
		
		//username and password JLabels
		JLabel jLblUsername = new JLabel("Username: ");
		JLabel jLblPassword = new JLabel("Password: ");

		JLabel jLblTitle = new JLabel("Enter Staff's Login Detail");

		Font font1 = new Font("SansSerif", Font.BOLD, 25);
		jLblTitle.setFont(font1);

		jTxtUsername = new JTextField(8);
		jTxtPassword = new JPasswordField(8);
		jBtnRegisterStaff = new JButton("Register");
		jBtnRegisterCustomer = new JButton();
		jBtnCancel = new JButton("Cancel");

		jLblTitle.setBounds(360, 80, 400, 30);

		//setting boundaries for jlabels and jtextfields
		jLblUsername.setBounds(330, 180, 200, 30);
		jTxtUsername.setBounds(490, 180, 200, 30);
		jLblPassword.setBounds(330, 250, 200, 30);
		jTxtPassword.setBounds(490, 250, 200, 30);
		jBtnRegisterStaff.setBounds(510, 330, 200, 30);
		jBtnCancel.setBounds(300, 330, 200, 30);

		panel.add(jLblTitle);
		panel.add(jLblUsername);
		panel.add(jTxtUsername);
		panel.add(jLblPassword);
		panel.add(jTxtPassword);
		panel.add(jBtnRegisterStaff);
		panel.add(jBtnCancel);

		panel.setSize(1000, 700);
		frame.add(panel);
	}

	//GUI for staff to create a new customer account
	public void customerRegisterGUI(JFrame frame) {
		this.frame = frame;

		panel = new JPanel();
		JPanel addCustomerPanel = new JPanel();
		panel.setLayout(null);

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
		jBtnCancel = new JButton("Cancel");

		jBtnCancel.setMaximumSize(new Dimension(350, 50));
		jBtnRegisterCustomer.setMaximumSize(new Dimension(350, 50));

		addCustomerPanel.add(jLblTitle);
		//creating a gap between titles and textbox
		addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addCustomerPanel.add(jLblIdentificationNumber);
		addCustomerPanel.add(jTxtIdentificationNumber);
		addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addCustomerPanel.add(jLblCorporationName);
		addCustomerPanel.add(jTxtCorporationName);
		addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addCustomerPanel.add(jLblAddress);
		addCustomerPanel.add(jTxtAddress); 
		addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addCustomerPanel.add(jLblPhoneNumber);
		addCustomerPanel.add(jTxtPhoneNumber);
		addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addCustomerPanel.add(jLblEmail);
		addCustomerPanel.add(jTxtEmail);
		addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addCustomerPanel.add(jLblUsername);
		addCustomerPanel.add(jTxtUsername);
		addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addCustomerPanel.add(jLblPassword);
		addCustomerPanel.add(jTxtPassword);
		addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addCustomerPanel.add(jBtnRegisterCustomer);
		addCustomerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		addCustomerPanel.add(jBtnCancel);

		addCustomerPanel.setLayout(new BoxLayout(addCustomerPanel, BoxLayout.Y_AXIS));
		addCustomerPanel.setBounds(370, 10, 300, 600);
		panel.add(addCustomerPanel);
		frame.add(panel);
	}

	//getters and setters
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

//	function to display error with arraylist as argument
	public void displayError(ArrayList<String> errors) {
		String err = "";
		//for each errors store it in error string
		for (String error : errors) {
			err = err + error + "\n";
		}
		//using a joptionpane to show the errors to the user
		JOptionPane.showMessageDialog(frame, err, "Error", JOptionPane.WARNING_MESSAGE);
	}
}
