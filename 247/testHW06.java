

//Eric Gonzalez and Preston Bullava

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class testHW06 {
	
	final private int [] zs;
	
	final private Random rng;
	
	
	public testHW06(final int size , final int max) {
		
		rng = new Random();
		zs = new int[size];
		populate(max,0);
	}// constructor

	  // Fill zs recursively. populate() is pure and tail recursive.
	
	private void populate(final int max , final int index) {
		
		if(max == zs.length) return;
		
		zs[index] = rng.nextInt(max);
		
		populate(  max,   index + 1);
		
		
		
		
	
	}//populate
	
	
	
	// max() returns the largest int found in the array and the index at
	  // which it was found. Calls the other, recursive, max() starting at
	  // index zero with a Pair containing -1 (lower than the smallest
	  // allowable index) and Integer.MIN_VALUE (smaller than any expected
	  // value). 
	
	public Pair<Integer, Integer> max(){
		return max(0, new Pair(-1, Integer.MIN_VALUE));
		
	}
	 // max() takes an integer index and a Pair representing the largest
	  // int found so far. It returns a Pair with the index of where the
	  // largest int was found and the value of the largest int. max() is
	  // tail recursive.
	private Pair<Integer, Integer> max(final int index, final Pair < Integer, Integer> maxSoFar){
		if (index == zs.length)
			return maxSoFar;
		
		if(maxSoFar.value < zs[index])
			
			return max(index + 1 , new Pair(index, zs[index]));
			return max (index+1 , maxSoFar);
		
		// base case
		// if max is bigger update maxsofar, MAXSOFAR.value
		//...
	}//max()
	
	// sum() returns the sum of the integers in the array zs. 
	  public int sum() {
	    return sum(0, 0);
	  } // sum()
	
	private int sum( final int index, final int accum) {
		
		if (index < zs.length)
			return accum;
			return sum(index + 1 , accum + zs[index]);
		
	}//sum;
	
	// evens() returns a list containing all the elements of zs that are
	  // even.
	public List <Integer> evens() {
		List<Integer> a1 = new ArrayList<Integer>();
		int count = 0;
		
		if ( count == zs.length)
			if (count % 2 == 0)
				 a1.add(0, a1.size());
		return evens(0 , a1);
		//...
	}//evens
	
	// evens() is tail recursive and pure, taking the current index into
	  // zs and appending the current element of zs to ints iff the element
	  // is even. 
	private List<Integer> evens (final int index, final List<Integer> ints){
		List<Integer> temp = ints; // 
		if(index == zs.length) 
		return ints;
		
		if (zs[index] %2 == 0)
			temp.add(zs[index]);
		return evens(index + 1 , temp);
		
	
		
		//list m = lst;
		//m.append()
		
		//....
	}
	
	 // toString() returns the values contained in zs represented as a
	  // string, one space between each int.
	
	
	private void toString(final StringBuilder sb, final int index) {
		if (index < zs.length){
			
			System.out.println( zs[index] + " " );
		}
		
		toString(sb,index);
	// sb = new StringBuilder();
		//toString(sb, 0);
		
		//...
	}// to string
	
	
	
	public static void main (String [] args) {
		final testHW06 d = new testHW06(25, 100);
		System.out.println(d);
		final Pair<Integer, Integer> max = d.max();
	    System.out.println("The maximum, " + max.value
	                       + ", was found at " + max.index);
	    System.out.println("The sum is " + d.sum());
	    System.out.println();
	    System.out.println("Evens:");
	    for (Integer z: d.evens())
	      System.out.print(z + " ");
	    System.out.println();
		
	}
}

//Pair just holds two items of a selected type. 
class Pair<U, V> { // POD (plain old data) class

final U index;
final V value;

public Pair(final U index, final V value) {
 this.index = index;
 this.value = value;
} // constructor

} // class Pair
