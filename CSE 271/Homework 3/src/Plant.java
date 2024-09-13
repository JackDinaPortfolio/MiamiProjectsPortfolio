/**
 * Defines a simple plant with a name, size,
 * and maximum size. Plants can grow, 1 unit
 * at a time, up to their maximum size.
 * @author Jack Dina
 * @version 1.0
 */
public class Plant {
	
	private String name;
	private int maxSize;
	private int size;
	 
	 /**
		 * Constructs a plant with a specified name, size,
		 * and maximum size
		 * @param name is the name of the plant
		 * @param maxSize is the maximum size the plant can reach.
		 * @param size is the starting size of the plant
		 */
		 public Plant (String name, int size, int maxSize) {
			 this.name = name;
			 this.size = size;
			 this.maxSize = maxSize;
		 }
		 
		 /**
		  * Constructs a plant with a specified name and
		  * maximum size, setting the initial size of the
		  * plant to 0.
		  * @param name is the name of the plant.
		  * @param maxSize is the maximum size the plant can reach.
		  */
		 public Plant (String name, int maxSize) {
			 this(name, 0,maxSize);
		 }
		 
		 /**
		  * Returns the maximum size of this plant.
		  * @return the max size of the plant.
		  */
		 public int getMaxSize() {
			 return maxSize;
		 }
		 
		 /**
		  * Returns the name of this plant
		  * @return the plant's name
		  */
		 public String getName() {
			 return name;
		 }
		 
		 /**
		  * Returns the size of this plant
		  * @return the size of the plant
		  */
		 public int getSize() {
			 return size;
		 }
		 
		 /**
		  * Increases this plant's height by 1,
		  * up to maximum size.
		  */
		 public void grow() {
			 if(isMature() == false) {
				 size++;
			 }
		 }
		 
		 /**
		  * Returns whether this plant has reached
		  * has reached full maturity (when the plant's
		  * height reaches its maximum height.
		  */
		 public boolean isMature() {
			 boolean mature = false;
			 if (size == maxSize) {
				 mature = true;
			 }
			 return mature;
		 }
		 
		 /**
		  * Gets the name, size, and maxSize of this
		  * plant, as a String, formatted as in this 
		  * example "beans (5,7)"
		  */
		 public String toString() {
			 return String.format("%s (%s, %s)", name, size, maxSize);
		 }
}
