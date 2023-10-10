import java.lang.String;

public class Game
{
    //private boolean [] spots = new int [9];     //initializes empty board
    public Board gameBoard;
    public Player [] players = new Player[2];         //initializes two players, since it is the parent can be CPU or human
    private boolean player1sturn = true;
    //********************************************************************************************************
    public Game()   //two human players
    {
        gameBoard = new Board();
        players[0] = new Human(1);
        players[1] = new Human(2);
    }
    public Game(char c)   //two robot players
    {
        gameBoard = new Board();
        players[0] = new CPU(1);
        players[1] = new CPU(2);
    }
    public Game(char c, int robot)   // one human, one robot
    {
        gameBoard = new Board();
        if(robot == 1)
        {
            players[0] = new CPU(1); //player1
            players[1] = new Human(2); //player 2
        }
        else
        {
            players[0] = new Human(1); //player 1
            players[1] = new CPU(2); //player 2
        }


    }
    //********************************************************************************************************
    public int win()    //returns player number who won, 0 is nobody
    //technically will still say someone one if player two has one spot on board and player one as two spots, so fix
    {
        for(int i = 0; i < 3; i++)
        {
            //checks all rows
            if (gameBoard.spots[i*3] + gameBoard.spots[(i*3)+1] + gameBoard.spots[(i*3)+2] == 3) 
            {
                if(gameBoard.spots[i*3] != 2 &&  gameBoard.spots[(i*3)+1] != 2 && gameBoard.spots[(i*3)+2] != 2)
                    return 1;
            }   
            if(gameBoard.spots[i*3] + gameBoard.spots[(i*3)+1] + gameBoard.spots[(i*3)+2] == 6) 
                return 2;

            //checks columns
            if(gameBoard.spots[i] + gameBoard.spots[i+3] + gameBoard.spots[i+6] == 3) 
            {
                if(gameBoard.spots[i] != 2 && gameBoard.spots[i+3] != 2 && gameBoard.spots[i+6] != 2)
                    return 1;
            }             
            if(gameBoard.spots[i] + gameBoard.spots[i+3] + gameBoard.spots[i+6] == 6)
                return 2;
        }

        //checks top left to bottom right
        if(gameBoard.spots[0] + gameBoard.spots[4] + gameBoard.spots[8] == 3)
        {
            if(gameBoard.spots[0] != 2 &&  gameBoard.spots[4] != 2 && gameBoard.spots[8] != 2)
                return 1;
        }                       
        if(gameBoard.spots[0] + gameBoard.spots[4] + gameBoard.spots[8] == 6)
            return 2;

        //checks bottom left to top right
        if (gameBoard.spots[6] + gameBoard.spots[4] + gameBoard.spots[2] == 3)   
        {
            if(gameBoard.spots[6] != 2 && gameBoard.spots[4] != 2 &&  gameBoard.spots[2] != 2)
                return 1;
        }              
        if(gameBoard.spots[6] + gameBoard.spots[4] + gameBoard.spots[2] == 6)     
            return 2;

        return 0;
            
    }
    //********************************************************************************************************
    public boolean ended()  //returns whether the game has ended (draw)
    {
        for(int i = 1; i < 9; i++)
        {
            if(isEmpty(i))
                return false;
        }
        return true;
    }
    //********************************************************************************************************
    public void placeMove(int space, int player)
    {
        //make sure to do error checking in main class, not doing it here so i dont have to include scanner
        if(player == 0)
            gameBoard.spots[space-1] = 1;
        else
            gameBoard.spots[space-1] = 2;
    }
    //********************************************************************************************************
    public boolean isEmpty(int place)
    {
        return(gameBoard.spots[place-1] == 0);
    }
    //********************************************************************************************************

    //can be used by the player array to determine which player is going
    public int getPlayer()
    {
        if(player1sturn)
            return 0;
        else
            return 1;
    }
    //********************************************************************************************************
    public void whoWon()
    {
        if(win() == 0)
            System.out.println("\n------------------ Draw! --------------------");
        else if(win() == 1)
            System.out.println("XxXxXxXxXxXxXxXxXxXx Player 1 wins! xXxXxXxXxXxXxXxXxXxX");
        else
            System.out.println("OoOoOoOoOoOoOoOoOoOo Player 2 wins! oOoOoOoOoOoOoOoOoOoO");
    }

}//game.java

