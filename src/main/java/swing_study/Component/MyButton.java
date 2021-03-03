package swing_study.Component;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton {
	private String imgPath = System.getProperty("user.dir") + File.separator + "image" + File.separator;
	
	public MyButton() {
		setIcon(new ImageIcon(imgPath+ "Nomal.gif"));
		setRolloverIcon(new ImageIcon(imgPath+ "rolloverIcon.gif"));
		setPressedIcon(new ImageIcon(imgPath+ "pressedIcon.gif"));
	}

	
	
}
