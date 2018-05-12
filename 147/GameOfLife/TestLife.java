//Scanner is in java.util package
import java.util.Scanner;

public class TestLife {
    /**Main method */
    public static void main(String[] args) {
        //Create Scanner object
        Scanner input = new Scanner(System.in);

        //Prompts user to enter rows & cols
        System.out.println("Enter # of rows: ");
        int rows = input.nextInt();
        System.out.println("Enter # of columns: ");
        int cols = input.nextInt();
       
        //Prompt user to pick a pattern
        System.out.println("Number 1 = glider");
        System.out.println("Number 2 = five row cell");
        System.out.println("Number 3 = tumbler");
        System.out.println("Number 4 = spaceship");
        System.out.println("Enter a pattern: ");
        int num1 = input.nextInt();

    /*
     * create instance of life 
     */
    Life world1 = new Life(rows, cols);
    world1.initializeGrid();
    
    /*
     * call patterns
     */
    if(num1 == 1) 
    {
        world1.putGlider(2, 2); //glider pattern
    } else if(num1 == 2) 
    {
        world1.putFiveRow(); //five row pattern
    } else if(num1 == 3) 
    {
        world1.putTumbler(3, 4); //tumbler pattern
    } else if(num1 == 4) 
    {
        world1.putSpaceship(4, 4); //spaceship pattern
    }
    world1.printGrid(); //invoke grid
    
    }
}