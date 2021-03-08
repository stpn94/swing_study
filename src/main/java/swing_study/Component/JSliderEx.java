package swing_study.Component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JSlider;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class JSliderEx extends JFrame implements ChangeListener {

	private JPanel contentPane;
	private JSlider sliderBlue;
	private JLabel lblColor;
	private JSlider sliderRed;
	private JSlider sliderGreen;
	
	public JSliderEx() {
		initialize();
		sliderRed.addChangeListener(this);
		sliderGreen.addChangeListener(this);
		sliderBlue.addChangeListener(this);
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pCenter = new JPanel();
		pCenter.setBorder(new EmptyBorder(0, 10, 0, 10));
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		sliderRed = new JSlider();
		sliderRed.setPaintTicks(true);
		sliderRed.setMinorTickSpacing(10);
		sliderRed.setMajorTickSpacing(50);
		sliderRed.setForeground(Color.RED);
		sliderRed.setMaximum(255);
		sliderRed.setPaintLabels(true);
		pCenter.add(sliderRed);
		sliderRed.setValue(128);
		
		sliderGreen = new JSlider();
		
		sliderGreen.setPaintTicks(true);
		sliderGreen.setPaintLabels(true);
		sliderGreen.setMinorTickSpacing(10);
		sliderGreen.setMaximum(255);
		sliderGreen.setMajorTickSpacing(50);
		sliderGreen.setForeground(Color.GREEN);
		sliderGreen.setValue(128);
		pCenter.add(sliderGreen);
		
		sliderBlue = new JSlider();
		
		sliderBlue.setPaintTicks(true);
		sliderBlue.setPaintLabels(true);
		sliderBlue.setMinorTickSpacing(10);
		sliderBlue.setMaximum(255);
		sliderBlue.setMajorTickSpacing(50);
		sliderBlue.setForeground(Color.BLUE);
		sliderBlue.setValue(128);
		pCenter.add(sliderBlue);
		
		JPanel pSouth = new JPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
		
		lblColor = new JLabel("New label");
		lblColor.setForeground(Color.YELLOW);
		lblColor.setOpaque(true);
		pSouth.add(lblColor);
	}

	public void stateChanged(ChangeEvent e) {
		int	green =sliderGreen.getValue();
		int	blue = sliderBlue.getValue();
		int	red = sliderRed.getValue();	
		
		String messge = String.format("Red(%d), Green(%d),Blue(%d)",red,green,blue);
		lblColor.setText(messge);
		lblColor.setBackground(new Color(red , green , blue));
	}

}
