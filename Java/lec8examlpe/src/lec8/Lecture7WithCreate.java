package lec8;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Lecture7WithCreate
{
	public static void main(String[] args)
	{ // Same main function as before – static
		JFrame guiFrame = new JFrame(); // Create a new frame object – top level window
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close window exits
		guiFrame.setTitle("Hello World!"); // Set a caption/title bar content for the frame
		guiFrame.setLocationRelativeTo(null); // centre on screen
		guiFrame.getContentPane().setLayout(new FlowLayout());
		guiFrame.getContentPane().add(create()); // Add the label to the frame, so that it will show
		guiFrame.getContentPane().add(create()); // Add the label to the frame, so that it will show
		guiFrame.getContentPane().add(create()); // Add the label to the frame, so that it will show
		guiFrame.pack(); // Resize frame to fit content
		guiFrame.setVisible(true); // Display it – until you do it will not appear
	}
	
	static int count = 0;
	
	static JLabel create()	
	{
		JLabel label = new JLabel("Hello World " + count++);
		label.setFont(new Font("Ariel", Font.BOLD, 80));
		return label;
	}
}
