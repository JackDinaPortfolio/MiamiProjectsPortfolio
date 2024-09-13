
public class Triangle extends Shape {
	private int side1;
	private int side2;
	private int side3;

	public Triangle(int side1, int side2, int side3) {
		super("Triangle");
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	public double getArea() {
		double s = getPerimeter();
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}

	public String toString() {
		return super.toString() + ", side1=" + side1 + ", side2=" + side2 + ", side3=" + side3;
	}
}
