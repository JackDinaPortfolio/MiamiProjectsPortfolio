import java.awt.Point;
import java.util.ArrayList;

/*
 * This uses the Rectangle and Box classes we wrote together in class.
 * it assumes that Rectangle and Box have properly written equals() methods
 * and toString() methods.
 */

public class Lab4Methods {

	public static void main(String[] args) {

		// You can (and should) modify these however you want in order
		// to test your methods. They are just meant to give you some
		// helpful starting code.
		Rectangle[] justRectangles = {
				new Rectangle(3, 8),
				new Rectangle(4, 6),
				new Rectangle(5, 7),
				new Rectangle(0, 0),
		};

		Box[] justBoxes = {
				new Box(1, 1, 1),
				new Box(2, 2, 2),
				new Box(3, 3, 3),
				new Box(4, 4, 4)
		};

		Rectangle[] rectBoxMix = {
				new Box(3, 3, 3),
				new Box(4, 4, 5),
				new Rectangle(10, 10),
				new Rectangle(10, 20),
				new Rectangle(10, 30),
				new Rectangle(10, 40)
		};

		// Notice that one of the items is null.
		// Test your code without including null. Does it work?
		// Then test your code including the null item. Does it work?
		Object[] totalMix = {
				new Rectangle(7, 10),
				new Rectangle(8, 5),
				new Box(5, 5, 5),
				new Box(10, 10, 10),
				new Box(20, 20, 20),
				new Box(30, 30, 30),
				new Box(40, 40, 40),
				new Point(3, 4),
				new String("cat")
		};

		// As you test your methods, test with all the arrays that make sense for that
		// method.
		// You can also create your own test arrays. In fact, you SHOULD create
		// your own test arrays.
		//System.out.println("100? " + totalVolume(justBoxes));
		//System.out.println("0? " + totalVolume(justRectangles));
		//System.out.println("107? " + totalVolume(rectBoxMix));
		
		//ArrayList<Rectangle> answer = getBoxesAndRectangles(totalMix);
		//for(Rectangle r : answer) {
		//	System.out.println(r);
		//}
		
		//System.out.println(countHeight(justBoxes, 4));
		
		System.out.println(getBigRectangles(justRectangles));
		
		

	}

	// For each of these methods, you should test them with all of the
	// above arrays that can legally be passed in as a parameter.
	// For example, totalVolume(Box[] boxes) only works with the Box array above,
	// but printOnlyRectangles(Object[] objects) should work with all 4 of the above
	// arrays.
	// You should also test with your own arrays..

	/*
	 * Computes the total volume of all the boxes in the array. We can only pass a
	 * Box[] into it. Not a Rectangle[] or an Object[]
	 */
	public static double totalVolume(Box[] boxes) {
		double total = 0.0;
		
		for(Box b : boxes) {
			if(b != null) {
				total += b.getVolume();
			}
		}
		
		return total;
	}

	/*
	 * Computes the total volume of all the boxes in the array. We can pass a
	 * Rectangle [] or a Box[] to it, but not Object[]
	 */
	public static double totalVolume(Rectangle[] rectangles) {
		double total = 0.0;
		
		for (Rectangle r : rectangles) {
			if(r instanceof Box) {
				Box b = (Box)r;
				total += b.getVolume();
			}
		}
		
		return total;
	}

	/*
	 * Returns a count of how many objects in the array are boxes or rectangles We
	 * can pass any of Object{}, Rectangle[], or Box[].
	 */
	public static int boxRectCount(Object[] objects) {
		int count = 0;
		
		for(Object o : objects) {
			if (o instanceof Rectangle) {
				count++;
			}
		}
		
		return count;
	}

	/*
	 * Returns a list of the objects in the array that are boxes or rectangles
	 */
	public static ArrayList<Rectangle> getBoxesAndRectangles(Object[] objects) {
		ArrayList<Rectangle> result = new ArrayList<>();
		
		for(Object o : objects) {
			if (o instanceof Rectangle) {
				result.add((Rectangle)o);
			}
		}
		
		return result;
	}

	/*
	 * Returns a count of how many objects in the array are boxes with the specified
	 * height.
	 */
	public static int countHeight(Object[] arr, double height) {
		int count = 0;
		
		for(Object o : arr) {
			if (o instanceof Box) {
				Box b = (Box)o;
				if(b.getHeight() == height) {
					count++;
				}
			}
		}
		
		return count;
	}

	/*
	 * Returns a list of rectangles and boxes with area greater than 20, where area
	 * is defined by length * width.
	 */
	public static ArrayList<Rectangle> getBigRectangles(Rectangle[] rectangles) {
		ArrayList<Rectangle> result = new ArrayList<>();
		
		for(Rectangle r : rectangles) {
			if (r.getWidth() * r.getLength() > 20) {
				result.add(r);
			}
		}
		
		return result;
	}

	/*
	 * Returns a count of how many rectangles in the array match the specified
	 * rectangle. Use equals() rather than getWidth() and getLength().
	 */
	public static int countMatches(Rectangle[] rectangles, Rectangle rectKey) {
		return -1;
	}

	/*
	 * PRINT just the Boxes, one per line
	 */
	public static void printTheBoxes(Object[] objects) {

	}

	/*
	 * RETURN just the Boxes, in a list. Note that you cannot put Object references
	 * in a Box ArrayList.
	 */
	public static ArrayList<Box> getTheBoxes(Object[] objects) {
		return null;
	}

	/*
	 * Returns an arraylist of only the Point objects in the given array where the
	 * x- and y-coordinates are equal (such as a point at 5, 5).
	 */
	public static ArrayList<Point> matchingPoints(Object[] objects) {
		return null;
	}

	/*
	 * Returns true if the array has at least two items that are equal to each other
	 * (such as two matching boxes, two matching rectangles, two matching points,
	 * two matching strings, and so on).
	 */
	public static boolean foundMatch(Object[] objects) {
		return false;
	}

	/*
	 * Returns true if all the items in the array are equal to each other, and false
	 * otherwise. A nested loop solution might come to mind, but the most efficient
	 * solution would be one that only needs one (non-nested) loop.
	 */
	public static boolean allMatch(Object[] objects) {
		return false;
	}

	/*
	 * Returns a count of how many rectangles and boxes have dimensions that are all
	 * the same (in other words, a non-box rectangle where the length and width are
	 * the same, OR a box where the length and width and height are the same). So,
	 * for example, if the array contained Rectangle(3, 4), Rectangle(7, 7), Box(2,
	 * 3, 4), and Box(5, 5, 5) then this method would return 2, because Rectangle(7,
	 * 7) and Box(5, 5, 5) have matching rectangles.
	 */
	public static int allDimensionsMatchCount(Rectangle[] rectangles) {
		return -1;
	}

}
