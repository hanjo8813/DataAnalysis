package f1_lambda;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	public MyFrame() {

		Container c = getContentPane();
		JButton b = new JButton();
		b.setText("Hello");
		c.add(b);
		
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame();
	}

}
