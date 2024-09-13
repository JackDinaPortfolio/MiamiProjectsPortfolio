import java.util.Scanner;

public class GardenManager {

	private static Scanner in;
	
	// Here is a global Garden variable to be used throughout
	// this GardenManager class.
	// ***** USE THIS VARIABLE.
	private static Garden garden;

	public static void main(String[] args) {

		in = new Scanner(System.in);

		System.out.println("Welcome to the Garden Manager.");
		System.out.println("Let's get started...");

		System.out.print("How many rows will be in your garden? ");
		int rows = in.nextInt();
		System.out.print("How many plants in each row? ");
		int cols = in.nextInt();
		
		garden = new Garden(rows, cols);
		
		System.out.println("Here is your garden...\n" + garden);
		
		boolean quit = false;

		while (!quit) {
			quit = menu();
		}

		System.out.println("Goodbye!");

	}

	public static boolean menu() {
		String[] options = { "Show garden", "Plant one plant",
				"Plant many plants", "Harvest mature plants",
				"Show harvested plants", "Show what's planted",
				"Make time pass", "Quit" };

		System.out.println("-------------------------------");
		for (int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ". " + options[i]);
		}

		System.out.print("Enter your choice: ");
		int optionNumber = in.nextInt();
		String option = options[optionNumber - 1];
		
		if ("Plant one plant".equals(option)) {
			addOnePlant();
		} else if ("Plant many plants".equals(option)) {
			addManyPlants();
		} else if ("Show garden".equals(option)) {
			System.out.println(garden);
		} else if ("Harvest mature plants".equals(option)) {
			garden.harvestMaturePlants();
		} else if ("Show harvested plants".equals(option)) {
			System.out.println(garden.getHarvestedPlantsString());
		}
		else if ("Show what's planted".equals(option)) {
			System.out.println(garden.getPlantCount() + " plants: \n" + garden.getPlantedPlantsString());
		} else if ("Make time pass".equals(option)) {
			makeTimePass();
		}
		return ("Quit".equals(option));
	}

	// Complete this method
	public static void addOnePlant() {
		System.out.print("Enter one-word plant type: ");
		String type = in.next();
		System.out.print("Enter start size (0-9): ");
		int size = in.nextInt();
		System.out.print("Enter max size (0-9): ");
		int maxSize = in.nextInt();
		System.out.print("Enter row and column: ");
		int row = in.nextInt();
		int col = in.nextInt();
		
		Plant plant = new Plant(type, size, maxSize);
		garden.addPlant(plant, row, col);

	}

	// Complete this method
	public static void addManyPlants() {
		System.out.println("This will plant lots of the same "
				+ "type of plant, in the first spots available.");
		System.out.print("Enter one-word plant type: ");
		String type = in.next();
		System.out.print("Enter start size (0-9): ");
		int size = in.nextInt();
		System.out.print("Enter max size (0-9): ");
		int maxSize = in.nextInt();

		System.out.print("How many do you want to plant? ");
		int count = in.nextInt();
		
		Plant plant = new Plant(type, size, maxSize);
		for(int i = 0; i < count; i ++) {
			garden.addPlant(plant);
		}

	}

	// Complete this method
	public static void makeTimePass() {
		System.out.print("How many units of time should elapse? ");
		int time = in.nextInt();
		
		for(int i = 0; i < time; i ++) {
			garden.tick();
		}

	}

}