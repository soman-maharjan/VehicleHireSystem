package car;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import user.User;

public class CarController implements ActionListener {
	private CarView view;
	private Car model;

	public CarController(CarView carView, Car carModel, JFrame frame) {
		this.view = carView;
		this.model = carModel;

		view.addCarGUI(frame);

		view.jBtnAddCar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.jBtnAddCar) {

			ArrayList<String> errors = new ArrayList<String>();

			errors = model.validateCar(view.jTxtmake.getText(), view.jTxtmodel.getText(), view.jTxttopSpeed.getText(),
					view.jTxtregistrationNumber.getText(), view.jTxtdailyHireRate.getText(),
					view.jTxtfuelType.getText(), view.jTxtnumberOfDoors.getText());

			// the error variable is checked if it consists of errors.
			// if it is empty then the user input is used to register a new user
			if (errors.size() == 0) {
				Car car = new Car(view.getMake(), view.getModel(), view.getTopSpeed(), view.getRegistrationNumber(),
						view.getDailyHireRate(), view.getFuelType(), view.getNumberOfDoors());
				model.storeObject(car, "./src/resources/carObjects.dat");
			} else {
				// if the user input contains errors then the errors are displayed in the
				// JOptionPane as Alert
				view.displayError(errors);
			}
		}
	}
}
