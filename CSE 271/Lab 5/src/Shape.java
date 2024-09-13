//By making this abstract there are two consequences
//1. We can no longer create object of type Shape
//2. Any child classes must implement any methods
//   labeled as abstract.
public abstract class Shape {
	private String type;
	
	public Shape(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	//There is no good implementation for this method
	//in the shape class.
	//So, we make it abstract.
	//By making this abstract, it requires
	//us to implement it in every child class.
	public abstract double getPerimeter();
	
	public abstract double getArea();
	
	public String toString() {
		return this.getClass() + ": " + type;
	}

}
