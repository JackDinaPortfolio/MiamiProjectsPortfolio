
public class Tester {

	public static void main(String[] args) {
		
		Circle c = new Circle(5);
		Rectangle r = new Rectangle(3, 4);
		Triangle t = new Triangle(3, 4, 5);	
		
		//It doesn't really make sense for me to have
		//a Shape object.
		//Can't create new Shape() if Shape is an abstract class.
		//Shape s = new Shape("just a shape"); 
		
		// Print the shapes
		System.out.println(c);
		System.out.println(r);
		System.out.println(t);
		
		// Print the perimeter of the circle, rectangle, and triangle.
		// We'll need to implement 
		System.out.println(c.getPerimeter());
		System.out.println(r.getPerimeter());
		System.out.println(t.getPerimeter());
		
		//Create an array of all my shapes
		Shape[] myShapes = {c, r, t, new Square(50)};
		
		System.out.println("total perimeter = " + getTotalPerimeter(myShapes));
		
		System.out.println("total area = " + getTotalArea(myShapes));

	}
	
	
	// Write a method that can compute the total parimeter of an
	// array of shapes.
	
	public static double getTotalPerimeter(Shape[] shapes) {
		double total = 0.0;
		
		//Loop to add all the parimeters:
		for(Shape s : shapes) {
			total += s.getPerimeter();
		}
		
		return total;
	}
	
	public static double getTotalArea(Shape[] shapes) {
		double total = 0.0;
		
		//Loop to add all the areas:
		for(Shape s : shapes) {
			total += s.getArea();
		}
		
		return total;
	}


}
