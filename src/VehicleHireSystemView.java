import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class VehicleHireSystemView {
	JButton jBtnEnter;
	private JPanel panel;
	private JFrame frame;

	public void GUI() {
		frame = new JFrame("Vehicle Hire System");

		panel = new JPanel();
		JLabel jLblTitle = new JLabel("Vehicle Hire System");
		jBtnEnter = new JButton("Use Now!");
		
		Font font1 = new Font("SansSerif", Font.BOLD, 25);
		jLblTitle.setFont(font1);
		
		panel.add(jBtnEnter);
		
		panel.setLayout(null);
		
		jLblTitle.setBounds(380, 180, 400, 30);
		jBtnEnter.setBounds(400, 300, 200, 40);
		panel.add(jLblTitle);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return this.frame;
	}

	public JPanel getPanel() {
		return this.panel;
	}
}
