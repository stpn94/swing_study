package swing_study.Layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameLayout extends JFrame {

	private JPanel contentPane;
	private LayoutGuBun gubun;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public FrameLayout(LayoutGuBun gubun) {
		this.gubun = gubun;
		initialize();
	}
	private void initialize() {
		setTitle("레이아웃 종류");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel PSwitch = null;
		switch(gubun) {
		case FLOW:
			PSwitch = new PannelFlow();
			setTitle("플로우 레이아웃");
			break;
		case BORDER:
			PSwitch = new PanelBorder();
			setTitle("보더 레이아웃");
			break;
		case GRID:
			PSwitch = new PanelGrid();
			setTitle("그리드 레이아웃");
			break;
		case ABSOLUTE:
			PSwitch = new PanelAbsolute();
			setTitle("앱솔루트 레이아웃");
			break;
		}
		
		contentPane.add(PSwitch, BorderLayout.CENTER);
		
//		setVisible(true); //main에서 필요없다.
	}

}
