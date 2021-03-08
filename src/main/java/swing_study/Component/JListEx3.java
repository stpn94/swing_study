package swing_study.Component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import swing_study.panel.Department;
import swing_study.panel.DeptPanel;
import javax.swing.ListSelectionModel;

public class JListEx3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAdd;
	private DeptPanel pLeftCenter;
	private JList<Department> deptList;
	private DefaultListModel<Department> model;
	private JPanel panel;
	private JButton btnConfirm;
	private JButton btnUpdate;
	private JButton btnDelete;
	private int idx;
	private Department selDept;
	
	
	public JListEx3() {
		initialize();
		model.addElement(new Department(1,"기획",8));
		model.addElement(new Department(2,"영업",18));
		model.addElement(new Department(3,"개발",28));
	}
	private void initialize() {
		setTitle("JList응용");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 663, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		pLeftCenter = new DeptPanel();
		pLeft.add(pLeftCenter, BorderLayout.CENTER);
		
		JPanel pLeftSouth = new JPanel();
		pLeft.add(pLeftSouth, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pLeftSouth.add(btnAdd);
		
		JPanel pRight = new JPanel();
		contentPane.add(pRight);
		
		deptList = new JList<>();
		deptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		deptList.setBorder(new EmptyBorder(0, 0, 0, 0));
		model = new DefaultListModel<Department>();
		pRight.setLayout(new BorderLayout(0, 0));
		deptList.setModel(model);
		pRight.add(deptList);
		
		panel = new JPanel();
		pRight.add(panel, BorderLayout.SOUTH);
		
		btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		panel.add(btnConfirm);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		panel.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		panel.add(btnDelete);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDelete) {
			actionPerformedBtnDelete(e);
		}
		if (e.getSource() == btnUpdate) {
			actionPerformedBtnUpdate(e);
		}
		if (e.getSource() == btnConfirm) {
			actionPerformedBtnConfirm(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
	}
	protected void actionPerformedBtnAdd(ActionEvent e) {
		if(btnAdd.getText().equals("추가")) {
			Department dept = pLeftCenter.getDepartment();
			pLeftCenter.clearTf();
			model.addElement(dept);
			JOptionPane.showMessageDialog(null, "추가되었습니다.");
		}else {
			idx = deptList.getSelectedIndex();
			Department dept = pLeftCenter.getDepartment();
			model.setElementAt(dept, idx);
			
			pLeftCenter.clearTf();
			btnAdd.setText("추가");
			JOptionPane.showMessageDialog(null, "변경되었습니다.");
		}
		
	}
	protected void actionPerformedBtnConfirm(ActionEvent e) { //확인
		try {
			idx = deptList.getSelectedIndex();
			selDept = model.get(idx);
			String message = String.format("%d%s%d", selDept.getDeptNo(),selDept.getDeptName(),selDept.getFloor());
			JOptionPane.showMessageDialog(null, message);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "확인할 부서를 선택해 주세요.");
		}
	}
	protected void actionPerformedBtnUpdate(ActionEvent e) { //수정
		try {
			Department id = deptList.getSelectedValue();
			pLeftCenter.setDepartment(id);
			btnAdd.setText("수정");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "수정할 부서를 선택해 주세요.");
		}
	}
	protected void actionPerformedBtnDelete(ActionEvent e) { //삭제
		try {
			idx = deptList.getSelectedIndex();
			selDept = model.remove(idx);
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "삭제할 부서를 선택해 주세요.");
		}
		
	}
}
