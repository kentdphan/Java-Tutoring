/**
 * Each student changes the locker by using an algorithm, we will determine the end result
 * to determine which of the lockers are open.
 */

public class LockerPuzzle {
    public static void main(String[] args) {
	// Array to intialize the states of the locker
        boolean[] lockerState = new boolean[101];

        // Array to intialize for 100 lockers for 100 students 
        String[] lockers = new String[101];

        // Assign every locker state in the array
        for(int i = 1; i < lockerState.length; i++) {
            lockerState[i] = false;
        }

        // Assign every locker in the array (L1 to L100)
        for(int i = 1; i < lockers.length; i++) {
            lockers[i] = "L" + i;
        }
	
	// Method call for displaying locker state
	displayLockerState(lockerState, lockers);

        // Displays the final output of locker state
        for(int counter = 1; counter < lockerState.length; counter++) {

	    if (lockerState[counter] == true) {
		System.out.println("Locker " + lockers[counter] + " is open");
	    }
        }
    }

    // Method that will be the algorithm to indicate the locker's current state
    public static boolean[] displayLockerState (boolean[] lockerState, String[] lockers) {
	// the outer for loop goes through each of the locker indexes
	for(int i = 1; i < lockers.length; i++) { 
	    // the inner for loop accounts for the multiples of every nth element that 
	    // a student approaches toward changing the state of the locker
	    for(int j = i; j < lockers.length; j+=i) {
		
		// Change the state of locker to close
		if(lockerState[j] == true) {
		    lockerState[j] = false;
		}
		// else change the state of locker to open
		else {
		    lockerState[j] = true;
		}
	    }
	}
	// return the entire array of boolean values
        return lockerState;
    }
}
