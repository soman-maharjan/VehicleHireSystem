import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import login.Login;
import login.LoginController;
import login.LoginView;

public class VehicleHireSystemController implements ActionListener {
	private VehicleHireSystemView view;
	private VehicleHireSystemModel model;
	
	//VehicleHireSystemController constructor 
	public VehicleHireSystemController(VehicleHireSystemView view, VehicleHireSystemModel model) {
		this.model = model;
		this.view = view;
		
		//calling the VehicleHireSystemController Graphical user interface
		view.GUI();
		
		//adding a action listener to the enter button
		view.jBtnEnter.addActionListener(this);
		
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//when the user clicks enter the login panel is displayed
		view.getPanel().setVisible(false);
		Login loginModel = new Login();
		LoginView loginView = new LoginView();
		LoginController loginController = new LoginController(loginView, loginModel, view.getFrame());
	}
}
