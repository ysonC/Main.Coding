
import java.awt.*;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App extends JFrame
{
    
    static String input = "";
    static int changeTurns = 0;
    static Pieces moves[][] = new Pieces[100][100];
    App()
    {
        
    }
    
    public static void main(String[] args) 
    {
        JFrame guiFrame = new JFrame(); // create a jFrame object
        JPanel mainPanel = new JPanel();
        JPanel gridPanel = new JPanel();
        JLabel turnLabel = new JLabel("Blue goes first");
        JLabel display = new JLabel();
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close window exits
        guiFrame.setTitle(input);
        guiFrame.setLocationRelativeTo(null); // centre on screen
        guiFrame.getContentPane().setLayout(new FlowLayout());
        guiFrame.getContentPane().setLayout(new BorderLayout(2,2));

        turnLabel.setFont(new Font("Ariel", Font.BOLD, 20));
        display.setFont(new Font("Ariel", Font.BOLD, 40));
    
        mainPanel.setLayout(new FlowLayout());
        gridPanel.setLayout(new GridLayout(9,9));

        guiFrame.getContentPane().add(turnLabel, BorderLayout.NORTH );
		guiFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        guiFrame.getContentPane().add(display, BorderLayout.SOUTH);
        
        mainPanel.add(gridPanel);

    
        for(int i = 0; i<9; i++ )
        {
            if(i == 0)
                {
                    moves[i][0] = new Pieces("",i,0);
                    moves[i][1] = new Pieces("A",i,1);
                    moves[i][2] = new Pieces("B",i,2);
                    moves[i][3] = new Pieces("C",i,3);
                    moves[i][4] = new Pieces("D",i,4);
                    moves[i][5] = new Pieces("E",i,5);
                    moves[i][6] = new Pieces("F",i,6);
                    moves[i][7] = new Pieces("G",i,7);
                    moves[i][8] = new Pieces("H",i,8);
                    for(int z = 0; z <9; z++) gridPanel.add(moves[i][z]);
                    i++;
                    
                }
            for (int j = 0; j < 9; j++)
            {
                if(j == 0)
                {
                    moves[i][j] = new Pieces(i,i,0);
                    gridPanel.add(moves[i][j]);
                }
                else if (i == 1 || i == 2) //blue
                {
                    moves[i][j] = new Pieces(9,i,j);
                    gridPanel.add(moves[i][j]);
                }
                else if (i == 7 || i == 8) //red
                {
                    moves[i][j] = new Pieces(10,i,j);
                    gridPanel.add(moves[i][j]);
                }
                else
                {
                    moves[i][j] = new Pieces(11,i,j); //blank
                    gridPanel.add(moves[i][j]);
                }
            }
        }
        

        guiFrame.repaint();
    
        guiFrame.pack(); // Resize frame to fit content
        guiFrame.setVisible(true);
        Scanner in = new Scanner(System.in);
		while(in.hasNextLine()) 
        {
            changeTurns++;
			String s = in.next();
            display.setText(s);
            TextInputOutput userInput = new TextInputOutput();
            userInput.lineRead(s);
            guiFrame.repaint();
        }


    }

}
