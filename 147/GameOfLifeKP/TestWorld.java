import java.util.Scanner;

public class TestWorld {
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	System.out.print("Enter number of rows: ");
	int row = input.nextInt();
	
	System.out.print("Enter number of columns: ");
	int col = input.nextInt();
	
	// Initalizes world object with row and columns
	// based on the user's input
	World world = new World(row, col);

        System.out.println("\nChoose one pattern from options 1 to 5. \n" +
                           "\tPattern 1 - Glider\n" +
                           "\tPattern 2 - Spaceship\n" +
                           "\tPattern 3 - Tumbler\n" +
                           "\tPattern 4 - Blinker\n" +
			   "\tPattern 5 - Exploder\n" +
			   "\tPattern 6 - Beacon\n" +
			   "\tPattern 7 - Beehive\n");

        // Initializes a new board
        world.initNewBoard();

        System.out.print("Pattern Choice: ");

        // Stores the user's choice regarding glider pattern
        String userChoice = input.next();

        // Stores the user's selected glider pattern
        char[][] currentPattern = world.generatePattern(userChoice);

	System.out.print("Enter row for glider placement: ");
	int gliderRow = input.nextInt();
	
	System.out.print("Enter column for glider placement: ");
	int gliderCol = input.nextInt();
	
        // Places the glider onto the board
        world.putGlider(currentPattern, gliderRow, gliderCol);

	System.out.print("How many generations would you like to process? ");
	int numGenerations = input.nextInt();

	// By default, sleep time is 1 second 
	long sleepTime = 1000;

	// Get command line time if entered
	if(args.length == 1) {
	    sleepTime = Long.parseLong(args[0]);
	}

	// Displays the board for each generation iteration
        world.nextIteration(numGenerations, sleepTime);
    }
}
