public class Q03Sp12b {
    public static void main(String[] args) {
	B theB = new B(7);
	theB.increase();
	theB.decrease();
	System.out.println(theB.getA());
    } // main()
} // class Q03Sp12b
class A {
    static int a;
    public A(int a) {
	this.a = a;
    } // constructor
    public void decrease() {
	a = a / 2;
	System.out.println(a);
    } // decrease()
    public void increase() {
	a = a + 2;
	System.out.println(a);
    } // increase
    public int getA() {
	return a;
    } // getA()
} // class A
class B extends A {
    private int b;
    public B(int value) {
	super(value - 1);
	b = value;
    } // constructor
    public void decrease() {
	super.decrease();
	a = a - b;
	System.out.println(a);
    } // decrease()
} // class B
