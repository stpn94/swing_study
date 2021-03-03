package swing_study.Component;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JToggleButton;

public class JButtonEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private String imgPath = System.getProperty("user.dir") + File.separator + "image" + File.separator;
	private JButton btn01;
	private JToggleButton tglBtn;
	
	public JButtonEx() {
		initialize();
	}
	private void initialize() {
		setTitle("JBottonEx");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 527, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel PLeft = new JPanel();
		contentPane.add(PLeft);
		
		btn01 = new JButton("Call");
		btn01.addActionListener(this);
		PLeft.setLayout(new BoxLayout(PLeft, BoxLayout.Y_AXIS));
		btn01.setIcon(new ImageIcon(imgPath+ "Nomal.gif"));
		btn01.setRolloverIcon(new ImageIcon(imgPath+ "rolloverIcon.gif"));
		btn01.setPressedIcon(new ImageIcon(imgPath+ "pressedIcon.gif"));
		PLeft.add(btn01);
		
		tglBtn = new JToggleButton("눌러봐");
		tglBtn.addActionListener(this);
		PLeft.add(tglBtn);
		
		JPanel PRight = new JPanel();
		contentPane.add(PRight);
		PRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel PTop = new JPanel();
		PTop.setBorder(new TitledBorder(null, "수평정렬", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PRight.add(PTop);
		PTop.setLayout(new GridLayout(0, 1, 0, 0));
		
		MyButton btn02 = new MyButton();
		btn02.setHorizontalAlignment(SwingConstants.LEFT);
		btn02.setText("LEFT");
		PTop.add(btn02);
		
		MyButton btn03 = new MyButton();
		btn03.setText("CENTER");
		PTop.add(btn03);
		
		MyButton btn04 = new MyButton();
		btn04.setText("RIGHT");
		btn04.setHorizontalAlignment(SwingConstants.RIGHT);
		PTop.add(btn04);
		
		JPanel PBottom = new JPanel();
		PRight.add(PBottom);
		PBottom.setLayout(new GridLayout(0, 3, 0, 0));
		
		MyButton btn01_1 = new MyButton();
		btn01_1.setVerticalAlignment(SwingConstants.TOP);
		PBottom.add(btn01_1);
		
		MyButton btn02_1 = new MyButton();
		PBottom.add(btn02_1);
		
		MyButton btn03_1 = new MyButton();
		btn03_1.setVerticalAlignment(SwingConstants.BOTTOM);
		PBottom.add(btn03_1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tglBtn) {
			actionPerformedTglBtn(e);
		}
	}
	protected void actionPerformedTglBtn(ActionEvent e) {
		if (tglBtn.isSelected()) {
			tglBtn.setText("눌렀네");
		}else {
			tglBtn.setText("눌러봐");
		}
	}
}