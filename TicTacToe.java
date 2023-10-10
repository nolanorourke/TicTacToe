import java.lang.String;
import java.lang.StringBuilder; // for gameboard
import java.util.Random;    //random number generator
import java.util.Scanner;   //for keyboard input
import java.lang.Integer;   //converting string to integer, parse int function

public class TicTacToe
{    
    public static void main (String args[])
    {
        Game match;
        // Scanner input = new Scanner(System.in);
        //need to check if its empty first, otherwise will go "out of bounds"
        if(args.length == 0)    //two human players
        {
            match = new Game();
        }
        else if (args.length == 1 && args[0].equals("-c"))
        {
            match = new Game('c');
        }
        else if(args[0].equals("-c"))   
        {
            //need to check if its empty here first as well in args[1]
            if(args[1].equals("1"))         // human player is 2, player 1 is a computer
            {
                 match = new Game('c', 1);
            }
            else  // human player is 1, player 2 is a computer
            {
                 match = new Game('c', 2);
            }
        }
        else
        {
            System.out.printf("Usage:  java TicTacToe [-c [1 | 2]]");
            match = new Game();
            System.exit(0);
        }
        
        int playernum = 0;
        int input;
        do
        {
            match.gameBoard.display();
            if(playernum > 1)
                playernum = 0;
            System.out.printf("Player %d's turn\n", playernum+1);

            // System.out.print(match.getPlayer());
            // System.out.println("'s turn");
            do
            {
                input = match.players[playernum].takeTurn(match.gameBoard);

            }while(!match.isEmpty(input));

            match.placeMove(input, playernum);
            playernum++;

        }while(!match.ended() && match.win() == 0);

        match.gameBoard.display();
        match.whoWon();

    }//main
        

    // while()
    // {
    //     p1[i].takeTurn();
    //     i = (i + 1) % 2;
    // }

}




//hint for advanced logic 
// if i go middle, computer should not go one of the sides, shoudl go one of the corners
// should never lose, draw or win