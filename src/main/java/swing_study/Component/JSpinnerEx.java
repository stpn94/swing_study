package swing_study.Component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class JSpinnerEx extends JFrame {

	private JPanel contentPane;

	
	public JSpinnerEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"\uC18C\uC124", "\uC7A1\uC9C0", "\uC804\uACF5\uC11C\uC801", "\uCDE8\uBBF8"}));
		panel.add(spinner);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, -10, 10, 1));
		panel_2.add(spinner_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerDateModel(new Date(1615129200000L), new Date(1615129200000L), new Date(2593436400000L), Calendar.DAY_OF_YEAR));
		panel_1.add(spinner_2);
	}

}
