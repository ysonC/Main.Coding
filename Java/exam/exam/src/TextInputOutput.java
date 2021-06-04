
public class TextInputOutput 
{
    char colFrom, rowFrom, colTo, rowTo;
    TextInputOutput()
    {

    }   
    void show(int rows, int cols)
    {
        
    } 
    void lineRead(String s)
    {
        colFrom = convertABC(s.charAt(0));
        rowFrom = s.charAt(1);
        colTo = convertABC(s.charAt(3));
        rowTo = s.charAt(4);
        //System.out.println(colFrom + " " +  rowFrom + " " + colTo + " " + rowTo);
        System.out.println(validateMove(App.changeTurns,colFrom, rowFrom, colTo, rowTo));
        if (validateMove(App.changeTurns,colFrom, rowFrom, colTo, rowTo))
            makeMove(colFrom, rowFrom, colTo, rowTo);
        else App.changeTurns--;
    }
    void outputString(String str)
    {

    }
    char convertABC(char in)
    {
        char number = 0;
        switch(in)
        {
            case 'A': 
                number = '1';
                break;
            case 'B': 
                number = '2';
                break;
            case 'C': 
                number = '3';
                break;
            case 'D': 
                number = '4';
                break;
            case 'F': 
                number = '5';
                break;
            case 'G': 
                number = '6';
                break;
            case 'H': 
                number = '7';
                break;
            default: number = '0';
        }
        return number;
    }
    void makeMove(char colFrom, char rowFrom, char colTo, char rowTo)
    {
        int cF = colFrom - 48;
        int rF = rowFrom - 48;
        int cT = colTo - 48;
        int rT = rowTo - 48;
        String setColor="";
        int setPlayer=0;
        App.moves[rF][cF].setText(" ");
        if (App.moves[rF][cF].getPlayer() == 9) 
        {
            setColor = "B";
            setPlayer = 9;
        }
        else if (App.moves[rF][cF].getPlayer() == 10) 
        {
            setColor = "R";
            setPlayer = 10;
        }
        App.moves[rF][cF].setPlayer(11);//blank
        App.moves[rT][cT].setText(setColor);
        App.moves[rT][cT].setPlayer(setPlayer);
        

    }
    Boolean validateMove(int player, char colFrom, char rowFrom, char colTo, char rowTo)
    {
        int cF = colFrom - 48;
        int rF = rowFrom - 48;
        int cT = colTo - 48;
        int rT = rowTo - 48;
        int whosTurn = 0;//player 1
        int found = 0;
        if(player%2 == 0) whosTurn = 1; //player 2 
        if (App.moves[rF][cF].getPlayer() == 9 && whosTurn == 1) return false; 
        if (App.moves[rF][cF].getPlayer() == 10 && whosTurn == 0) return false;
        if (App.moves[rF][cF].getPlayer() == 9 && whosTurn == 1) return false; 
        if (App.moves[rF][cF].getPlayer() == 11) return false; 
        if (App.moves[rT][cT].getPlayer() != 11) return false;

        if(cF == cT || rF == rT)// same row same column
            found++;
        for(int i= 0; i<9; i++)// checl diagonal
        {
            if(cF == cT+i) found++;
            if(cF == cT-i) found++;
            if(rF == rT+i) found++;
            if(rF == rT-i) found++;
        }
        if (found == 0) return false;
        return true;
    }
}
