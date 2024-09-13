
public class Square extends Shape{
	private int length;
	
	public Square (int length) {
		super("Square");
		this.length = length;
	}
	
	public double getPerimeter() {
		return 4 * length;
	}
	
	public double getArea() {
		return length * length;
	}
	
}
