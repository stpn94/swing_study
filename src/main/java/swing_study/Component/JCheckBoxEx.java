package swing_study.Component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class JCheckBoxEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private int sum;
	private JLabel lblRes;
	private String resStr = "현재 0 원 입니다.";
	
	private JLabel label;
	private javax.swing.JCheckBox checkApple;
	private javax.swing.JCheckBox checkPear;
	private javax.swing.JCheckBox checkCheery;

	public JCheckBoxEx() {
		initialize();
		checkCheery.setSelected(true);
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pSouth = new JPanel();
		contentPane.add(pSouth);
		pSouth.setLayout(new BoxLayout(pSouth, BoxLayout.Y_AXIS));
		
		JLabel lblTitle = new JLabel("사과 100원 배 500원 체리 1000원");
		pSouth.add(lblTitle);
		
		JPanel panel = new JPanel();
		pSouth.add(panel);
		
		checkApple = new javax.swing.JCheckBox("사과");
		checkApple.addItemListener(this);
		panel.add(checkApple);
		
		checkPear = new javax.swing.JCheckBox("배");
		checkPear.addItemListener(this);
		panel.add(checkPear);
		
		checkCheery = new javax.swing.JCheckBox("체리");
		checkCheery.addItemListener(this);
		panel.add(checkCheery);
		
		lblRes = new JLabel(resStr);
		lblRes.setHorizontalAlignment(SwingConstants.CENTER);
		pSouth.add(lblRes);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth);
		label = new JLabel("pNorth패널 안 빈레이블");
		pNorth.add(label);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == checkCheery) {
			itemStateChangedCheckBox_2(e);
		}
		if (e.getSource() == checkPear) {
			itemStateChangedCheckBox_1(e);
		}
		if (e.getSource() == checkApple) {
			itemStateChangedCheckBox(e);
		}
		resStr = String.format("현재 %d 원 입니다.", sum);
		lblRes.setText(resStr);
	}
	protected void itemStateChangedCheckBox(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			sum += 100;
		}else {
			sum -= 100;
		}
	}
	protected void itemStateChangedCheckBox_1(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			sum += 500;
		}else {
			sum -= 500;
		}
	}
	protected void itemStateChangedCheckBox_2(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			sum += 1000;
		}else {
			sum -= 1000;
		}
	}
}
