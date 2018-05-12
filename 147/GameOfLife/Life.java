/**
 File: Life.java
 Names: Teddy Ngo, Bumsu Lee, Johnny Truong
 */

/*
 * a class for the game of life
 *
 */
public class Life
{
    /*
    * members 
    */
    private char[][] grid;
    private char[][] glider = {{' ', '*', ' '},
                               {' ', '*', '*'},
                               {'*', ' ', '*'}};
    private char[][] tumbler = {{' ', '*', '*', ' ', '*', '*', ' '},
                                {' ', '*', '*', ' ', '*', '*', ' '},
                                {' ', ' ', '*', ' ', '*', ' ', ' '},
                                {'*', ' ', '*', ' ', '*', ' ', '*'},
                                {'*', ' ', '*', ' ', '*', ' ', '*'},
                                {'*', '*', ' ', ' ', ' ', '*', '*'}};
    private char[][] spaceship = {{' ', '*', '*', '*', '*'},
                                  {'*', ' ', ' ', ' ', '*'},
                                  {' ', ' ', ' ', ' ', '*'},
                                  {'*', ' ', ' ', '*', ' '}};
    private int row; //Used for grid
    private int col;

	/*
	 *  constructors
     */
	// no argument constructor 
	public Life()
	{
		
	}
    
    public Life(int row, int col)
    {
        grid = new char[row][col];
        this.row = row; //uses private
        this.col = col;
    }

    /*
     * initialize the grid cells
     */
    public void initializeGrid()
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				grid[i][j] = '0'; //grid cell made of spaces
			}
		}
    }

    /*
     * print grid layout
     */
    public void printGrid()
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
    }

    /*
     * print glider
     */
    public void putGlider(int r, int c)
	{
		int gliderRow = 0;
		int gliderCol;
		for(int i = r-1; i < ((r-1)+glider.length); i++)
		{
			gliderCol = 0;
			for(int j = c-1; j < ((c-1)+glider.length); j++)
			{
                grid[i][j] = glider[gliderRow][gliderCol++];
			}
			//advance to next row in glider matrix
			gliderRow++;
        }
    }

    /*
     * print tumbler
     */
    public void putTumbler(int r, int c)
	{
		int tumblerRow = 0;
		int tumblerCol;
		for(int i = r-1; i < ((r-1)+tumbler.length); i++)
		{
			tumblerCol = 0;
			for(int j = c-2; j < ((c-1)+tumbler.length); j++)
			{
				grid[i][j] = tumbler[tumblerRow][tumblerCol++];
			}
			//advance to next row in tumbler matrix
			tumblerRow++;
        }
    }

    /*
     * print five row
     */
    public void putFiveRow()
    {
        for(int i = 5; i < 6; i++)
        {
            for(int j = 2; j < 7; j++)
            {
            grid[i][j] = '*';
            }
        }
    }

    /*
     * print spaceship
     */
    public void putSpaceship(int r, int c)
	{
		int shipRow = 0;
		int shipCol;
		for(int i = r-1; i < ((r-1)+spaceship.length); i++)
		{
			shipCol = 0;
			for(int j = c-2; j < ((c-1)+spaceship.length); j++)
			{
				grid[i][j] = spaceship[shipRow][shipCol++];
			}
			//advance to next row in spaceship matrix
			shipRow++;
        }
    }

    /*
     * checks living cells
     */
    /*
    public void checkCells()
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
                if(grid[i][j] == '*')  //looks through entire grid
                {
                    System.out.println("Found live cell at row " + i + " column " + j);
                }
			}
		}
    }
    */

    /*
     * look for neighbors in grid 
     */ 
    public void GetNeighbors() 
    {
        for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
                if(grid[i][j] == '*')
                {
                    checkCells();
                }
            }
        }
    }

    /*
     * check if dead or living around a cell
     */
    public void checkCells()
    {
        for(int r = -1; r <= 1; r++)
        {
            for(int c = -1; c <= 1; c++)
            {
               /*if()
                {
                    
                }*/
            }
        }
    }
}