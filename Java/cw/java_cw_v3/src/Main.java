import java.awt.Color;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener
{
    JFrame guiFrame = new JFrame(); // create a jFrame object
    JPanel mainPanel = new JPanel();
    JPanel gridPanel = new JPanel();
    Random rand = new Random();
    JButton button1 = new JButton("Press");
    JLabel turnLabel = new JLabel("White goes first");

    int flag = 1; // start from white
     int white = 1 , black = 0;

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


        mainPanel.add(gridPanel);        
        
        for(int i = 0; i< 64; i++)
        {
            Boolean changes = true;
            //(28 37) (29 36) 
            if(i == 28 || i == 35)
            {
                MakeAMove moves = new MakeAMove(changes);
                moves.setBackground(Color.BLACK);
                moves.setPreferredSize(new Dimension(60, 60));
                gridPanel.add(moves);
            }
            else if(i == 27 || i == 36)
            {
                MakeAMove moves = new MakeAMove(changes);
                moves.setBackground(Color.WHITE);
                moves.setPreferredSize(new Dimension(60, 60));
                gridPanel.add(moves);
            }
            else 
            {
                MakeAMove moves = new MakeAMove();
                moves.setBackground(Color.GREEN);
                moves.setPreferredSize(new Dimension(60, 60));
                gridPanel.add(moves);
            }
            
        }

        
        button1.addActionListener(this);
        guiFrame.repaint();
        guiFrame.pack(); // Resize frame to fit content
        guiFrame.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        Main run  = new Main();
        run.createGUI();
    }   

    public class MakeAMove extends JButton implements ActionListener 
    {
        Color drawColor;
        boolean first_time = true;
        public void change_state(){
            if(flag == white) flag = black;
            else flag = white;
        }
        public MakeAMove()
        {
            addActionListener(this);
        }
        public MakeAMove(Boolean garbage)
        {
            addActionListener(this);
            first_time = false;
        }
        public void changeColor()
        {
            if (first_time)
            {
                if(flag == white)
                {
                    setBackground(Color.BLACK);
                    turnLabel.setText("White Turn");
                    if (first_time)first_time = false;
                }
                else 
                {
                    setBackground(Color.WHITE);
                    turnLabel.setText("Black Turn");
                    if (first_time)first_time = false;
                }
            }
            else
            {
                change_state();
            }
        }
        public void actionPerformed(ActionEvent e)
        {
            change_state();
            changeColor();

            
        }
    }


    @Override
	public void actionPerformed(ActionEvent e)
	{
		//label.setText(label.getText()+".");
	    button1.setBackground( new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        gridPanel.repaint();
        
	}
}