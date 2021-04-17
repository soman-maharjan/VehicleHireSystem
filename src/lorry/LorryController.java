package lorry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import minibus.MiniBus;

public class LorryController implements ActionListener{
	private LorryView view;
	private Lorry model;

	public LorryController(LorryView view, Lorry model, JFrame frame) {
		this.view = view;
		this.model = model;

		view.addLorryGUI(frame);

		view.jBtnAddLorry.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.jBtnAddLorry) {

			ArrayList<String> errors = new ArrayList<String>();

			errors = model.validateLorry(view.jTxtMake.getText(), view.jTxtModel.getText(), view.jTxtTopSpeed.getText(),
					view.jTxtRegistrationNumber.getText(), view.jTxtDailyHireRate.getText(),
					view.jTxtLoadCapacity.getText());

			// the error variable is checked if it consists of errors.
			// if it is empty then the user input is used to register a new user
			if (errors.size() == 0) {
				Lorry lorry = new Lorry(view.getMake(), view.getModel(), view.getTopSpeed(), view.getRegistrationNumber(),
						view.getDailyHireRate(), view.getLoadingCapacity());
				model.storeObject(lorry, "./src/resources/lorryObjects.dat");
			}else {
				// if the user input contains errors then the errors are displayed in the
				// JOptionPane as Alert
				view.displayError(errors);
			}
		}
	}
}
