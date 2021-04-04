package lec8;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

// Changed to add static counter
public class MyLabel4 extends JLabel
{
	static int counter = 0;

	public MyLabel4()
	{
		setText("My label " + (++counter) );
		setFont(new Font("Ariel", Font.BOLD, 30));
	}

	public MyLabel4( String str )
	{
		super( str );
		setFont(new Font("Ariel", Font.BOLD, 30));
	}
	
	public void paintComponent(Graphics g)
	{
	    super.paintComponent(g); 
	    g.setColor(Color.RED);
	    g.drawOval(0,0,getWidth()-1,getHeight()-1);
	}
}
