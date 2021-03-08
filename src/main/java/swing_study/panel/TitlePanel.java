package swing_study.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class TitlePanel extends JPanel {
	private JTextField tfTitle;
	private JTextField tfDept;


	public TitlePanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblTitleName = new JLabel("부서번호");
		lblTitleName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitleName);
		
		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		add(tfTitle);
		
		JLabel lblTitleDept = new JLabel("부서번호");
		lblTitleDept.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitleDept);
		
		tfDept = new JTextField();
		tfDept.setColumns(10);
		add(tfDept);
	}
	
	public void setTitle(Title title) {
		
	}
	
	public Title getTitle() {
		return null;
	}
	
	public void clearTf() {
		
	}

}
