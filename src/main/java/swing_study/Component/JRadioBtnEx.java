package swing_study.Component;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class JRadioBtnEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private String imgPath = System.getProperty("user.dir") + File.separator + "image" + File.separator;
	private ImageIcon[] icons = { new ImageIcon(imgPath + "사과.jpg"), new ImageIcon(imgPath + "배.jpg"),
			new ImageIcon(imgPath + "체리.jpg") };
	private JLabel lblImg;

	public JRadioBtnEx() {
		initialize();
	}

	private void initialize() {
		setTitle("라디오 버튼 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 10, 0));

		JPanel PLeft = new JPanel();
		PLeft.setBorder(new TitledBorder(null, "간단한 라디오 버튼", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(PLeft);
		PLeft.setLayout(new BorderLayout(0, 0));

		CustomRadioButton pRadio = new CustomRadioButton();
		PLeft.add(pRadio, BorderLayout.CENTER);

		JPanel PRight = new JPanel();
		PRight.setBorder(new TitledBorder(null, "라디오 버튼 응용예제", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(PRight);
		PRight.setLayout(new BorderLayout(0, 0));

		CustomRadioButton panel = new CustomRadioButton();
		PRight.add(panel, BorderLayout.NORTH);

		lblImg = new JLabel("");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		PRight.add(lblImg, BorderLayout.CENTER);

		for (JRadioButton r : panel.getRdBtns())
			r.addItemListener(this);
		
		panel.getRdbtnApple().setSelected(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JRadioButton rd = (JRadioButton) e.getSource();

		if (e.getStateChange() == ItemEvent.SELECTED) {
//			JOptionPane.showMessageDialog(null, rd.getText());
			String text = rd.getText();
			switch (text) {
			case "사과":
				lblImg.setIcon(icons[0]);
				break;
			case "배":
				lblImg.setIcon(icons[1]);
				break;
			default :
				lblImg.setIcon(icons[2]);
				break;

			}
		}
	}

}
