//Cell class, one Cell is a single location on a connect 4 board and has a x y location, 
//a player associated with it (default is 0) 
class Cell {
  color PLAYER_1_COLOR = color(255, 0, 0);
  color PLAYER_2_COLOR = color(0);
  color BACK_COLOR = color(100);

  int player;
  boolean winning;

  // Constructs an initally empty cell
  Cell() {
    this.player = 0;
    this.winning = false;
  }

  // Sets this cell's player.
  void setPlayer(int player) {
    this.player = player;
  }
  
  // Set whether this cell is one of the winning
  // cells.
  void setWinning() {
    this.winning = true;
  }

  // gets the player in this cell
  int getPlayer() {
    return player;
  }

  // displays this cell at the specified location
  void display(float x, float y) {
    stroke(0);
    strokeWeight(1);

    fill(200, 200, 0);
    if (this.winning) {
      fill(0, 255, 0);
    }
    square(x, y, CELL_WIDTH);
    if (player == 0) {
      fill(BACK_COLOR);
    } else if (player == 1) {
      fill(PLAYER_1_COLOR);
    } else {
      fill(PLAYER_2_COLOR);
    }
    noStroke();
    circle(x + CELL_WIDTH/2, y + CELL_WIDTH/2, CELL_WIDTH * 0.9);
  }
}//end Cell class
