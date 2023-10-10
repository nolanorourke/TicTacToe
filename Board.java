public class Board
{
    int [] spots = new int [9];  //says whether or not a spot is taken, 0 is free, 1 is X, 2 is O
    
    public Board()
    {
        for(int i = 0; i < spots.length; i++)
        {
            spots[i] = 0;
        }
    }
    void display()
    {
        System.out.print("\n");
        char marker = ' ';
        // printf(" 1 | 2 | 3 ");               
        // printf("-----------");                
        // printf(" 4 | 5 | 6 ");                 
        // printf("-----------");                
        // printf(" 7 | 8 | 9 ");
        int i = 0;
        while(i < 3)//to move through the three levels of the board
        {
            //to show the moves
            for(int j = 0; j < 3; j++)
            {
                if(spots[(i*3)+j] == 0)
                    marker = ' ';
                else if (spots[(i*3)+j] == 1)
                    marker = 'X';
                else if(spots[(i*3)+j] == 2)
                    marker = 'O';

                System.out.printf(" %c ", marker);
                if(j < 2)
                    System.out.print("|");
            }
            //for the key
            System.out.printf("\t");
            for(int j = 1; j < 4; j++)
            {
                System.out.printf(" %d ", (i * 3)+j);
                if(j < 3)
                    System.out.print("|");
            }
            if(i < 2)
            {
                System.out.print("\n-----------");
                System.out.print("\t");
                System.out.print("-----------\n");
            }
            i++;
        }
        System.out.print("\n");
    }

    public Board copyTo(Board copyto)
    {
        for(int i = 0; i < 9; i++)
        {
            copyto.spots[i] = this.spots[i];
        }
        return copyto;

    }
}