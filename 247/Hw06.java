import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hw06 {
	final private int[] zs;    // an array of int for test data
							   // zs is plural of z
	final private Random rng;  // pseudorandom number generator

	// The constructor takes an array size and maximum value. It creates
	// an int[] with size elements, and places a pseudorandom int in the 
	// range 0 to max-1 in each element.
	public Hw06(final int size,  // # of pseudorandom ints
		final int max) {		 // largest allowable random int
		rng = new Random();
		zs = new int[size];
		populate(max, 0);		 // fill zs with size ints in the range zero to max-1
	} // constructor

	// Fill zs recursively. populate() is pure and tail recursive.
	private void populate(final int max, final int index) {
        int randNum = rng.nextInt(max);

        if(index < zs.length) {
            zs[index] = randNum;       
            populate(max, index + 1);
        }
	} // populate()

	// max() returns the largest int found in the array and the index at
	// which it was found. Calls the other, recursive, max() starting at
	// index zero with a Pair containing-1 (lower than the smallest
	// allowable index) and Integer.MIN_VALUE (smaller than any expected 
	// value).
	public Pair<Integer, Integer> max() {
        //Pair<Integer, Integer> test1 = new Pair(1,1);
        Pair<Integer, Integer> maxPair = max(0, new Pair(-1, Integer.MIN_VALUE));
        return maxPair;
	} // max()

	// max() takes an integer index and a Pair representing the largest
	// int found so far. It returns a Pair with the index of where the 
	// largest int was found and the value of the largest int. max() is 
	// tail recursive.
	
	/**
	 * Removed the final from Pair
	 */
	
	private Pair<Integer, Integer> max(final int index, 
						     Pair<Integer, Integer> maxSoFar) {
	    /*if(index == zs.length-1) {
            //System.out.println();
            return maxSoFar;
        }
        
        
        if(zs[index] > zs[index + 1]) {
            maxSoFar = new Pair(index, zs[index]);
            
            //System.out.print("(" + maxSoFar.index + "," + maxSoFar.value + ") ");
        }
        
        return max(index + 1, maxSoFar);*/
	    if (index == zs.length)
		return maxSoFar;

	    if(maxSoFar.value < zs[index])

		return max(index + 1 , new Pair(index, zs[index]));
	    return max (index+1 , maxSoFar);
        
	} // max()

	// sum() returns the sum of the integers in the array zs
	public int sum() {
		return sum(0,0);
	} // sum()

	// sum() takes the current index into zs and the sum of all the ints
	// so far and returns the sum. sum() is tail recursive and pure.
	private int sum(final int index,    // the current index(incremented with each call)
					final int accum) {  // The sum so far.
    
        if(index == zs.length) {
            return accum;
        }
    
        return sum(index + 1, accum + zs[index]);
        
	}  // sum()

	// evens() returns a list containing all the elements of zs that are
	// even.
	public List<Integer> evens() {
		List<Integer> al = new ArrayList<Integer>();
		return evens(0, al);
	} // evens()

	// evens() is tail recursive and pure, taking the current index into 
	// zs and appending the current elements of zs to ints iff the element
	// is even.
	private List<Integer> evens(final int index,
				    final List<Integer> ints) {
        if(index == zs.length) {
            return ints;
        }
        
        if(zs[index] % 2 == 0) {
            ints.add(zs[index]);
        }
        
        return evens(index + 1, ints);
        
	} // evens()

	// toString() returns the values contained in zs represented as a 
	// string, one space between each int.
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		toString(sb, 0);
		return sb.toString();
	} // toString()

	// toString() takes two arguments, a StringBuilder and a current
	// index. It walks through the array, appending each element to sb,
	// and following each element with a space. toString() is tail
	// recursive and pure. Each recursive call will have an index one more
	// than the preceding call. Recursion ends when the end of zs is 
	// reached.
	private void toString(final StringBuilder sb, final int index) {
	    if(index == zs.length) {
		return;
	    }
	
	    toString(sb.append(zs[index]).append(" "), index + 1);
        } // toString()

	public static void main(String[] args) {
		final Hw06 d = new Hw06(25, 100);
		System.out.println(d);
		final Pair<Integer, Integer> max = d.max();
		System.out.println("The maximum, " + max.value + " , was found at " + max.index);
		System.out.println("The sum is " + d.sum());
		System.out.println();
		System.out.println("Evens:");
		for (Integer z: d.evens()) 
			System.out.print(z + " ");
		System.out.println();
	} // main()

} //class Hw06

// Pair just holds two items of a selected type
class Pair<U, V> { // POD (plain old data) class

	final U index;
	final V value;

	public Pair(final U index, final V value) {
		this.index = index;
		this.value = value;
	} // constructor
} // class Pair
