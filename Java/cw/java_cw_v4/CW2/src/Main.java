    import java.awt.Color;
import java.util.Random;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.Timer;

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
    int time_s=0;
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
                    //moves[i][j].setBackground(Color.GREEN);
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
        
        Time time = new Time();
    }
    public class Time extends JFrame implements ActionListener 
    {
        
        public Time()
        {
            new Timer(1000,this).start();
            while(true);
        }
     
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            time_s++;
        }
    }

    public class Pieces extends JButton implements ActionListener 
    {
        boolean lock = false;
        Color color;
        int placeAble;
        int row, column;
        
        public Pieces()
        {
            addActionListener(this);
            color = Color.GREEN;
            lock = false;
            placeAble = 0;
        }

        public Pieces(Boolean garbage)
        {
            addActionListener(this);
            lockPiece(true);
            placeAble = 1;
        }

        public void addPlaceAble()
        {
            placeAble++;
        }

        public int getPlaceAble()
        {
            return placeAble;
        }

        public void lockPiece(boolean setLock)
        {
            lock = setLock;
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

        public int getTotalWhite(int totalWhite)
        {
            for (int i = 0; i < 10; i++)
            {       
                for (int j = 0; j < 10; j++)
                {
                    if(moves[i][j].getColor() == Color.WHITE)
                    {
                        totalWhite++;
                    }
                }
            }
            return totalWhite;
        }

        public int getTotalBlack(int totalBlack)
        {
            for (int i = 0; i < 10; i++)
            {       
                for (int j = 0; j < 10; j++)
                {
                    if(moves[i][j].getColor() == Color.BLACK)
                    {
                        totalBlack++;
                    }
                }
            }
            return totalBlack;
        }

        public void packGetTotal()
        {
            int totalWhite = 0, totalBlack = 0;
            
            System.out.println("White : " + getTotalWhite(totalWhite) + " Black : " + getTotalBlack(totalBlack));

            if(getTotalWhite(totalWhite) +  getTotalBlack(totalBlack) == 64)
            {
                if (getTotalWhite(totalWhite) >  getTotalBlack(totalBlack)) 
                {
                    JOptionPane.showMessageDialog(guiFrame, "White wins!!" + "Time : " + time_s);
                }               
                else JOptionPane.showMessageDialog(guiFrame, "Black wins!!"+ "Time : " + time_s);
            }
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
                lockPiece(true);
            }
        }

        public void reverseMove()
        {
            lockPiece(false);
            if(flag == white)
                {
                    setColor(Color.GREEN);
                    turnLabel.setText("Black Turn");
                    flag = black;
                }
            else 
                {
                    setColor(Color.GREEN);
                    turnLabel.setText("White Turn");
                    flag = white;
                }
        }

        /*
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

        */

        public boolean ifPass()
        {
            if(getLock() == false) return true;
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
                    addPlaceAble();
                    //System.out.println("left to right");
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
                    addPlaceAble();
                    //System.out.println("right to left");
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
                    addPlaceAble();
                    //System.out.println("down to up");  
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
                    addPlaceAble();
                    //System.out.println("up to down");   
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
                    addPlaceAble();
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
                    addPlaceAble();
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
                    addPlaceAble();
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
                    addPlaceAble();
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
                combineFind();
                // int[] cross = countCross();
                // //System.out.println("up : " + cross[0] + " down : " + cross[1] + " left : " + cross[2]+" right : " + cross[3]);
                // int[] X = countX();
                // //System.out.println("downLeft : " + X[0] + " downRight : " + X[1] + " upLeft : " + X[2]+" upRight : " + X[3]);
                // System.out.println(X[2] +" "+ cross[0]+" " + X[3]);
                // System.out.println(cross[2] +" "+ " " +" "+ cross[3]);
                // System.out.println(X[0] +" "+ cross[1] +" "+ X[1]);
                
                if(getPlaceAble() == 0) reverseMove();
            }
            
            System.out.println("array : " + getArray() 
            + " lock : " + getLock() + " placeAble : " + getPlaceAble());
            System.out.println("flag = " + flag);
            packGetTotal();
            System.out.println("------------------------------");
        }
        
        public int[] countCross()
        {
            Color tmp = null;
            Color tmp2 = null;
            if (flag == white) tmp = Color.BLACK;
            else tmp2 = Color.WHITE;
            int[] ans = new int[4];
            int upCnt = 0;
            
            int final_up =0;         
            int final_down = 0;
            int final_left = 0;
            int final_right = 0;   
            
            int i = 1;
            while(moves[row-i][column].getColor() == tmp)
            {   
                System.out.println("up is here");
                if(moves[row-i][column].getColor() == Color.GREEN) 
                {
                    upCnt = 0;
                    break;
                }
                else if (moves[row-i][column].getColor() == tmp2)
                {
                    final_up = upCnt;
                    break;
                }
                upCnt++;
                i++;
            }
            upCnt--;
            if(upCnt < 0) upCnt = 0;
    
            i = 1;
            int downCnt = 0;
            while(moves[row+i][column].getColor() == tmp)
            {
                if(moves[row+i][column].getColor() == Color.GREEN) 
                {
                    downCnt = 0;
                    break;
                }
                else if (moves[row+i][column].getColor() == tmp2)
                {
                    final_down = downCnt;
                    break;
                }
                downCnt++;
                i++;
            }
            downCnt--;
            if(downCnt < 0) downCnt = 0;

            i = 1;
            int leftCnt = 0;
            while(moves[row][column-i].getColor() == tmp)
            {
                if(moves[row][column-i].getColor() == Color.GREEN) 
                {
                    leftCnt = 0;
                    break;
                }
                else if (moves[row][column-i].getColor() == tmp2)
                {
                    final_left = leftCnt;
                    break;
                }
                leftCnt++;
                i++;
            }
            leftCnt--;
            if(leftCnt < 0) leftCnt = 0;

            i = 1;
            int rightCnt = 0;
            while(moves[row][column+i].getColor() == tmp)
            {
                if(moves[row][column+i].getColor() == Color.GREEN) 
                {
                    rightCnt = 0;
                    break;
                }
                else if (moves[row][column+i].getColor() == tmp2)
                {
                    final_right = rightCnt;
                    break;
                }
                rightCnt++;
                i++;
            }
            rightCnt--;
            if(rightCnt < 0) rightCnt = 0;


            ans[0] = final_up;
            ans[1] = final_down;
            ans[2] = final_left;
            ans[3] = final_right;
            return ans;
        }


        public int[] countX()
        {
            int i = 1;
            Color tmp = null;
            if (flag == white) tmp = Color.BLACK;
            else tmp = Color.WHITE;
            int[] ans = new int[4];
            int downLeftCnt = 0;
            int downRightCnt = 0;
            int upLeftCnt = 0;
            int upRightCnt = 0;
            
            int final_dLC = 0;
            int final_dRC = 0;
            int final_uLC = 0;
            int final_uRC = 0;
            

            while(moves[row+i][column-i].getColor() == tmp)
            {
                if(moves[row+i][column-i].getColor() == Color.GREEN) 
                {
                    downLeftCnt = 0;
                    break;
                }
                else if (moves[row+i][column-i].getColor() == getColor())
                {
                    final_dLC = downLeftCnt;
                    break;
                }
                    
                downLeftCnt++;
                i++;
            }
            downLeftCnt--;
            if(downLeftCnt < 0) downLeftCnt = 0;

            i = 1;
            while(moves[row+i][column+i].getColor() == tmp)
            {
                if(moves[row+i][column+i].getColor() == Color.GREEN) 
                {
                    downRightCnt = 0;
                    break;
                }
                else if (moves[row+i][column+i].getColor() == getColor())
                {
                    final_dRC = downRightCnt;
                    break;
                }
                downRightCnt++;
                i++;
            }
            downRightCnt--;

            if(downRightCnt < 0) downRightCnt = 0;

            i = 1;
            while(moves[row-i][column-i].getColor() == tmp)
            {
                if(moves[row-i][column-i].getColor() == Color.GREEN) 
                {
                    upLeftCnt = 0;
                    break;
                }
                else if (moves[row-i][column-i].getColor() == getColor())
                {
                    final_uLC = upLeftCnt;
                    break;
                }
                upLeftCnt++;
                i++;
            }
            upLeftCnt--;
            if(upLeftCnt < 0) upLeftCnt = 0;

            i = 1;
            while(moves[row-i][column+i].getColor() == tmp)
            {
                if(moves[row-i][column+i].getColor() == Color.GREEN) 
                {
                    upRightCnt = 0;
                    break;
                }
                else if (moves[row+i][column-i].getColor() == getColor())
                {
                    final_uRC = upRightCnt;
                    break;
                }
                upRightCnt++;
                i++;
            }
            upRightCnt--;
            if(upRightCnt < 0) upRightCnt = 0;
            
            ans[0] = final_dLC;
            ans[1] = final_dRC;
            ans[2] = final_uLC;
            ans[3] = final_uRC;
            return ans;
        }

        public int[] calcBestMove()
        {
            int[] bestArray = new int[2];
            int bestRow = 1, bestColumn = 1;
            int i = 100;
            int compareA = 0;
            int compareB = 0;

            int rRow = rand.nextInt(8)+1;
            int rColumn = rand.nextInt(8)+1;
            while(i>0)
            {
                while(moves[rRow][rColumn].ifPass() == false && moves[rRow][rColumn].getPlaceAble() > 0)
                {
                    rRow = rand.nextInt(8)+1;
                    rColumn = rand.nextInt(8)+1;
                }
                //System.out.println(rRow + " ||" + rColumn);
                int[] crossTmp = moves[rRow][rColumn].countCross();
                int[] XTmp = moves[rRow][rColumn].countX();
                compareA = crossTmp[0] + crossTmp[1] + crossTmp[2] + crossTmp[3] + XTmp[0] + XTmp[1] + XTmp[2] + XTmp[3];
                if (compareA > compareB)
                {
                    bestRow = rRow;
                    bestColumn = rColumn;
                    compareB = compareA;
                    //System.out.println("BEST : " + bestRow + " , " + bestColumn);
                }
                else
                {
                    rRow = rand.nextInt(8)+1;
                    rColumn = rand.nextInt(8)+1;
                }
                i--;
            }
            System.out.println(compareB);
            System.out.println("!!!!" + bestRow + " , " + bestColumn);
            bestArray[0] = bestRow;
            bestArray[1] = bestColumn;
            return bestArray;
        }
        
    }

    @Override
	public void actionPerformed(ActionEvent e)
	{
        boolean pass = false;
        int i = rand.nextInt(8)+1;
        int j = rand.nextInt(8)+1;
        
        while(pass==false)
        {
            if (moves[i][j].ifPass())
            {
                moves[i][j].makeMove();
                moves[i][j].combineFind();
                if(moves[i][j].getPlaceAble() == 0)
                {
                    moves[i][j].reverseMove();
                    i = rand.nextInt(7)+1;
                    j = rand.nextInt(7)+1;
                    pass = false;
                }
                else
                {
                    pass = true;
                    System.out.println(moves[i][j].getArray());
                }
            }
            else
            {
                i = rand.nextInt(8)+1;
                j = rand.nextInt(8)+1;
            } 
        }
        moves[0][0].packGetTotal();
	}

    public static void main(String[] args)
    {
        Main run  = new Main();
        run.createGUI();
    }  
}