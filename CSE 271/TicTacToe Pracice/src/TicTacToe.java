//Demos basics of having a 2d array as an instance
//variable/
public class TicTacToe {
	private char[][] grid;
	
	/**
	 * Constructs a new tic tac toe game, filling
	 * the array with '-' symbols.
	 */
	public TicTacToe() {
		this.grid = new char[3][3];
		
		//fill it with - symbols
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				grid[row][col] = '-';
			}
		}
	}
	
	//Plays an X at a specified row and column:
	//t.playX(1,2); //put an x at row1 , column 2
	public void playX(int row, int col) {
		grid[row][col] = 'X';
	}
	
	public String toString() {
		String result = "";
		
		for(int row = 0; row < grid.length; row++) {
			//Starts a new row
			for(int col = 0; col < grid[0].length; col++) {
				result += grid[row][col];
			}
			//end of row: add a linefeed
			result +="\n";
		}
		
		return result;
	}
}
