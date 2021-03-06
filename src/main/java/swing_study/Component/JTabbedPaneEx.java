package swing_study.Component;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import swing_study.panel.Department;
import swing_study.panel.DeptPanel;
import swing_study.panel.EmployeePanel;
import swing_study.panel.Title;
import swing_study.panel.TitlePanel;

public class JTabbedPaneEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JTabbedPane tabbedPane;
	private DeptPanel pDept;
	private TitlePanel pTitle;
	private EmployeePanel pEmp;

	
	public JTabbedPaneEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		pDept = new DeptPanel();
		tabbedPane.addTab("부서", null, pDept, "부서 관리");
		
		pTitle = new TitlePanel();
		tabbedPane.addTab("직책", null, pTitle, "직책 관리");
		
		pEmp = new EmployeePanel();
		tabbedPane.addTab("사원", null, pEmp,"사원 관리");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		//선택된 탭가져와서
		Component comp =tabbedPane.getSelectedComponent();
		System.out.println(comp);
		//getXX()호출
		//
		if(comp == pDept) {
		DeptPanel deptPanel = (DeptPanel) comp;
		Department department = deptPanel.getDepartment();
		JOptionPane.showMessageDialog(null, department);
		} else if(comp == pTitle){
		TitlePanel titlePanel = (TitlePanel) comp;
		Title title = titlePanel.getTitle();
		JOptionPane.showMessageDialog(null, title);
		}
	}
}
