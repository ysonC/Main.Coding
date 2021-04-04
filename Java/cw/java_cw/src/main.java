import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class main implements ActionListener
{
    JFrame guiFrame = new JFrame(); // create a jFrame object
    ColorLabel clickableLables = new ColorLabel(50, 50, Color.green);
    PlaceaMove panel = new PlaceaMove();
    Random rand = new Random();
    JPanel mainPanel = new JPanel();
    JPanel gridPanel = new JPanel();
    JButton button1 = new JButton("Press");
    static JLabel turnLabel = new JLabel("White goes first");
    public static int cnt = 0;

    public void createGUI()
    {
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close window exits
        guiFrame.setTitle("The Game");
        guiFrame.setLocationRelativeTo(null); // centre on screen
        guiFrame.getContentPane().setLayout(new FlowLayout());
        guiFrame.getContentPane().setLayout(new BorderLayout(2,2));

        turnLabel.setFont(new Font("Ariel", Font.BOLD, 20));
    
        mainPanel.setLayout(new FlowLayout());
        gridPanel.setLayout(new GridLayout(8,8));

        guiFrame.getContentPane().add(turnLabel, BorderLayout.NORTH );
		guiFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		guiFrame.getContentPane().add(button1, BorderLayout.SOUTH);
        guiFrame.getContentPane().add( new ColorLabel( 1, 1, Color.BLUE, 2, Color.GRAY ), BorderLayout.WEST );
		guiFrame.getContentPane().add( new ColorLabel( 1, 1, Color.BLUE, 2, Color.GRAY ), BorderLayout.EAST );
        

        mainPanel.add(gridPanel);


		for ( int i = 0 ; i < 64 ; i++ )
		{
            //ColorLabel clickableLables = new ColorLabel(50, 50, Color.green, 1, Color.BLACK);
            //gridPanel.add(clickableLables);
            PlaceaMove panel = new PlaceaMove();
            gridPanel.add(panel);
		}
        
        
        button1.addActionListener(this);
        guiFrame.repaint();
        guiFrame.pack(); // Resize frame to fit content
        guiFrame.setVisible(true);
    }

    
    public static void main(String[] args)
    {
        main run  = new main();
        run.createGUI();
    }   
    

    // public class event extends MouseAdapter
    // {
    //     @Override
    //     public void mouseClicked(MouseEvent e)
    //     {
    //         cnt++;
    //     if (cnt%2 == 0)
    //     {
    //         panel.setBackground(Color.white);
    //         System.out.println("print white");
    //     }
    //     else
    //         panel.setBackground(Color.black);
    //     // setBackground(changeColor());
    //     System.out.println("cnt = " + cnt);
    //     }

    // }

    @Override
	public void actionPerformed(ActionEvent e)
	{
		//label.setText(label.getText()+".");
	    button1.setBackground( new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        gridPanel.repaint();
	}

}

