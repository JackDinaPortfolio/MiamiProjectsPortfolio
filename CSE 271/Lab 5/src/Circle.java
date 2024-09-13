
public class Circle extends Shape {
	private int radius;
	
	public Circle(int radius) {
		super("Circle");
		this.radius = radius;
	}
	
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	public double getArea() {
		return Math.sqrt(radius) * Math.PI;
	}
	
	public String toString() {
		return super.toString() + ", radius=" + radius;
	}
}
