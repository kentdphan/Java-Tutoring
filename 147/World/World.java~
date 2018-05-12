import java.util.Scanner;

class World {
    private int rows = 0;
    private int cols = 0;
    private char[][] grid = new char[26][26];

    // Constructors: no-arg 
    public World(int rows, int cols) {
	this.rows = rows;
	this.cols = cols;
    }

    // initial all cells to known value
    public char[][] initializeGrid() {
	for(int i = 0; i < rows; i++) {
	    for(int j = 0; j < cols; j++) {
		grid[i][j] = ' ';
	    }
	}
	
	return grid;
    }

    // print grid
    public void printGrid() {
	System.out.println("World: Created grid with " + rows + " and " + cols + " columns");
	for(int i = 0; i < rows; i++) {
	    for(int j = 0; j < cols; j++) {
		System.out.print(grid[i][j]);
	    }
	    System.out.println();
	}
    }

    // r+1, c+1
    // r+1, c-1
    
    // Creates the live cells of diagonals
    public void diagonals() {
	// one diagonal
	for(int r = 0; r < rows; r++) {
	    for(int c = 0; c < cols; c++) {
		if(r == c) {
		    grid[r][c] = '*';
		}
	    }
	}
	// the other diagonal
	for(int r = 0, c = cols-1; r < rows; r++, c--) {
                grid[r][c] = '*';
        }
    }

    // Check for live cells
    public void checkCells() {
	for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(r == c) {
		    System.out.println("Found live cell at row " + r + " column " + c);
                }
            }
        }
        // the other diagonal
        for(int r = 0, c = cols-1; r < rows; r++, c--) {
	    grid[r][c] = '*';
	    System.out.println("Found live cell at row " + r + " column " + c);
        }
	
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Number of rows is: ");
	int r = sc.nextInt();
	System.out.print("Number of cols is: ");
	int c = sc.nextInt();

	// Creates an instance of world
	World w = new World(r, c);

	w.initializeGrid();
	w.diagonals();
	w.printGrid();
	w.checkCells();

    }
}