import java.awt.Point;
import java.util.Scanner;

public class RectangleTester {

	public static void main(String[] args) {
		
		Box b1 = new Box(3, 4, 5);
		Box b2 = new Box(3, 4, 5);
		Box b3 = new Box(4, 6, 8);
		
		System.out.println(b1.equals(b2));
		System.out.println(b1.equals(b3));
		
		Rectangle r = new Rectangle(3, 4);
		System.out.println(r.equals(b1));
		System.out.println(b1.equals(r));

//		Rectangle r1 = new Rectangle(4, 6);
//		Rectangle r2 = new Rectangle(3, 8);
//		Rectangle r3 = new Rectangle(5, 7);
///	Rectangle r4 = new Rectangle(4, 6);
//		Rectangle r5 = null;
		
//		System.out.println(r5 == r5); //


//		System.out.println("r1 same area as r2 should be true: " + r1.hasSameArea(r2));
//		System.out.println("r1 same area as r3 should be FALSE: " + r1.hasSameArea(r3));
		
		
//		System.out.println(r1.equals(r2)); // false
//		System.out.println(r1.equals(r5)); // false (test for null)
//		System.out.println(r1.equals(r4)); // true
//		System.out.println(r1.equals(r1)); // true
//		System.out.println(r1.equals("cat")); // false (testing for wrong type)
		




		
		
		
		

	}

}