package lec8;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridLayoutExample
{
	public static void main(String[] args)
	{
		new GridLayoutExample();
	}
	
	public GridLayoutExample()
	{
		JFrame guiFrame = new JFrame();
		guiFrame.setTitle("Hello World!");

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel testpanel = new JPanel();

		panel1.setLayout( new FlowLayout() );
		panel1.add(panel2);
		panel2.setLayout( new FlowLayout() );
		panel1.add(panel3);
		panel3.setLayout( new FlowLayout() );
		panel1.add(testpanel);
		testpanel.setLayout( new FlowLayout());

		Random rand = new Random();

		// This line changed to a grid layout from flowlayout
		guiFrame.getContentPane().setLayout(new GridLayout(2,2));
		guiFrame.getContentPane().add(panel1); 
		guiFrame.getContentPane().add(new ColorLabel(100, 50, Color.ORANGE, 10, Color.BLACK));
		guiFrame.getContentPane().add(new ColorLabel(100, 50, Color.rand, 10, Color.BLACK));
		//guiFrame.getContentPane().add(testpanel);
		
		panel1.add( new ColorLabel(100, 50, Color.BLUE, 10, Color.BLACK));
		panel2.add( new ColorLabel(100, 50, Color.GREEN, 10, Color.BLACK));
		panel3.add( new ColorLabel(100, 50, Color.RED, 10, Color.BLACK));
		testpanel.add(new ColorLabel(100, 50, Color.BLACK, 10, Color.RED));

		guiFrame.pack(); // Resize frame to fit content
		guiFrame.setLocationRelativeTo(null);
		guiFrame.setVisible(true);
	}
}

