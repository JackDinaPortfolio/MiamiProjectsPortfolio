
public class Rectangle extends Shape {
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		super("Rectangle");
		this.width = width;
		this.height = height;
	}
	
	public double getPerimeter() {
		return (2 * width) + (2 * height);
	}	
	
	public double getArea() {
		return width* height;
	}
	public String toString() {
		return super.toString() + ", width=" + width + ", height=" + height;
	}
}
