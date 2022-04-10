import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class VehicleHireSystemView {
	JButton jBtnEnter;
	private JPanel panel;
	private JFrame frame;

	// gui function that displays landing page
	public void GUI() {
		frame = new JFrame("VEHICLE HIRE SYSTEM");

		panel = new JPanel();
		JLabel jLblTitle = new JLabel("VEHICLE HIRE SYSTEM");
		jBtnEnter = new JButton("Use Now!");
		
		Font font1 = new Font("SansSerif", Font.BOLD, 25);
		jLblTitle.setFont(font1);
		
		panel.add(jBtnEnter);
		
		panel.setLayout(null);
		
		jLblTitle.setBounds(350, 180, 400, 30);
		jBtnEnter.setBounds(400, 300, 200, 40);
		panel.add(jLblTitle);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	//getter methods for JFrame and JPanel
	public JFrame getFrame() {
		return this.frame;
	}

	public JPanel getPanel() {
		return this.panel;
	}
}
