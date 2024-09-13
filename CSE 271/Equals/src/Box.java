
public class Box extends Rectangle {
	private double height;
	
	public Box(double length, double width, double height) {
		super(length, width);
		this.height = height;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getVolume() {
		return super.getLength() * super.getWidth() * this.getHeight();
	}
	
	
	
	
	
	
	@Override
	public boolean equals(Object other) {
		// this piece checks that it's a rectangle,
		// and that the length and width are matching
		if (!super.equals(other)) {
			return false;
		}
		
		// Check that it is a box:
		if (other.getClass() != this.getClass()) {
			return false;
		}
		
		// 
		Box that = (Box)other;
		return this.height == that.height;
	}
	
	public String toString() {
		return String.format("Box: %f, %f, %f", getLength(), getWidth(), getHeight());
	}

}
