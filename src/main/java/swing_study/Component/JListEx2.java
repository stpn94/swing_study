package swing_study.Component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

public class JListEx2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfValue;
	private JList<String> nameList1;
	private ArrayList<String> stdList = new ArrayList<>();
	private JList nameList2;

	public JListEx2() {
		stdList.add("김인환");
		stdList.add("이태훈");
		stdList.add("김상건");
		stdList.add("전수린");
		initialize();
	}
	private void initialize() {
		setTitle("실시간 추가");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("입력후 Enter키");
		pNorth.add(lblTitle);
		
		tfValue = new JTextField();
		tfValue.addActionListener(this);
		pNorth.add(tfValue);
		tfValue.setColumns(10);
		
		JPanel pList = new JPanel();
		pList.setBorder(new EmptyBorder(0, 100, 0, 100));
		contentPane.add(pList, BorderLayout.CENTER);
		pList.setLayout(new GridLayout(0, 2, 10, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pList.add(scrollPane);
		
		nameList1 = new JList();
		nameList1.setListData(new Vector<String>(stdList));
		nameList1.setVisibleRowCount(5);
		scrollPane.setViewportView(nameList1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		pList.add(scrollPane_1);
		
		nameList2 = new JList<>();
		nameList2.setModel(getModel(stdList));
		scrollPane_1.setViewportView(nameList2);
	}

	private ListModel getModel(List<String> stdList) {
		DefaultListModel<String>model = new DefaultListModel<String>();
		for(String e : stdList) {
		model.addElement(e);
		}
		return model;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfValue) {
			actionPerformedTfValue(e);
		}
	}
	protected void actionPerformedTfValue(ActionEvent e) {
		String value = tfValue.getText().trim();
//		JOptionPane.showMessageDialog(null, value);
		
		stdList.add(value); //화면에서는 안뜨지만 배열엔 추가되어있다.
		nameList1.setListData(new Vector<String>(stdList)); //새로고침
		tfValue.setText(""); //텍스트칸 비워주고
		tfValue.requestFocus(); //텍스트칸에 커서가 가게 한다.
		
		DefaultListModel model = (DefaultListModel<String>) nameList2.getModel();
		model.addElement(value);
	}
}
