import java.io.FileNotFoundException;

class Hw05 extends People {
    
    // Constructor which creates the parent class constructor 
    Hw05(String fileName) throws FileNotFoundException {
	super(fileName);
    }

    // getFullName() method - Receives an ID and returns the 
    // name in the following format: last name, comma, rest of name
    public String getFullName(int id) throws FileNotFoundException {
	People someone = new People("db.txt");
	Person p = someone.get(id);
	String words = p.toString();
	String[] splitArray = words.split("\\s+");
	String firstName = "";
	String lastName = "";
	String fullName = "";

	for(int index = 3; index <= splitArray.length - 2; index++) {
	    firstName += splitArray[index] + " "; 
	}

	lastName = splitArray[splitArray.length - 1];
	
	fullName = lastName + ", " + firstName;
	
	return fullName;

    }
    
    public static void main(String[] args) {
	try {
	    Hw05 formatName = new Hw05("db.txt");
	    String input = formatName.promptForInput("ID: ");
	    int id = Integer.parseInt(input, 16);
	    String name = formatName.getFullName(id);
	    System.out.println(input +"'s name is " + name);
	} catch(FileNotFoundException e) {
	    System.err.println("File was not found");
	}
    }
}