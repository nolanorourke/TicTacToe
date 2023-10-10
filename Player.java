import java.util.Random;
import java.util.Scanner;

public abstract class Player
{
    protected int number;
    protected char mark;
    public Player()
    {
    }
    public Player(int playernum)
    {
        number = playernum;
        if(playernum == 1)
            mark = 'X';
        else
            mark = 'O';
    }
    public abstract int takeTurn(Board grid);

    public int canWin(Board grid)   //will return the number it can win at
    {
        int number = getNumber();
        for(int i = 0; i < 3; i++) //moevs through the rows
        {
            if (grid.spots[i*3] == number &&  grid.spots[(i*3)+1] == number &&  grid.spots[(i*3)+2] == 0) 
                return ((i*3)+2);
            if (grid.spots[i*3] == number &&  grid.spots[(i*3)+1] == 0 &&  grid.spots[(i*3)+2] == number) 
                return ((i*3)+1);
            if (grid.spots[i*3] == 0 &&  grid.spots[(i*3)+1] == number &&  grid.spots[(i*3)+2] == number) 
                return (i*3);

            if(grid.spots[i] == number && grid.spots[i+3] == number &&  grid.spots[i+6] == 0) 
                return i + 6;  
            if(grid.spots[i] == number && grid.spots[i+3] == 0 &&  grid.spots[i+6] == number) 
                return i +3;
            if(grid.spots[i] == 0 && grid.spots[i+3] == number &&  grid.spots[i+6] == number) 
                return i;      
        }

        //diagnol top left to bottom right possibility
        if(grid.spots[0] == number && grid.spots[4] == number &&  grid.spots[8] == 0)
            return 8;
        if(grid.spots[0] == number && grid.spots[4] == 0 &&  grid.spots[8] == number)
            return 4;
        if(grid.spots[0] == 0 && grid.spots[4] == number &&  grid.spots[8] == number)
            return 0;

        //diagnol bottom left to top right
        if(grid.spots[6] == number && grid.spots[4] == number &&  grid.spots[2] == 0)
            return 2;
        if(grid.spots[6] == number && grid.spots[4] == 0 &&  grid.spots[2] == number)
            return 4;
        if(grid.spots[6] == 0 && grid.spots[4] == number &&  grid.spots[2] == number)
            return 6;
    
    return -1;
    }
    public int getNumber()
    {
        return number;
    }

}


