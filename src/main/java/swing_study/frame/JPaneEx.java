package swing_study.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing_study.panel.Department;
import swing_study.panel.DeptPanel;

public class JPaneEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton setDept;
	private JButton getDept;
	private DeptPanel pDept;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPaneEx frame = new JPaneEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JPaneEx() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pDept = new DeptPanel();
		contentPane.add(pDept, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		setDept = new JButton("부서설정");
		setDept.addActionListener(this);
		panel.add(setDept);

		getDept = new JButton("부서가져오기");
		getDept.addActionListener(this);
		panel.add(getDept);

		btnClear = new JButton("클리어");
		btnClear.addActionListener(this);
		panel.add(btnClear);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == getDept) {
			actionPerformedGetDept(e);
		}
		if (e.getSource() == setDept) {
			actionPerformedSetDept(e);
		}
	}

	protected void actionPerformedSetDept(ActionEvent e) {
		Department dept = new Department(1, "기획", 9);
		pDept.setDepartment(dept);
	}

	protected void actionPerformedGetDept(ActionEvent e) {
		Department dept = pDept.getDepartment();
		JOptionPane.showMessageDialog(null, dept);

	}

	protected void actionPerformedBtnClear(ActionEvent e) {
		pDept.clearTf();
	}
}
