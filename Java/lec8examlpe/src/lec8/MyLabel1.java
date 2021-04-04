package lec8;
import java.awt.Font;
import javax.swing.JLabel;

public class MyLabel1 extends JLabel
{
	public MyLabel1()
	{
		setText("My label");
		setFont(new Font("Ariel", Font.BOLD, 30));
	}
}
