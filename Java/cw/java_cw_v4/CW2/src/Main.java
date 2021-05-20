import java.awt.Color;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener
{
    JFrame guiFrame = new JFrame(); // create a jFrame object
    JPanel mainPanel = new JPanel();
    JPanel gridPanel = new JPanel();
    Random rand = new Random();
    JButton button1 = new JButton("Make a move for me.");
    JLabel turnLabel = new JLabel("White goes first");

    int flag = 1; // start from white
    int white = 1 , black = 0; 
    Pieces moves[][] = new Pieces[100][100];

    public void createGUI()
    {
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close window exits
        guiFrame.setTitle("The Game");
        guiFrame.setLocationRelativeTo(null); // centre on screen
        guiFrame.getContentPane().setLayout(new FlowLayout());
        guiFrame.getContentPane().setLayout(new BorderLayout(2,2));

        turnLabel.setFont(new Font("Ariel", Font.BOLD, 20));
    
        mainPanel.setLayout(new FlowLayout());
        gridPanel.setLayout(new GridLayout(8,8));

        guiFrame.getContentPane().add(turnLabel, BorderLayout.NORTH );
		guiFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		guiFrame.getContentPane().add(button1, BorderLayout.SOUTH);


        mainPanel.add(gridPanel);        
        
        Boolean starter = true;
        for (int i = 0; i < 10; i++)
        {       
            for (int j = 0; j < 10; j++)
            {
                if (i == 0 || i == 9 || j == 9 || j == 0)
                {
                    moves[i][j] = new Pieces();
                    moves[i][j].setColor(Color.GREEN);
                    moves[i][j].setPreferredSize(new Dimension(60,60));
                    moves[i][j].storeArray(i, j);
                }

                else if ((i == 4 && j == 4) || (i == 5 && j == 5))
                {
                    moves[i][j] = new Pieces(starter);
                    moves[i][j].setColor(Color.WHITE);
                    moves[i][j].setPreferredSize(new Dimension(60,60));
                    moves[i][j].storeArray(i, j);
                    gridPanel.add(moves[i][j]);
                }
                else if ((i == 4 && j == 5) || (i == 5 && j == 4))
                {
                    moves[i][j] = new Pieces(starter);
                    moves[i][j].setColor(Color.BLACK);
                    moves[i][j].setPreferredSize(new Dimension(60,60));
                    moves[i][j].storeArray(i, j);
                    gridPanel.add(moves[i][j]);
                }
                else
                {
                    moves[i][j] = new Pieces();
                    moves[i][j].setColor(Color.GREEN);
                    moves[i][j].setBackground(Color.GREEN);
                    moves[i][j].setPreferredSize(new Dimension(60,60));
                    moves[i][j].storeArray(i, j);
                    gridPanel.add(moves[i][j]);
                }
            }
        }
        
        button1.addActionListener(this);
        guiFrame.repaint();
        guiFrame.pack(); // Resize frame to fit content
        guiFrame.setVisible(true);
    }
    
 

    public class Pieces extends JButton implements ActionListener 
    {
        boolean lock = false;
        Color color;
        int row, column;
        
        public Pieces()
        {
            addActionListener(this);
            color = Color.GREEN;
            lock = false;
        }

        public Pieces(Boolean garbage)
        {
            addActionListener(this);
            lockPiece();
        }

        public void lockPiece()
        {
            lock = true;
        }
        public boolean getLock()
        {
            return lock;
        }

        public void storeArray(int setRow, int setColumn)
        {
            row = setRow;
            column = setColumn;
        }

        public String getArray()
        {
            String tmp = (row + ", " + column);
            return tmp;
        }

        public void setColor(Color setTo)
        {
            color = setTo;
            setBackground(setTo);
        }

        public Color getColor()
        {
            return color;
        }


        public void makeMove()
        {
            if(getLock() == false)
            {
                if(flag == white)
                {
                    setColor(Color.WHITE);
                    turnLabel.setText("Black Turn");
                    flag = black;
                }
                else 
                {
                    setColor(Color.BLACK);
                    turnLabel.setText("White Turn");
                    flag = white;
                }
                lockPiece();
            }
        }

        public boolean besideOne()
        {
            int cnt =0;
            if (moves[row][column+1].getColor() == Color.GREEN)
                cnt++;
            if (moves[row][column-1].getColor() == Color.GREEN)
                cnt++;
            if (moves[row+1][column].getColor() == Color.GREEN)
                cnt++;
            if (moves[row-1][column].getColor() == Color.GREEN)
                cnt++;

           
            if (moves[row+1][column+1].getColor() == Color.GREEN)
                cnt++;
            if (moves[row+1][column-1].getColor() == Color.GREEN)
                cnt++;
            if (moves[row-1][column+1].getColor() == Color.GREEN)
                cnt++;
            if (moves[row-1][column-1].getColor() == Color.GREEN)
                cnt++;
            

            //System.out.println("cnt = " + cnt);
            if (cnt < 8 )return true;
            else return false;
        }

        public boolean moveAble(Color tmp)
        {
            int noSame = 0;

            if(tmp == moves[row][column+1].getColor())
                noSame++;
            if (tmp == moves[row][column-1].getColor())
                noSame++;
            if (tmp == moves[row+1][column].getColor())
                noSame++;
            if (tmp == moves[row-1][column].getColor())
                noSame++;

            if (noSame > 0) return false; 

            else return true;
        }

        public boolean ifPass()
        {
            Color tmp = null;
            if (flag == white) tmp = Color.WHITE;
            else if (flag == black) tmp = Color.BLACK;

            if(moveAble(tmp) && besideOne() && getLock() == false) return true;

            else return false;
        }

        public void findSameColor1()
        {
            if(moves[row][column+1].getColor() == moves[row][column].getColor()) return;
            for(int i = column+1; i < 9; i++) // horizontal(left to right)
            {   
                if(moves[row][i].getColor() == Color.GREEN) return;
                if(moves[row][i].getColor() == this.getColor())
                {
                    moves[row][i-1].setColor(this.getColor());
                    System.out.println("left to right");
                    findSameColor1();
                }
            }

        }
        public void findSameColor2()
        {
            if(moves[row][column-1].getColor() == moves[row][column].getColor()) return;
            for(int i = column-1; i < 9; i--)// horizontal (right to left)
            {
                if(moves[row][i].getColor() == Color.GREEN) return;
                if(moves[row][i].getColor() == this.getColor())
                {
                    moves[row][i+1].setColor(this.getColor());
                    System.out.println(i);
                    System.out.println("right to left");
                    findSameColor2();
                }   
            }
        }
    
        public void findSameColor3()
        {
            if(moves[row-1][column].getColor() == moves[row][column].getColor()) return;
            for(int i = row-1; i < 9; i--)// vertical(down to up)
            {
                if(moves[i][column].getColor() == Color.GREEN) return;
                if(moves[i][column].getColor() == this.getColor())
                {
                    moves[i+1][column].setColor(this.getColor());
                    System.out.println("down to up");  
                    findSameColor3(); 
                }
            }

        }

        public void findSameColor4()
        {
            if(moves[row+1][column].getColor() == moves[row][column].getColor()) return;
            for(int i = row+1; i <9; i++)// vertical(up to down)
            {
                if(moves[i][column].getColor() == Color.GREEN) return;
                if(moves[i][column].getColor() == this.getColor())
                {
                    moves[i-1][column].setColor(this.getColor());
                    System.out.println("up to down");   
                    findSameColor4();
                }
            }
        }

        public void findSameColorHorizontal()
        {
            findSameColor1();
            findSameColor2();
            findSameColor3();
            findSameColor4();
        }

        public void findSameColorD1()//down left
        {
            if(moves[row+1][column-1].getColor() == moves[row][column].getColor()) return;
            for(int i = row+1, j = column-1; i < 9 ; i++,j-- )//down left
            {
                if(moves[i][j].getColor() == Color.GREEN) return;
                if(moves[i][j].getColor() == this.getColor())
                {
                    moves[i-1][j+1].setColor(this.getColor());
                    //System.out.println("i : " + i + " j : " + j);
                    findSameColorD1();
                }
            }
            return;
        }

        public void findSameColorD2()//up left
        {
            if(moves[row-1][column+1].getColor() == moves[row][column].getColor()) return;
            for(int i = row-1, j = column+1; i < 9 ; i--,j++ )//down left
            {
                if(moves[i][j].getColor() == Color.GREEN) return;
                if(moves[i][j].getColor() == this.getColor())
                {
                    moves[i+1][j-1].setColor(this.getColor());
                    //System.out.println("i : " + i + " j : " + j);
                    findSameColorD2();
                }
            }
            return;
        }

        public void findSameColorD3()//down right
        {
            if(moves[row+1][column+1].getColor() == moves[row][column].getColor()) return;
            for(int i = row+1, j = column+1; i < 9 ; i++,j++ )//down left
            {
                if(moves[i][j].getColor() == Color.GREEN) return;
                if(moves[i][j].getColor() == this.getColor())
                {
                    moves[i-1][j-1].setColor(this.getColor());
                    //System.out.println("i : " + i + " j : " + j);
                    findSameColorD3();
                }
            }
            return;
        }

        public void findSameColorD4()//up left
        {
            if(moves[row-1][column-1].getColor() == moves[row][column].getColor()) return;
            for(int i = row-1, j = column-1; i < 9 ; i--,j-- )//down left
            {
                if(moves[i][j].getColor() == Color.GREEN) return;
                if(moves[i][j].getColor() == this.getColor())
                {
                    moves[i+1][j+1].setColor(this.getColor());
                    //System.out.println("i : " + i + " j : " + j);
                    findSameColorD4();
                }
            }
            return;
        }

        public void findSameColorDiagonal()
        {
            findSameColorD1();  
            findSameColorD2();
            findSameColorD3();
            findSameColorD4();
        }

        public void combineFind()
        {
            findSameColorHorizontal();
            findSameColorDiagonal();
        }

        public void actionPerformed(ActionEvent e)
        {
            if (ifPass()) 
            {
                makeMove();
                //findSameColorHorizontal();   
                //findSameColorDiagonal();
                combineFind();
            }
            System.out.println("current color : " + this.getColor() + " array : " + getArray() + " lock : " + getLock());
        }

    }

    @Override
	public void actionPerformed(ActionEvent e)
	{
        boolean pass = false;
        int i = rand.nextInt(7)+ 1;
        int j = rand.nextInt(7)+1;
        
        while(pass==false)
        {
            if(moves[i][j].ifPass() == false)
            {
                //moves[i][j].makeMove();
                i = rand.nextInt(7)+1;
                j = rand.nextInt(7)+1;
            }
            else if (moves[i][j].ifPass())
            {
                moves[i][j].makeMove();
                moves[i][j].findSameColor();;
                System.out.println(moves[i][j].getArray());
                pass = true;
            } 
        }
	}

    public static void main(String[] args)
    {
        Main run  = new Main();
        run.createGUI();
    }  
}