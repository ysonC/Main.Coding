package lec8;
import java.awt.Font;
import javax.swing.JLabel;

// Added a second constructor 
public class MyLabel2 extends JLabel
{
	public MyLabel2()
	{
		setText("My label");
		setFont(new Font("Ariel", Font.BOLD, 30));
	}

	public MyLabel2( String str )
	{
		super( str );
		setFont(new Font("Ariel", Font.BOLD, 30));
	}
}
