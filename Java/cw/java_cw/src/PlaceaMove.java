import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class PlaceaMove extends JPanel 
{
    private static final long serialVersionUID = -681389960013782662L;
 
    Color drawColor; //= Color.GREEN; 
	Color borderColor; //= Color.BLACK;
	int borderSize = 1; 
    //int cnt = 0;
    public PlaceaMove()
    {
        setBackground(Color.GREEN);
        setBorder(new LineBorder(Color.black));
        setMinimumSize( new Dimension(50, 50) );
		setPreferredSize( new Dimension(50, 50) );
        addMouseListener(new event());
    }

    public class event extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            Main.cnt++;
        if (Main.cnt%2 == 0)
        {
            setBackground(Color.BLACK);
            Main.turnLabel.setText("White turn");
        }
        else
        {
            setBackground(Color.white);
            
            Main.turnLabel.setText("Black turn");
        }
        // setBackground(changeColor());
        System.out.println("cnt = " + Main.cnt);
    }
}

    // public void paintComponent(Graphics g) 
    // {
    //     super.paintComponent(g);
    //     g.setColor(Color.BLUE);
    //     g.fillOval(getInsets().left, getInsets().top, 10, 10);
    //     System.out.println(this.getSize());
    //     System.out.println(this.getX() + "  " + this.getY());
    // }
}
