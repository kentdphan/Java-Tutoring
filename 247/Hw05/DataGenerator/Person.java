import java.util.Scanner;

class Person {
    private final int id;        // 5 hex digits fits in one 4B int, or a
                                 // 10UTF-16 String. Pick the smaller,
                                 // date of birth
    private final String dob;
    private final String phone;
    private final String name;
    
    static final int RADIX = 16; // hexadecimal (base 16)
    
    public Person(final String line) {
	// Could throw if there are too few tokens or if the first token
	// isn't a hex value. Ignores anything past the fourth token.
	final Scanner s = new Scanner(line);
	id = s.nextInt(RADIX);
	dob = s.next();
	phone = s.next();
	name = s.nextLine();
    } // constructor

    public int id() { // accessor/getter
	return id;
    } // id()

    @Override
	public String toString() {
	return 
	    Integer.toHexString(id) + " "
	    + dob + " "
	    + phone + " "
	    + name;
    } // toString()
} // class Person