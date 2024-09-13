class ConnectFour {
  int player;
  int moves;
  boolean inProgress;
  Cell[][] cells;

  // Constructs a new game of connect four with the specified
  // number of rows and columns.
  ConnectFour(int rows, int cols) {
    if (rows < 4 || cols < 4) {
      throw new IllegalArgumentException("rows, cols must be >= 4");
    }
    cells = new Cell[rows][cols];
    initializeGame();
  }

  // Sets everything up for the start of the game.
  void initializeGame() {
    // Create the cells
    for (int row = 0; row < cells.length; row++) {
      for (int cell = 0; cell < cells[0].length; cell++) {
        cells[row][cell] = new Cell();
      }
    }
    player = 1;
    moves = 0;
    inProgress = true;
  }
  
  // returns whether the game is in progress
  boolean isInProgress() {
    return inProgress;
  }
  
  // returns whether a specified column is full
  boolean isFull(int col) {
    return nextSpot(col) == -1;
  }

  // makes the move in the specified column,
  // but only if the game is in progress.
  void makeMove(int col) {
    // Exit method if game is in progres.
    if (!inProgress) {
      System.out.println("GAME IS OVER!");
      return;
    }

    int row = nextSpot(col);

    // Exit if column is full.
    if (row == -1) {
      System.out.printf("column %d is full%n", col);
      return;
    }
    
    // Otherwise, actually make the move
    updateCell(row, col, player);
    System.out.printf("player %d at %d %d%n", player, row, col);
    player = 3 - player;
    moves++;

    display();
    checkWin(row, col);
  }

  // Places the specified player's piece at the specified row and column
  void updateCell(int row, int col, int player) {
    cells[row][col].setPlayer(player);
  }

  // Draws all the cells.
  void display() {
    for (int row = 0; row < cells.length; row++) {
      for (int cell = 0; cell < cells[0].length; cell++) {
        cells[row][cell].display(cell * CELL_WIDTH, row * CELL_WIDTH);
      }
    }
  }

  /** Some useful printing methods for debugging purposes. **/
  // Print the specified row
  void printRow(int row) {
    for (int i = 0; i < cells[row].length; i++) {
      print(cells[row][i].getPlayer() + " ");
    }
    System.out.println();
  }

  // Print the specified columnb
  void printColumn(int col) {
    for (int i = 0; i < cells.length; i++) {
      System.out.println(cells[i][col].getPlayer());
    }
  }

  // Print the entire grid
  void printGrid() {
    for (int row = 0; row < cells.length; row++) {
      printRow(row);
    }
  }

  // Return the number of rows in the game
  int getRows() {
    return cells.length;
  }

  // Return the number of columns in the game
  int getCols() {
    return cells[0].length;
  }

  // For a given column, returns the index where
  // the next checker should go (the highest index
  // where the player is 0), or returns -1 if the 
  // column is full.
  int nextSpot(int col) {
    int spot = cells.length - 1;

    while (spot >= 0) {
      if (cells[spot][col].getPlayer() == 0) {
        return spot;
      }
      spot--;
    }

    return -1;
  }

  // Returns the color of the current player. Useful
  // for when c4Game needs to draw the correct color
  // for the current player.
  color getPlayerColor() {
    Cell temp = new Cell();
    if (player == 1) return temp.PLAYER_1_COLOR;
    else return temp.PLAYER_2_COLOR;
  }  

  // ********************* BEGIN WIN CHECKING
  void checkWin(int row, int col) {
    if (inProgress) rowWin(row, col);
    if (inProgress) colWin(row, col);
    if (inProgress) nwseWin(row, col);
    if (inProgress) swneWin(row, col);  

    if (!inProgress) {
      System.out.printf("PLAYER %d WINS!!%n", 2 - moves % 2);
    }

    if (inProgress && moves == getRows() * getCols()) {
      System.out.println("TIE GAME");
      inProgress = false;
    }
  }

  // Check for a diagonal win from northwest to southeast
  void nwseWin(int row, int col) {
    if (southeastWall(row, col) - northwestWall(row, col) + 1 >= 4) {
      int firstCol = northwestWall(row, col);
      int firstRow = row - (col - firstCol);
      for (int i = 0; i < 4; i++) {
        cells[firstRow + i][firstCol + i].setWinning();
      }
      display();
      inProgress = false;
    }
  }

  // Check for a diagonal win from southwest to northeast
  void swneWin(int row, int col) {
    if (northeastWall(row, col) - southwestWall(row, col) + 1 >= 4) {
      int firstCol = southwestWall(row, col);
      int firstRow = row + (col - firstCol);
      for (int i = 0; i < 4; i++) {
        cells[firstRow - i][firstCol + i].setWinning();
      }
      display();
      inProgress = false;
    }
  }

  // Check for a win in the specified column
  void colWin(int row, int col) {
    if (southWall(row, col) - northWall(row, col) + 1 >= 4) {
      int firstRow = northWall(row, col);
      for (int i = 0; i < 4; i++) {
        cells[firstRow + i][col].setWinning();
      }
      display();
      inProgress = false;
    }
  }

  // Check for a win in the specified row
  void rowWin(int row, int col) {
    if (eastWall(row, col) - westWall(row, col) + 1 >= 4) {
      int firstCol = westWall(row, col);
      for (int i = 0; i < 4; i++) {
        cells[row][firstCol + i].setWinning();
      }
      display();
      inProgress = false;
    }
  }


  // probes left of the given location looking
  // for colors that match the current cell.
  // Stops when it finds a cell that doesn't match.
  // Returns the leftmost column (which could be
  // the given column if the next cell to the left
  // is the wrong color).
  int westWall(int row, int col) {
    int pl = cells[row][col].getPlayer();

    while (col > 0 && cells[row][col - 1].getPlayer() == pl) {
      col--;
    }

    return col;
  }

  int eastWall(int row, int col) {
    int pl = cells[row][col].getPlayer();

    while (col <  getCols() - 1 && cells[row][col + 1].getPlayer() == pl) {
      col++;
    }
    return col;
  }

  int southWall(int row, int col) {
    int pl = cells[row][col].getPlayer();

    while (row < getRows() - 1 && cells[row + 1][col].getPlayer() == pl) {
      row++;
    }
    return row;
  } 

  // returns northmost wall as a row
  int northWall(int row, int col) {
    int pl = cells[row][col].getPlayer();

    while (row > 0 && cells[row - 1][col].getPlayer() == pl) {
      row--;
    }
    return row;
  } 

  // returns northwest most wall as a COLUMN
  int northwestWall(int row, int col) {
    int pl = cells[row][col].getPlayer();

    while (row > 0 && col > 0 && cells[row - 1][col - 1].getPlayer() == pl) {
      row--;
      col--;
    }
    return col;
  } 

  // returns southeast most wall as a COLUMN
  int southeastWall(int row, int col) {
    int pl = cells[row][col].getPlayer();

    while (row < getRows() - 1 && col < getCols() - 1 && cells[row + 1][col + 1].getPlayer() == pl) {
      row++;
      col++;
    }
    return col;
  }

  // returns northeast most wall as a COLUMN
  int northeastWall(int row, int col) {
    int pl = cells[row][col].getPlayer();

    while (row > 0 && col < getCols() - 1 && cells[row - 1][col + 1].getPlayer() == pl) {
      row--;
      col++;
    }
    return col;
  } 

  // returns southwest most wall as a COLUMN
  int southwestWall(int row, int col) {
    int pl = cells[row][col].getPlayer();

    while (row < getRows() - 1 && col > 0 && cells[row + 1][col - 1].getPlayer() == pl) {
      row++;
      col--;
    }
    return col;
  }
  // ********************** END WIN CHECKING
}
