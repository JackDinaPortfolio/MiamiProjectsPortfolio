import java.util.Objects;

public class Rectangle {
	private double width;
	private double length;

	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	// A private helper method to get area. Private because the
	// specifications didn't include mention of it
	private double findArea() {
		return this.length * this.width;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getLength() {
		return this.length;
	}
	/**
	 * Returns the other rectangle has the same area as this rectangle
	 * 
	 * @param other the other rectangle
	 * @return true if the other rectangle has the same area as this rectangle, and
	 *         false otherwise
	 */
	public boolean hasSameArea(Rectangle other) {
		return (this.findArea() == other.findArea());	
	}

	public String toString() {
		return String.format("Rectangle: %f, %f", getLength(), getWidth());
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		
		
		return Double.doubleToLongBits(length) == Double.doubleToLongBits(other.length)
				&& Double.doubleToLongBits(width) == Double.doubleToLongBits(other.width);
	}
		
	/*
	 * Implement the standard equals method.
	 */
	

	
	
//	@Override
//	public boolean equals(Object other) {
//		if (other == null) {
//			return false;
//		}
//		if (other.getClass() != this.getClass()) {
//			return false;
//		}
//		
//		// other is an OBJECT reference, and doesn't give us access to any Rectangle stuff
//		// return this.width == other.
//		
//		// WE KNOW that other is a Rectangle. So we want to compare its
//		// width and height to this.width and this.height
//		
////		return ((Rectangle)other).width == this.width 
////				&&
////				((Rectangle)other).height == this.height;
//		
//		
//		Rectangle that = (Rectangle)other;
//		
//		return (this.length == that.length && this.width == that.width);
//		
//	}
	
	
	
	
	
	

}
