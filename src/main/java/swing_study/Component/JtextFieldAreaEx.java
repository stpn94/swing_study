package swing_study.Component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class JtextFieldAreaEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfName;
	private JPasswordField pfpass1;
	private JPasswordField pfpass2;
	private JTextArea ta;
	private JLabel lblConfirm;
	private JDateChooser dateChooser;
	private JButton btnAdd;
	private JButton btnCencel;

	private void getMessage() {
		String pw1 = new String(pfpass1.getPassword());
		String pw2 = String.valueOf(pfpass2.getPassword());
		if (pw1.equals(pw2)) {
			lblConfirm.setText("일치");
		} else {
			lblConfirm.setText("불일치");

		}

	}

	public JtextFieldAreaEx() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pCenter.add(scrollPane, BorderLayout.CENTER);

		ta = new JTextArea();
		ta.setEditable(false);
		scrollPane.setViewportView(ta);

		JPanel pNorth = new JPanel();
		pNorth.setPreferredSize(new Dimension(450, 300));
		pNorth.setBorder(new EmptyBorder(10, 20, 10, 20));
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lblName);

		tfName = new JTextField();
		tfName.addActionListener(this);
		pNorth.add(tfName);
		tfName.setColumns(10);

		JLabel lblpass1 = new JLabel("비밀번호");
		lblpass1.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lblpass1);

		pfpass1 = new JPasswordField();
		pfpass1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO 삭제될때
				getMessage();
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO 추가될때
				getMessage();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO 수정될때
				getMessage();
			}
		});
		pNorth.add(pfpass1);

		JLabel lblpass2 = new JLabel("비밀번호 확인");
		lblpass2.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lblpass2);

		pfpass2 = new JPasswordField();
		pfpass2.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO 삭제될때
				getMessage();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO 추가될때
				getMessage();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO 수정될때
				getMessage();
			}

			
		});
		pNorth.add(pfpass2);

		JPanel panel = new JPanel();
		pNorth.add(panel);

		lblConfirm = new JLabel("불일치");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setFont(new Font("굴림", Font.BOLD, 15));
		lblConfirm.setForeground(Color.RED);
		lblConfirm.setBackground(Color.LIGHT_GRAY);
		pNorth.add(lblConfirm);

		JLabel lbl = new JLabel("생년월일");
		lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lbl);

		dateChooser = new JDateChooser(new Date());
		dateChooser.setDateFormatString("yyyy. MM. dd");
		pNorth.add(dateChooser);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pNorth.add(btnAdd);
		
		btnCencel = new JButton("취소");
		btnCencel.addActionListener(this);
		pNorth.add(btnCencel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCencel) {
			actionPerformedBtnCencel(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
		if(lblConfirm.getText().equals("일치")) {
			
		}else {
			pfpass2.setText("");
			pfpass2.requestFocus();
			pfpass1.selectAll();
		}
//		if (e.getSource() == tfName) {
//			actionPerformedTfName(e);
//		}
	}

//	protected void actionPerformedTfName(ActionEvent e) {
//		if (tfName.getText().length() != 0) {
//			Date d= dateChooser.getDate();
//			String msg = String.format("%s - %tF%n", tfName.getText(),d);
//			ta.append(msg);
//			tfName.setText("");
//		}
//	}
	protected void actionPerformedBtnAdd(ActionEvent e) {
		String pw1 = new String(pfpass1.getPassword());
		String pw2 = String.valueOf(pfpass2.getPassword());
		if (tfName.getText().length() != 0) {
			if (pw1.equals(pw2)) {
				Date d= dateChooser.getDate();
				String msg = String.format("%s - %tF%n", tfName.getText(),d);
				ta.append(msg);
				tfName.requestFocus();
				tfName.setText("");
				pfpass1.setText("");
				pfpass2.setText("");
				dateChooser.setDate(new Date());
				
			}else {
				pfpass1.selectAll();
				pfpass1.requestFocus();
				tfName.setText("");
				pfpass2.setText("");
				dateChooser.setDate(new Date());
				JOptionPane.showMessageDialog(null, "불일치 합니다");
				
			}
		}
		
	}
	protected void actionPerformedBtnCencel(ActionEvent e) {
		tfName.setText("");
		pfpass1.setText("");
		pfpass2.setText("");
		tfName.requestFocus();
		dateChooser.setDate(new Date());
	}
}
