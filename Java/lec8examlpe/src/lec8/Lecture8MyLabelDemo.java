package lec8;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Lecture8MyLabelDemo
{
	public static void main(String[] args)
	{ // Same main function as before – static
		JFrame guiFrame = new JFrame(); // Create a new frame object – top level window
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close window exits
		guiFrame.setTitle("Hello World!"); // Set a caption/title bar content for the frame
		guiFrame.setLocationRelativeTo(null); // centre on screen
		guiFrame.getContentPane().setLayout(new FlowLayout());
		guiFrame.getContentPane().add(new MyLabel1()); // Add the label to the frame, so that it will show
		guiFrame.getContentPane().add(new MyLabel2("Test")); // Add the label to the frame, so that it will show
		guiFrame.getContentPane().add(new MyLabel3()); // Add the label to the frame, so that it will show
		guiFrame.getContentPane().add(new MyLabel4()); // Add the label to the frame, so that it will show
		guiFrame.pack(); // Resize frame to fit content
		guiFrame.setVisible(true); // Display it – until you do it will not appear
	}
}
