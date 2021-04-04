import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main implements ActionListener 
{
    JFrame guiFrame = new JFrame(); // create a jFrame object
    ColorLabel[] arrayLables = new ColorLabel[64]; //array of object reference 
    Random rand = new Random();
    JPanel mainPanel = new JPanel();
    JPanel gridPanel = new JPanel();
    JButton button1 = new JButton("Press");
    JLabel testColorLable = new JLabel("HELOLOLO");
    JLabel testColorLable2 = new JLabel("123123123");

    public void createGUI()
    {
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close window exits
        guiFrame.setTitle("Label Demo");
        guiFrame.setLocationRelativeTo(null); // centre on screen
        guiFrame.getContentPane().setLayout(new FlowLayout());
        guiFrame.getContentPane().setLayout(new BorderLayout(2,2));

        JLabel label = new JLabel(); // Create a new label object
		label.setText("Hello World (again)!"); // Set its message to show
		label.setFont(new Font("Ariel", Font.BOLD, 30)); // Set a font for the label


        // for (int i = 0; i < 64; i++) // create new object and store rand color in it 
        // {
        //     arrayLables[i] = new ColorLabel();
        //     arrayLables[i].setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        // }

        
        mainPanel.setLayout(new FlowLayout());
        gridPanel.setLayout(new GridLayout(8,8));

        guiFrame.getContentPane().add( new ColorLabel( 1, 1, Color.RED, 2, Color.GRAY ), BorderLayout.NORTH );
		guiFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		guiFrame.getContentPane().add(button1, BorderLayout.SOUTH);
        guiFrame.getContentPane().add( new ColorLabel( 1, 1, Color.BLUE, 2, Color.GRAY ), BorderLayout.WEST );
		guiFrame.getContentPane().add( new ColorLabel( 1, 1, Color.BLUE, 2, Color.GRAY ), BorderLayout.EAST );
        

        mainPanel.add(gridPanel);


        //Add 25 panels
		for ( int i = 0 ; i < 64 ; i++ )
		{
            //JPanel gridPanel = new JPanel();
            //ColorLabel randColor = new ColorLabel(50, 50, new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            arrayLables[i] = new ColorLabel(50, 50, new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            gridPanel.add(arrayLables[i]);
		}
        
        button1.addActionListener(this);
        
        guiFrame.pack(); // Resize frame to fit content
        guiFrame.setVisible(true);
    }

    public static void main(String[] args)
    {
        Main run  = new Main();
        run.createGUI();
        
    }   

    @Override
	public void actionPerformed(ActionEvent e)
	{
		//label.setText(label.getText()+".");
	    button1.setBackground( new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        for ( int i = 0 ; i < 64 ; i++ )
		{
            arrayLables[i].setDrawColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            //gridPanel.add(arrayLables[i]);
        }
        gridPanel.repaint();


		guiFrame.pack();
	}
}
