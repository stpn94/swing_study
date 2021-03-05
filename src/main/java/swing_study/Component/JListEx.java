package swing_study.Component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class JListEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private String imgPath = System.getProperty("user.dir") + File.separator + "image" + File.separator;
	private ImageIcon[] icons = {
			new ImageIcon(imgPath + "icon1.png"),
			new ImageIcon(imgPath + "icon2.png"),
			new ImageIcon(imgPath + "icon3.png"),
			new ImageIcon(imgPath + "icon4.png")
			};
	private String[] fruits = {"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"}; 
	private JButton btn01;
	private JList<String> strList;
	
	
	public JListEx() {
		initialize();
	}
	private void initialize() {
		setTitle("JList 예제1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 0));
		
		strList = new JList<>();
		strList.setListData(fruits);
		contentPane.add(strList);
		
		JList <ImageIcon>list = new JList<>();
		list.setListData(icons);
		contentPane.add(list);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		btn01 = new JButton("첫리스트확인");
		btn01.addActionListener(this);
		panel.add(btn01);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn01) {
			actionPerformedBtn01(e);
		}
	}
	protected void actionPerformedBtn01(ActionEvent e) {
		int idx = strList.getSelectedIndex();
		String selStr = strList.getSelectedValue();
		List<String> selededList = strList.getSelectedValuesList();
		String msg = String.format("index : %d selectedValue %s selectedList %s",
				idx,selStr,selededList);
		
		JOptionPane.showMessageDialog(null, msg);
		
	}
}
