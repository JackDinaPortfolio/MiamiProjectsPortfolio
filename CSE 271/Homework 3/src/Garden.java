import java.util.ArrayList;

/**
 * Defines a simple garden that can store Plant objects. 
 * The plants grow (the tick() method makes time elapse,
 * with all plants growing as appropriate. Fully mature 
 * plants can be harvested.
 * @author Jack Dina
 * @version 1.0
 */
public class Garden {
	private Plant[][] garden;
	ArrayList<Plant> harvestedPlants = new ArrayList<Plant>();
;
	/**
	 * Constructs a garden with specified size,
	 * with no plants.
	 * @param rows the number or rows in the garden
	 * @param columns the number of columns in the garden
	 */
	public Garden (int rows, int columns) {
		this.garden = new Plant[rows][columns];
		
	}
	
	/**
	 * Plants a plant in the first available location,
	 * if there is one.
	 * @param plant A plant object
	 */
	public void addPlant(Plant plant) {
		for (int row = 0; row < garden.length; row++) {
			for(int col = 0; col < garden[0].length; col++) {
				if(garden[row][col] == null) {
					garden[row][col] = plant;
					return;
				}
			}
		}
	}
	
	/**
	 * Plants a plant in the specified location
	 * @param plant A plant object
	 * @param row the row you want the plant to be in
	 * @param col the column you want the plant to be in
	 */
	public void addPlant(Plant plant, int row, int col) {
		garden[row][col] = plant;
	}
	
	/**
	 * Gets a String list of all plants that have
	 * been harvested
	 */
	public String getHarvestedPlantsString() {
		String answer = "";
		for(Plant t : harvestedPlants) {
			answer += t.toString() + "\n";
			//System.out.print(harvestedPlants + "\n");
		}
		return answer;
	}
	
	/**
	 * Gets the plant at a particular location in the
	 * garden (null if there is no plant in that location)
	 */
	public Plant getPlant(int row, int col) {
		if (garden[row][col] == null) {
			return null;
		} else {
			return garden[row][col];
		}
	}
	
	/**
	 * Gets a count of plants in this garden
	 */
	public int getPlantCount() {
		int count = 0;
		for (int row = 0; row < garden.length; row++) {
			for(int col = 0; col < garden[0].length; col++) {
				if(garden[row][col] != null) {
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * Gets a String list of all plants that are in 
	 * the garden (not yet harvested), including the 
	 * row and column of each plant.
	 */
	public String getPlantedPlantsString() {
		String answer = "";
		for (int row = 0; row < garden.length; row++) {
			for(int col = 0; col < garden[0].length; col++) {
				if(garden[row][col] != null) {
					answer += "[" + row + "][" + col + "] " + garden[row][col] + " \n";
				}
			}
		}
		return answer;
	}
	
	/**
	 * Collects all plants that have reached their 
	 * maximum size, adding them to the harvest.
	 */
	public void harvestMaturePlants() {
		for (int row = 0; row < garden.length; row++) {
			for(int col = 0; col < garden[0].length; col++) {
				if(garden[row][col] != null) {
					if (garden[row][col].isMature()) {
						harvestedPlants.add(garden[row][col]);
						garden[row][col] = null;
					}
				}
			}
		}
	}
	
	/**
	 * Advances time by one unit, causing all 
	 * plants to grow a little.
	 */
	public void tick() {
		for (int row = 0; row < garden.length; row++) {
			for(int col = 0; col < garden[0].length; col++) {
				if(garden[row][col] != null) {
					garden[row][col].grow();
				}
			}
		}
	}
	
	/**
	 * Returns a String representation of the garden,
	 * with 2 characters and a space used for each location
	 * in the garden.
	 */
	public String toString() {
		String answer = "";
		for (int row = 0; row < garden.length; row++) {
			for(int col = 0; col < garden[0].length; col++) {
				if(garden[row][col] != null) {
					answer += garden[row][col].getName().substring(0,1) + garden[row][col].getSize();
				} else if(garden[row][col] == null) {
					answer += "--";
				}
				answer += " ";
			}
			answer +="\n";
		}
		return answer;
	}
}
