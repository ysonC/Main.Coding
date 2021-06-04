import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.Font;

public class Pieces extends JLabel implements ActionListener 
{
    static int row;
    static int col;
    int red = 0;
    int blue = 1;
    int color; 
    String string = "";
    Pieces(int inColor, int inRow, int inCol)
    {
        color = inColor;
        row = inRow;
        col = inCol;
        setFont(new Font("Ariel", Font.BOLD, 40));
        if (inColor < 9)
        {
            setText(String.valueOf(inColor));
        }
        else if (inColor == 9) 
        {
            setText("B");
            setBorder(BorderFactory.createLineBorder(Color.black, 2));
        }
        else if (inColor == 10) 
        {
            setText("R");
            setBorder(BorderFactory.createLineBorder(Color.black, 2));
        }
        else
        {
            setText(" ");
            setBorder(BorderFactory.createLineBorder(Color.black, 2));
        }
    }
    Pieces(String s, int inRow, int inCol)
    {
        setFont(new Font("Ariel", Font.BOLD, 40));
        setText(s);
    }
    int getPlayer()
    {
        return color;
    }
    void setPlayer(int setC)
    {
        color = setC;
    }
    static void getPieces(int inRow, int inCol)
    {
        if(inRow == row)System.out.println(row +" , ");
        if(inCol == col)System.out.println(col +" , ");
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Scanner userInput = new Scanner(System.in);
        string = userInput.nextLine();
        userInput.close();
        setText(string);
        repaint();
        
    }

}
