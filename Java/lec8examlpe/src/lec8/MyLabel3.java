package lec8;
import java.awt.Font;
import javax.swing.JLabel;

// Changed to add static counter
public class MyLabel3 extends JLabel
{
	static int counter = 0;

	public MyLabel3()
	{
		setText("My label " + (++counter) );
		setFont(new Font("Ariel", Font.BOLD, 30));
	}

	public MyLabel3( String str )
	{
		super( str );
		setFont(new Font("Ariel", Font.BOLD, 30));
	}
}
