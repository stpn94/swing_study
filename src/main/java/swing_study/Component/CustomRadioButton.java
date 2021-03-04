package swing_study.Component;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CustomRadioButton extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnApple;
	private JRadioButton rdbtnPear;
	private JRadioButton rdbtnCheery;
	private ArrayList<JRadioButton> rdBtns;

	public CustomRadioButton() {
		rdBtns = new ArrayList<JRadioButton>();
		initialize();
		rdBtns.add(rdbtnApple);
		rdBtns.add(rdbtnPear);
		rdBtns.add(rdbtnCheery);
	}
	private void initialize() {
		
		rdbtnApple = new JRadioButton("사과");
		buttonGroup.add(rdbtnApple);
		add(rdbtnApple);
		
		rdbtnPear = new JRadioButton("배");
		buttonGroup.add(rdbtnPear);
		add(rdbtnPear);
		
		rdbtnCheery = new JRadioButton("체리");
		buttonGroup.add(rdbtnCheery);
		add(rdbtnCheery);

		
	}
	public JRadioButton getRdbtnApple() {
		return rdbtnApple;
	}
	public JRadioButton getRdbtnPear() {
		return rdbtnPear;
	}
	public JRadioButton getRdbtnCheery() {
		return rdbtnCheery;
	}
	public ArrayList<JRadioButton> getRdBtns() {
		return rdBtns;
	}
	
	

}
