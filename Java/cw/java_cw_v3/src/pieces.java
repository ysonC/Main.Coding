import javax.swing.JButton;
import javax.swing.event.AncestorEvent;
import java.awt.event.*;
import java.awt.Color;

public class pieces extends JButton implements ActionListener
{

    Color drawColor;
    boolean first_time = true;
    

    public void change_state()
    {
        if(flag == white) flag = black;
        else flag = white;
    }

    public pieces() 
    {
        addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) 
    {

    }

}
