import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
public class MakeAMove extends JButton implements ActionListener 
{
    Color drawColor;
    private int cnt = 0;

    // public MakeAMove()
    // {
    //     addActionListener(new ActionListener(){

    //         public void actionPerformed(ActionEvent e)
    //         {
    //             setBackground(Color.BLUE);
    //             System.out.println("Test123Test");
    //         }});
        
    // }


    public MakeAMove()
    {
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        cnt ++;
        if (cnt % 2 == 0)
        {
            setBackground(Color.BLUE);
        }

        else 
            setBackground(Color.GREEN);

        System.out.println(cnt);
    }
    

    public void setColor(Color drawColor)
    {
        this.drawColor = drawColor;
    }
}
