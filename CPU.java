import java.util.Random;
import java.util.Scanner;

public class CPU extends Player
{
    public CPU()
    {

    }
    public CPU(int playernum)
    {
        super(playernum);
    }
    public int takeTurn(Board grid)
    {
        if(canWin(grid) == -1)
        {
            Random randomnum = new Random();
            int s = randomnum.nextInt(9) + 1;
            return s;
        }
            return canWin(grid) + 1;
    }
    public int canWin(Board grid)
    {
        return super.canWin(grid);
    }
    public int getNumber()
    {
        return super.getNumber();
    }

}