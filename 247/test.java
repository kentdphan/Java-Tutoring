//Sheetal George
//Exercise 6.1

public class test {
    public static void main (String[]args){

	System.out.println("The first 100 pentagonal numbers:");
	
	for (int n=1;n<=100;n++) {
	    if (n%10==0) {
		System.out.println(pentagon(1));
	    }
	    else {
		System.out.println(pentagon(1) + " ");
	    }
	}
	
    }
    public static int pentagon(int n) {
	n = 1;
	return n*(3*n-1)/2;
    }
    
}