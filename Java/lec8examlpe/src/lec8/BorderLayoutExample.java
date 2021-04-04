package lec8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutExample
{
	public static void main(String[] args)
	{
		new BorderLayoutExample();
	}
	
	public BorderLayoutExample()
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

		// Added this line
		panel1.setBackground(Color.BLACK);
				
		// This line changed to a grid layout from flowlayout
		guiFrame.getContentPane().setLayout(new BorderLayout());
		guiFrame.getContentPane().add(panel1,BorderLayout.NORTH); 
		guiFrame.getContentPane().add( new ColorLabel(100, 50, Color.ORANGE, 10, Color.BLACK), BorderLayout.CENTER );
		guiFrame.getContentPane().add( new ColorLabel(100, 50, Color.YELLOW, 10, Color.BLACK), BorderLayout.SOUTH);
		guiFrame.getContentPane().add( new ColorLabel(100, 50, Color.WHITE, 10, Color.BLACK), BorderLayout.WEST);
		guiFrame.getContentPane().add( new ColorLabel(100, 50, Color.GRAY, 10, Color.BLACK), BorderLayout.EAST);
				
		panel1.add( new ColorLabel(100, 50, Color.BLUE, 10, Color.BLACK));
		panel2.add( new ColorLabel(100, 50, Color.GREEN, 10, Color.BLACK));
		panel3.add( new ColorLabel(100, 50, Color.RED, 10, Color.BLACK));

		guiFrame.pack(); // Resize frame to fit content
		guiFrame.setLocationRelativeTo(null);
		guiFrame.setVisible(true);

	}
}

