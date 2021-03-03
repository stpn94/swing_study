package swing_study.Component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.io.File;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class JLableEx extends JFrame implements MouseListener {

	private JPanel contentPane;
	private String path = System.getProperty("user.dir") + File.separator + "image" + File.separator;
	private JLabel lblNorth;
	private JLabel lblCenter;
	private JLabel lblSouth;
	
	public JLableEx() {
		System.out.println(path);
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 318, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblNorth = new JLabel("사랑합니다.");
		lblNorth.addMouseListener(this);
		lblNorth.setOpaque(true);
		lblNorth.setBackground(Color.GREEN);
		lblNorth.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNorth, BorderLayout.NORTH);
		
		lblCenter = new JLabel("사진");
		lblCenter.setIcon(new ImageIcon(path+ "화면 캡처 2021-03-03 120612.png"));
		lblCenter.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCenter, BorderLayout.CENTER);
		
		lblSouth = new JLabel("보고싶으면 전화하세요");
		lblSouth.setBackground(Color.ORANGE);
		lblSouth.setOpaque(true);
		lblSouth.setIcon(new ImageIcon(path+ "화면 캡처 2021-03-03 120725.png"));
		lblSouth.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSouth, BorderLayout.SOUTH);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblNorth) {
			mouseClickedLblNorth(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedLblNorth(MouseEvent e) {
		lblCenter.setIcon(new ImageIcon(path+"화면 캡처 2021-03-03 120725.png"));
		lblSouth.setText("010-1234-1234");
		JOptionPane.showMessageDialog(null, "변경완료");
		
	}
}
