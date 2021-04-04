package lec8;

import java.awt.Color;
import java.awt.FlowLayout; // Remember ctrl-shift-o in Eclipse to generate these
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlowLayoutExample
{
	public static void main(String[] args)
	{
		new FlowLayoutExample();
	}
	
	public FlowLayoutExample()
	{
		JFrame guiFrame = new JFrame();
		guiFrame.setTitle("Hello World!");

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		panel1.setLayout( new FlowLayout() );
		panel1.add(panel2);
		panel2.setLayout( new FlowLayout() );
		panel1.add(panel3);
		panel3.setLayout( new FlowLayout() );

		guiFrame.getContentPane().setLayout(new FlowLayout());
		guiFrame.getContentPane().add(panel1); 
		guiFrame.getContentPane().add(
				new ColorLabel(100, 50, Color.ORANGE, 10, Color.BLACK));
		guiFrame.getContentPane().add(
				new ColorLabel(100, 50, Color.YELLOW, 10, Color.BLACK));
		
		panel1.add( new ColorLabel(100, 50, Color.BLUE, 10, Color.BLACK));
		panel2.add( new ColorLabel(100, 50, Color.GREEN, 10, Color.BLACK));
		panel3.add( new ColorLabel(100, 50, Color.RED, 10, Color.BLACK));

		guiFrame.pack(); // Resize frame to fit content
		guiFrame.setLocationRelativeTo(null);
		guiFrame.setVisible(true);
	}
}

