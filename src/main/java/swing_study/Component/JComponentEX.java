package swing_study.Component;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JComponentEX extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn2;
	private JButton btn3;
	private JButton btn1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public JComponentEX() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 225, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn1 = new JButton("Magenta/Tellow Button");
		btn1.setFont(new Font("Arial", Font.ITALIC, 20));
		btn1.setForeground(Color.MAGENTA);
		btn1.setBackground(Color.YELLOW);
		contentPane.add(btn1);
	
		btn2 = new JButton("disabled");
		btn2.addActionListener(this);
		btn2.setEnabled(false);
		contentPane.add(btn2);
		
		btn3 = new JButton("getX(),getY()");
		btn3.addActionListener(this);
		contentPane.add(btn3);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn2) {
			actionPerformedBtn2(e);
		}
		if (e.getSource() == btn3) {
			actionPerformedBtn3(e);
		}
	}
	protected void actionPerformedBtn3(ActionEvent e) {
		JButton btn =(JButton) e.getSource();
		JComponentEX parent = (JComponentEX) btn.getTopLevelAncestor();
		parent.setTitle(btn.getX() + "," + btn.getY());
		
		if (btn2.isEnabled()) {
			btn2.setEnabled(false);
		}else {
			btn2.setEnabled(true);
		}
	}
	protected void actionPerformedBtn2(ActionEvent e) {
		if(btn1 != null) {
			contentPane.remove(btn1);
			revalidate();
			
		}else {
			if(btn1.isVisible()) {
				btn1.setVisible(false);
			}else {
				btn1.setVisible(true);
			}
			
		}
	}
}
