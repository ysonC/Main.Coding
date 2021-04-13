import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import java.awt.event.*;
import javax.swing.JLabel;

public class ColorLabel extends JLabel
{
	Color drawColor; 
	Color borderColor;
	int borderSize; 
	int cnt = 0;
	
	public void setDrawColor(Color drawColor)
	{
		Random rand = new Random();
		//this.drawColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		//this.drawColor = Color.BLACK;
		setBackground(drawColor);
		addMouseListener(new event());
	}

	public class event extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			setBackground(changeColor());
		}
	}

	public Color changeColor()
	{
		cnt++;
		if (cnt%2 == 0)
            return (Color.red);
        else
            return (Color.black);
	}

	public ColorLabel( int width, int height, Color color,
			int borderWidth, Color borderCol )
	{
		// Member variable/attribute = parameter
		borderSize = borderWidth;
		drawColor = color;
		borderColor = borderCol;

		// Call some inherited methods from JLabel
		setMinimumSize( new Dimension(width, height) );
		setPreferredSize( new Dimension(width, height) );
	}

	public ColorLabel( int width, int height, Color color )
	{
		// Call the other constructor with some default values
		this( width, height, color, 0, null );
	} 

	// A default constructor for testing
	// public ColorLabel()
	// {	// Again delegate work to the complex constructor
	// 	this(200,200,Color.BLACK,5, Color.BLUE);
	// }

	// This is where we do all of the work...
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g); // Do NOT do normal drawing
		if ( borderColor != null )
		{
			g.setColor(borderColor);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
		if ( drawColor != null )
		{
			g.setColor(drawColor);
			g.fillRect(borderSize, borderSize, getWidth() - borderSize*2,
					getHeight()-borderSize*2);
		}

	}
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}

