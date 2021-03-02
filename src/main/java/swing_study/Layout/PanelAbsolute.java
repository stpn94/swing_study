package swing_study.Layout;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelAbsolute extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelAbsolute() {

		initialize();
	}
	private void initialize() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(152, 65, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(36, 64, 97, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(125, 46, 97, 23);
		add(btnNewButton_2);
		
		JButton button = new JButton("New button");
		button.setBounds(12, 72, 97, 23);
		add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(83, 10, 97, 23);
		add(button_1);
	}
}
