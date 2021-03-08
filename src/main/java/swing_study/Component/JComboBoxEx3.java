package swing_study.Component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing_study.panel.Department;
import swing_study.panel.DeptPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JComboBoxEx3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private List<Department> deptList = new ArrayList<Department>();
	private JButton btnAdd;
	
	public JComboBoxEx3() {
		deptList.add(new Department(1,"기획",8));
		deptList.add(new Department(2,"영업",18));
		deptList.add(new Department(3,"개발",28));
		initialize();
	}
	private void initialize() {
		setTitle("JcomboBox 실전 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		DeptPanel pdept = new DeptPanel();
		pLeft.add(pdept, BorderLayout.CENTER);
		
		JPanel pBtn = new JPanel();
		pLeft.add(pBtn, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		JPanel pRight = new JPanel();
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		JComboBox cmbDept = new JComboBox();
		pRight.add(cmbDept);
		
		JButton btnOk = new JButton("확인");
		pRight.add(btnOk);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
	}
	protected void actionPerformedBtnAdd(ActionEvent e) {
		
	}
}
