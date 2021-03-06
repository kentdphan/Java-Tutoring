//Time-stamp: <2018-04-05 13:09:00 jdm>

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {


    private final int id;       // 5 hex digits fits in one 4B int, or a
    // 10B UTF-16 String. Pick the smaller.
    private final String dob;   // date of birth
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



public class People {

    private final List<Person> db = new ArrayList<>();


    public People(final String filename) throws FileNotFoundException {
	final Scanner in = new Scanner(new File(filename));
	while (in.hasNextLine())
	    db.add(new Person(in.nextLine()));

	in.close();
    } // constructor


    public Person get(final int id) {
	for (Person p: db)
	    if (p.id() == id)  // id is int, which is primitive, so == is ok
		return p;
	return null;
    } // get()


      @Override
	  public String toString() {
	  final StringBuilder sb = new StringBuilder();
	  for (Person p: db) {
	      sb.append(p);
	      sb.append("\n");
	  } // for each
	  return sb.toString();
      } // toString()


    private static Scanner in = null;

    public static String promptForInput(final String prompt) {
        System.out.print(prompt);
        if (in == null)
            in = new Scanner(System.in);

        final String result = in.nextLine();
        if (result.equals("q"))
            return null;
        else return result;
    } // promptForInput()


    public static void main(String[] unused)  throws FileNotFoundException {

	final String inputName  = "db.txt";
	final People db = new People(inputName);
	//System.out.println(db);
	final String reply = db.promptForInput("Desired ID: ");
	final int id = Integer.parseInt(reply, Person.RADIX); // could throw
	final Person someone = db.get(id);
	if (someone == null)
	    System.out.println("ID '"
			       + Integer.toString(id, 16)
			       + "' not found.");
	else
	    System.out.println(someone);

    } // main()


} // class People
