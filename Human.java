import java.util.Random;
import java.util.Scanner;
public class Human extends Player
{
    public Human()
    {

    }
    public Human(int playernum)
    {
        super(playernum);
    }
    public int takeTurn(Board grid)
    {
        System.out.println("Enter a move (1-9): ");
        Scanner s = new Scanner(System.in);
        int value = s.nextInt();
        while(value < 1 || value > 9)
        {
            System.out.print("Please enter a value 1-9 that isnt already taken: ");
            value = s.nextInt();
        }
        return value;
    }
    public int getNumber()
    {
        return number;
    }
}