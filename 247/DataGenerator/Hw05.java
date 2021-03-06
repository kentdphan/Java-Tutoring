import java.io.FileNotFoundException;

class Hw05 extends People {
    
    // Constructor which creates the parent class constructor 
    Hw05(String fileName) throws FileNotFoundException {
	super(fileName);
    }

    // getFullName() method - Receives an ID and returns the 
    // name in the following format: last name, comma, rest of name
    public String getFullName() {
	
	return ;
    }
    
    public static void main(String[] args) {
	try {
	    Hw05 formatName = new Hw05("db.txt");
	    formatName.promptForInput();
	    String name = formatName.getFullName();
	    System.out.println(name);
	} catch(FileNotFoundException e) {
	    System.err.println("File was not found");
	}
    }
}