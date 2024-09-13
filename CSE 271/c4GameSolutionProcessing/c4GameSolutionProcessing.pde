ConnectFour cf;

// We set these here so that the sketch will be the right
// size. Because of how Processing works, all classes have
// access to these constants. So you can (and should) use
// them in the other classes.
final int ROWS = 6;
final int COLS = 7;
final int CELL_WIDTH = 100;

void settings() {
  size(COLS * CELL_WIDTH, ROWS * CELL_WIDTH);
}

void setup() {  
  cf = new ConnectFour(ROWS, COLS);
}

void mousePressed() {
  int whichCol = int(mouseX / CELL_WIDTH);
  cf.makeMove(whichCol);
}

void keyPressed() {
  if (key == 'R') {
    cf.initializeGame();
  }
}

void draw() {
  // Redraw the board
  cf.display();

  // The rest of this code just displays a ring
  // at the top of the column where the player's next move
  // will be played. BUT...
  // Don't draw a ring if the game is over.
  // Don't draw a ring in a column that is full.
  if (cf.isInProgress()) {
    // ...so that we can draw a circle of that color.
    int whichCol = int(mouseX / CELL_WIDTH);
    if (!cf.isFull(whichCol)) {
      // Where should the center of the circle be?
      int x = whichCol * CELL_WIDTH + CELL_WIDTH/2;

      // Get the color of the current player...
      stroke(cf.getPlayerColor());
      noFill();
      strokeWeight(10);
      circle(x, CELL_WIDTH/2, 0.9 * CELL_WIDTH);
    }
  }
}
