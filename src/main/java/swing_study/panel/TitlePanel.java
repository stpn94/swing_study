package swing_study.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class TitlePanel extends JPanel {
	private JTextField tfTitleName;
	private JTextField tfTitleNo;


	public TitlePanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblTitleName = new JLabel("직책 이름");
		lblTitleName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitleName);
		
		tfTitleName = new JTextField();
		tfTitleName.setColumns(10);
		add(tfTitleName);
		
		JLabel lblTitleNo = new JLabel("직책 부서");
		lblTitleNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitleNo);
		
		tfTitleNo = new JTextField();
		tfTitleNo.setColumns(10);
		add(tfTitleNo);
	}
	
	public Title getTitle() { //텍스트박스안의 텍스트를 가져오기
		int titleNo = Integer.parseInt(tfTitleNo.getText().trim());
		String titleName = tfTitleName.getText().trim();
		
		return new Title(titleNo, titleName);
	}
	
	public void setTitle(Title title) {
		tfTitleNo.setText(title.gettNo()+"");
		tfTitleName.setText(title.gettName()+"");
		
	}
	
	public void clearTf() {
		tfTitleNo.setText("");
		tfTitleName.setText("");
	}

}
