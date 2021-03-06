public class World {
    private int rows;
    private int columns;
    private char[][] board = new char[rows][columns];    // current generation
    private char[][] nextGen = new char[rows][columns];  // next generation
    
    // no-arg constructor 
    public World() {
    
    }
    
    // constructor - rows and columns are initialized by the user
    public World(int rows, int columns) {
	this.rows = rows;
	this.columns = columns;
	board = new char[rows][columns];
	nextGen = new char[rows][columns];
    }
    
    // Initializes a new board
    public void initNewBoard() {
	for(int r = 0; r < board.length; r++) {
	    for(int c = 0; c < board[0].length; c++) {
		board[r][c] = ' ';
	    }
	}
    }
    
    /**
     *  Generates a pattern based off the user's choice
     *  @param choice - User's choice for a glider pattern
     */
    public char[][] generatePattern(String choice) {
	char[][] patternBoard = null;
	
	switch(choice) {
	// Glider
	case "1": 
	    char[][] gliderBoard = {{' ', '*', ' '},
				    {' ', ' ', '*'},
				    {'*', '*', '*'}};
	    
	    patternBoard = gliderBoard; 
	    break;
	    
	// Spaceship
	case "2": 
	    char[][] spaceshipBoard = {{'*', '*', '*'},
				       {'*', ' ', '*'},
				       {'*', '*', '*'}};
	    
	    patternBoard = spaceshipBoard;					    
	    break;
	    
	// Tumbler
	case "3": 
	    char[][]  tumblerBoard = {{' ', '*', ' '},
				      {'*', '*', '*'},
				      {'*', '*', '*'}};
	    
	    patternBoard = tumblerBoard;
	    break;
		    
	// Blinker
	case "4": 
	    char[][] blinkerBoard = {{' ', '*', ' '},
				     {' ', '*', ' '},
				     {' ', '*', ' '}};
	    
	    patternBoard = blinkerBoard;
	    break;
	    // Exploder
	case "5":
	    char[][] exploderBoard = {{' ', '*', ' '},
				      {'*', '*', '*'},
				      {'*', ' ', '*'},
				      {' ', '*', ' '}};
	    patternBoard = exploderBoard;
	    break;
	case "6":
            char[][] beaconBoard = {{'*', '*', ' ', ' '},
				    {'*', ' ', ' ', ' '},
				    {' ', ' ', ' ', '*'},
				    {' ', ' ', '*', '*'}};
            patternBoard = beaconBoard;
            break;
	case "7":
            char[][] beehiveBoard = {{' ', '*', '*', ' '},
				     {'*', ' ', ' ', '*'},
				     {' ', '*', '*', ' '}};
                                    
            patternBoard = beehiveBoard;
            break;

    
	default: 
	    System.out.println("Choice is invalid.");
	    break;
	}
	
	return patternBoard;
    }
    
    /**
     *  Places the glider pattern onto the board
     *  @param patternBoard - Stores the pattern for selected board
     *  @param gliderRow - Row for glider
     *  @param gliderCol - Column for glider
     */
    public char[][] putGlider(char[][] patternBoard, int gliderRow, int gliderCol) {
        int row = 0;
	int col;

	for(int r = gliderRow; r < patternBoard.length + gliderRow; r++) {
            col = 0;
	    for(int c = gliderCol; c < patternBoard[0].length + gliderCol; c++) {
                board[r][c] = patternBoard[row][col++];
            }
	    row++;
        }
        return board;
    }
    
    /**
     *  Checks on whether if the grid is within the contents of the board
     *  @param r - Row
     *  @param c - Column
     */
    public boolean inBounds(int r, int c) {
	return (r >= 0 && r < board.length && c >= 0 && c < board[0].length);
    }
    
    /**
     *  Count the surround neighbors
     *  @param r - Row
     *  @param c - Column
     */
    public int countNeighbors(int r, int c) {
	int count = 0;

	// top left
	if(inBounds(r-1, c-1) && board[r-1][c-1] == '*') {
	    count++;
	}
	// top middle
	if(inBounds(r-1, c) && board[r-1][c] == '*') {
	    count++;
	}
	// top right
	if(inBounds(r-1, c+1) && board[r-1][c+1] == '*') {
	    count++;
	}
	// center left
	if(inBounds(r, c-1) && board[r][c-1] == '*') {
	    count++;
	}
	// center right
	if(inBounds(r, c+1) && board[r][c+1] == '*') {
	    count++;
	}
	// bottom left
	if(inBounds(r+1, c-1) && board[r+1][c-1] == '*') {
	    count++;
	}
	// bottom middle
	if(inBounds(r+1, c) && board[r+1][c] == '*') {
	    count++;
	}
        // bottom right
	if(inBounds(r+1, c+1) && board[r+1][c+1] == '*') {
	    count++;
	}
	
	return count;
    }
    
    /**
     *  Applies Conway's Game of Life
     *  @param count - Count for surrounding neighbors
     *  @param r - Row
     *  @param c - Column
     */
    public void applyRules(int count, int r, int c) {	
	// Birth
	if(board[r][c] == ' ' && count == 3) {
	    nextGen[r][c] = '*';
	}
	// Survival
	else if(board[r][c] == '*' && (count == 2 || count == 3)) {
	    nextGen[r][c] = '*';
	}
	// Overcrowding / Loneliness
	else if(board[r][c] == '*' || board[r][c] == ' ') {
	    nextGen[r][c] = ' ';
	}
    }

    // Sets the next generation to the current generation
    public void setNextGenBoard() {
	for(int r = 0; r < board.length; r++) {
	    for(int c = 0; c < board[0].length; c++) {
		nextGen[r][c] = board[r][c];
	    }
	}
    }

    // Sets the current generation to the next generation
    public void setCurrentGenBoard() {
	for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                board[r][c] = nextGen[r][c];
            }
        }
    }

    // Updates board by calling countNeighbors and applyRules method
    public void updateBoard() {
	int numOfNeighbors = 0;

        for(int r = 0; r < board.length; r++) { 
	    for(int c = 0; c < board[0].length; c++) {
		numOfNeighbors = countNeighbors(r, c);
		applyRules(numOfNeighbors, r, c);
	    }
	}
    }
    
    /**
     *  Perform setup for the board for each of the generations
     *  @param numGeneration - Number of generations based on user's input
     *  @param sleepTime - Amount of delay before displaying each generation
     */
    public void nextIteration(int numGenerations, long sleepTime) {
	// Displays the initial generation
	setNextGenBoard();
	printBoard(0);

	// Initializes the sleep object
	Sleep sleep = new Sleep();
	sleep.sleeper(sleepTime);

        for(int counter = 1; counter < numGenerations; counter++) {
	    System.out.println();
	    setNextGenBoard();
	    updateBoard();
	    printBoard(counter);
	    sleep.sleeper(sleepTime);
	    setCurrentGenBoard();
	}
    }

    /**
     *  Displays each generation
     *  @param counter - Counter for each generation
     */
    public void printBoard(int counter) {
	System.out.println("Generation " + counter);
	
	for(int r = 0; r < nextGen.length; r++ ) {
	    for(int c = 0; c < nextGen[0].length; c++) {
		System.out.print(nextGen[r][c]);
	    }
	    System.out.println();
	}
    }
}
