package buttons;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class buttontestrun implements ActionListener
{ 
	JFrame guiFrame = new JFrame(); // Create a new frame object � top level window
	JLabel label = new JLabel(); // Create a new label object
	JLabel label1 = new JLabel(); // Create a new label object
	JLabel label2 = new JLabel(); // Create a new label object
	JButton button1 = new JButton("Press Me");
    JPanel mainPanel = new JPanel();
    JPanel gridPanel = new JPanel();
	
	public buttontestrun()
	{
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close window exits
		guiFrame.setTitle("Click the Button Game!"); // Set a caption/title bar content for the frame
		guiFrame.setLocationRelativeTo(null); // centre on screen
		guiFrame.getContentPane().setLayout(new BorderLayout());

        guiFrame.getContentPane().add(gridPanel, BorderLayout.CENTER);
        guiFrame.getContentPane().add(button1, BorderLayout.SOUTH);

        gridPanel.setLayout(new GridLayout(8,8));

        for(int i = 1; i <= 64; i++)
        {
            JButton gridbutton = new JButton(".");
            gridbutton.setBackground(Color.green);
            gridPanel.add(gridbutton);
        }

		label.setText("Press Any Box to Do Nothing!"); // Set its message to show
		label.setFont(new Font("Ariel", Font.BOLD, 30)); // Set a font for the label
		
        guiFrame.getContentPane().add(label, BorderLayout.NORTH); // Add the label to the frame, so that it will show

		//guiFrame.getContentPane().add(button1);
		button1.addActionListener(this);
		
		guiFrame.pack(); // Resize frame to fit content
		guiFrame.setVisible(true); // Display it � until you do it will not appear
	}

	public static void main(String[] args)
	{
		new buttontestrun();
	}

	Random rand = new Random();

	@Override
	public void actionPerformed(ActionEvent e)
	{
		label.setText(label.getText()+".");
		button1.setBackground( new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));

		guiFrame.pack();
	}
}

