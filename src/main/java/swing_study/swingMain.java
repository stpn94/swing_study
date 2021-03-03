package swing_study;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing_study.Component.JButtonEx;
import swing_study.Component.JComponentEX;
import swing_study.Component.JLableEx;
import swing_study.Layout.FrameLayout;
import swing_study.Layout.LayoutGuBun;
import swing_study.frame.ContentPaneEx;
import swing_study.frame.JFrameEx;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import java.awt.Color;

public class swingMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn01;
	private JButton btn02;
	private JPanel PLayout;
	private JButton btnFlowLayout;
	private JButton btnBoderLayout;
	private JButton btnGridLayout;
	private JButton btnAbsoluteLayout;
	private JButton btnJComponent;
	private JPanel pComponent1;
	private JButton btn04;
	private JButton btn05;
	private JPanel PCheckRadio;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swingMain frame = new swingMain();
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
	public swingMain() {
		initialize();
	}

	private void initialize() {
		setTitle("스윙 스터티");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 10));

		btn01 = new JButton("JFreamEx");
		btn01.addActionListener(this);
		contentPane.add(btn01);

		btn02 = new JButton("JPanel");
		btn02.addActionListener(this);
		contentPane.add(btn02);

		PLayout = new JPanel();
		PLayout.setBorder(new TitledBorder(null, "레이아웃", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(PLayout);
		PLayout.setLayout(new GridLayout(0, 1, 0, 10));

		btnFlowLayout = new JButton("FlowLayout");
		btnFlowLayout.addActionListener(this);
//		btnFlowLayout.addActionListener(new ActionListener() {

//			@Override
//			public void actionPerformed(ActionEvent e) {
//				FrameLayout flow = new FrameLayout(LayoutGuBun.FLOW);
////				flow.setVisible(true);
//			}
//			
//		});

//		btnFlowLayout.addActionListener(e -> new FrameLayout(LayoutGuBun.FLOW)); //람다

		PLayout.add(btnFlowLayout);

		btnBoderLayout = new JButton("BoderLayout");
		btnBoderLayout.addActionListener(this);
		PLayout.add(btnBoderLayout);

		btnGridLayout = new JButton("GridLayout");
		btnGridLayout.addActionListener(this);
		PLayout.add(btnGridLayout);

		btnAbsoluteLayout = new JButton("AbsoluteLayout");
		btnAbsoluteLayout.addActionListener(this);
		PLayout.add(btnAbsoluteLayout);

		btnJComponent = new JButton("JComponent");
		btnJComponent.addActionListener(this);
		contentPane.add(btnJComponent);
		
		pComponent1 = new JPanel();
		pComponent1.setBorder(new TitledBorder(null, "JLabel & JToggleButton & JButton", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pComponent1);
		pComponent1.setLayout(new GridLayout(0, 1, 0, 10));
		
		btn04 = new JButton("JLable");
		btn04.addActionListener(this);
		pComponent1.add(btn04);
		
		btn05 = new JButton("JButton & JToggleButton");
		btn05.addActionListener(this);
		pComponent1.add(btn05);
		
		PCheckRadio = new JPanel();
		PCheckRadio.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "JCheckBox & JRadioBox", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(PCheckRadio);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn05) {
			actionPerformedBtn05(e);
		}
		if (e.getSource() == btn04) {
			actionPerformedBtn04(e);
		}
		if (e.getSource() == btnJComponent) {
			actionPerformedBtnJComponent(e);
		}
		if (e.getSource() == btnAbsoluteLayout) {
			actionPerformedBtnAbsoluteLayout(e);
		}
		if (e.getSource() == btnGridLayout) {
			actionPerformedBtnGridLayout(e);
		}
		if (e.getSource() == btnBoderLayout) {
			actionPerformedBtnBoderLayout(e);
		}
		if (e.getSource() == btnFlowLayout) {
			actionPerformedBtnFlowLayout(e);
		}
		if (e.getSource() == btn02) {
			actionPerformedBtn02(e);
		}
		if (e.getSource() == btn01) {
			actionPerformedBtn01(e);
		}
	}

	protected void actionPerformedBtn01(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContentPaneEx frame = new ContentPaneEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void actionPerformedBtn02(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx frame = new JFrameEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void actionPerformedBtnFlowLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGuBun.FLOW);
		frame.setVisible(true);
	}

	protected void actionPerformedBtnBoderLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGuBun.BORDER);
		frame.setVisible(true);
	}

	protected void actionPerformedBtnGridLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGuBun.GRID);
		frame.setVisible(true);
	}

	protected void actionPerformedBtnAbsoluteLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGuBun.ABSOLUTE);
		frame.setVisible(true);
	}

	protected void actionPerformedBtnJComponent(ActionEvent e) {
		JComponentEX frame = new JComponentEX();
		frame.setVisible(true);
	}

	protected void actionPerformedBtn04(ActionEvent e) {
		JLableEx frame = new JLableEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn05(ActionEvent e) {
		JButtonEx frame = new JButtonEx();
		frame.setVisible(true);
	}
}
