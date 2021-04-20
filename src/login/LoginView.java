package login;

import java.awt.Font;

import javax.swing.*;

public class LoginView {
	JButton jBtnLoginCustomer, jBtnLoginStaff;
	JTextField jTxtUsername;
	JPasswordField jTxtPassword;
	JPanel panel;

	public void GUI(JFrame frame) {
		panel = new JPanel();
		
		panel.setLayout(null);
		
		JLabel jLblLogin = new JLabel("LOGIN");
		
		JLabel jLblUsername = new JLabel("Username: ");
		JLabel jLblPassword = new JLabel("Password: ");
		jTxtUsername = new JTextField(8);
		jTxtPassword = new JPasswordField(8);
		jBtnLoginCustomer = new JButton("Customer Login");
		jBtnLoginStaff = new JButton("Staff Login");
		
		
		Font font1 = new Font("SansSerif", Font.BOLD, 25);
		jLblLogin.setFont(font1);
		
		
		jLblLogin.setBounds(460, 90, 100, 30);
		jLblUsername.setBounds(330, 180, 100, 30);
		jTxtUsername.setBounds(490, 180, 200, 30);
		jLblPassword.setBounds(330, 250, 100, 30);
		jTxtPassword.setBounds(490, 250, 200, 30);
		
		jBtnLoginCustomer.setBounds(340, 350, 150, 30);
		jBtnLoginStaff.setBounds(530, 350, 150, 30);
		
		
		
		panel.add(jLblLogin);
		panel.add(jLblUsername);
		panel.add(jTxtUsername);
		panel.add(jLblPassword);
		panel.add(jTxtPassword);
		panel.add(jBtnLoginCustomer);
		panel.add(jBtnLoginStaff);

		panel.setSize(1000, 700);
		frame.add(panel);
	}

	public String getUsername() {
		return jTxtUsername.getText().trim();
	}

	public String getPassword() {
		return jTxtPassword.getText().trim();
	}

	public JPanel getPanel() {
		return this.panel;
	}
}
