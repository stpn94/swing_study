package swing_study.Layout;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;

public class PanelBorder extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelBorder() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(5, 10));
		
		JLabel lblCenter_1 = new JLabel("Center");
		lblCenter_1.setBackground(Color.ORANGE);
		lblCenter_1.setForeground(Color.LIGHT_GRAY);
		lblCenter_1.setOpaque(true);
		add(lblCenter_1, BorderLayout.CENTER);
		
		JLabel lblNorth = new JLabel("North");
		lblNorth.setOpaque(true);
		lblNorth.setBackground(Color.RED);
		add(lblNorth, BorderLayout.NORTH);
		
		JLabel lblEast = new JLabel("East");
		lblEast.setBackground(Color.GREEN);
		lblEast.setOpaque(true);
		add(lblEast, BorderLayout.EAST);
		
		JLabel lblSouth = new JLabel("South");
		lblSouth.setOpaque(true);
		lblSouth.setBackground(Color.CYAN);
		add(lblSouth, BorderLayout.SOUTH);
		
		JLabel lblWest = new JLabel("West");
		lblWest.setOpaque(true);
		lblWest.setBackground(Color.YELLOW);
		add(lblWest, BorderLayout.WEST);
	}

}
