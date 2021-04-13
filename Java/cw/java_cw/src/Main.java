import java.awt.Color;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener
{
    JFrame guiFrame = new JFrame(); // create a jFrame object
    ColorLabel clickableLables = new ColorLabel(50, 50, Color.green); // ==> not working for now
    ColorLabel greenLabel[] = new ColorLabel[64]; //== > testing
    PlaceaMove panel = new PlaceaMove(); // working
    Random rand = new Random();
    JPanel mainPanel = new JPanel();
    JPanel gridPanel = new JPanel();
    PanelListener listener = new PanelListener();
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
            
            //greenLabel[i] = new ColorLabel(50, 50, Color.GREEN, 1, Color.BLACK);
            //greenLabel[i].addMouseListener(listener);
            //gridPanel.add(greenLabel[i]);

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

    public class PanelListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent event) 
        {
            Object source = event.getSource();
            if(source instanceof JLabel)
            {
                JLabel panelPressed = (JLabel) source;
                panelPressed.setBackground(Color.blue);
            }  
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {}

        @Override
        public void mouseExited(MouseEvent arg0) {}

        @Override
        public void mousePressed(MouseEvent arg0) {}

        @Override
        public void mouseReleased(MouseEvent arg0) {}
        
    }

    @Override
	public void actionPerformed(ActionEvent e)
	{
		//label.setText(label.getText()+".");
	    button1.setBackground( new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        gridPanel.repaint();
	}
}

