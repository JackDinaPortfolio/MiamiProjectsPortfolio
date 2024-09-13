public class ConnectFour {
  private Cell[][] cells;
  private boolean inProgress = true;
  private int moveCount;
  private int player = 2;
  private int row;
  private int columns;
  
  public ConnectFour(int rows, int cols) {
    cols = cols+1;
    if (rows < 4 || cols < 4) {
       throw new IllegalArgumentException(); 
    }
    this.cells = new Cell[rows][cols];
    for (int i = 0; i < rows; i ++) {
      for (int j = 0; j < cols; j ++) {
        cells[i][j] = new Cell();
      }
    }
    row = rows;
    columns = cols;
  }
  
  public void updateCell(int row, int column, int status) {
    if (status != 0 && status != 1 && status != 2) {
         throw new IllegalArgumentException();
    }
    cells[row][column].setPlayer(status); 
  }
  
  public void display() {
    for (int row = 0; row < cells.length ; row++) {
      for (int col = 0; col < cells[0].length ; col++) {
        cells[row][col].display(100 * col,100 * row);
      }
    }
  }
  
  public void printRow(int row) {
    String answer = "";
    for (int col = 0; col < cells[0].length -1; col++) {
          answer += cells[row][col].getPlayer() + " ";
    }
    System.out.println(answer);
  }
  
  public void printColumn(int col) {
    for(int row = 0; row < cells.length; row++) {
      System.out.println(cells[row][col].getPlayer());
    }
  }
  
  public void printGrid() {
    String answer = "";
    for(int row = 0; row < cells.length; row++) {
       for (int col = 0; col < cells[0].length -1; col++) {
          answer += cells[row][col].getPlayer() + " ";
       }
       answer += "\n";
    }
    System.out.print(answer);
  }
  
  public void makeMove(int col) {
    if(inProgress == true) {
      boolean changeMade = false;
      int mover = row - 1;
      if (player == 2) {
        player = 1;
        cells[0][col].setPlayerTurn(player);
      } else if( player == 1) {
        player = 2; 
        cells[0][col].setPlayerTurn(player);
      }
    
      while(changeMade == false) {
        if(mover == -1) {
           System.out.println("column " + col + " is full");
           changeMade = true;
           if (player == 2) {
            player = 1;
           } else if( player == 1) {
            player = 2; 
           }
        } 
        if (mover != -1) {
           if(cells[mover][col].getPlayer() == 0) {
            updateCell(mover,col,player);
            System.out.println("player " + player + " at " + mover + " " + col);
            checkHWin(mover, col, player);
            checkVWin(mover, col, player);
            checkDNEWin(mover, col, player);
            checkDNWWin(mover, col, player);
            moveCount++;
            if(inProgress == true && moveCount == row*(columns-1)) {
              inProgress = false;
              System.out.println("TIE GAME!!");
            }
            changeMade = true;
           } else {
            mover--; 
           }
        }
      }
    } else {
      System.out.println("GAME IS OVER!");
    }
  }
  
  public void checkHWin(int row, int col, int player) {
    int sameCounter = 1;
    for(int i = col+1; i < columns; i++) {
      int tempPlayer = cells[row][i].getPlayer();
      if (tempPlayer != player) {
        break; 
      } else if(tempPlayer == player) {
       sameCounter++;
      }
      if(sameCounter == 4) {
        System.out.println("PLAYER " + player + " WINS!!");
        inProgress = false;
        break;
      }
    }
    
    for(int i = col-1; i >= 0; i-- ){
      int tempPlayer = cells[row][i].getPlayer();
      if (tempPlayer != player) {
        break; 
      } else if(tempPlayer == player) {
       sameCounter++;
      }
      if(sameCounter == 4) {
        System.out.println("PLAYER " + player + " WINS!!");
        inProgress = false;
        break;
      }
    } 
  }
  
  public void checkVWin(int rows, int col, int player) {
    int sameCounter = 1;
    
    for(int i = rows+1; i < row; i++) {
      int tempPlayer = cells[i][col].getPlayer();
      if (tempPlayer != player) {
        break; 
      } else if(tempPlayer == player) {
       sameCounter++;
      }
      if(sameCounter == 4) {
        System.out.println("PLAYER " + player + " WINS!!");
        inProgress = false;
        break;
      }
    }
  }
  
  public void checkDNEWin(int rows, int col, int player) {
    int sameCounter = 1;
    int neIterations = 1;
    int swIterations = 1;
    
    while(rows <= row|| col >= columns){
      try {
        int tempPlayer = cells[rows - neIterations][col + neIterations].getPlayer();
        if (tempPlayer != player) {
          break; 
        } else if(tempPlayer == player) {
         sameCounter++;
         neIterations++;
        }
        if(sameCounter == 4) {
          System.out.println("PLAYER " + player + " WINS!!");
          inProgress = false;
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        break; 
      }
    }
    
    while(rows <= row|| col >= columns){
      try{
        int tempPlayer = cells[rows + swIterations][col - swIterations].getPlayer();
        if (tempPlayer != player) {
          break; 
        } else if(tempPlayer == player) {
         sameCounter++;
         swIterations++;
        }
        if(sameCounter == 4) {
          System.out.println("PLAYER " + player + " WINS!!");
          inProgress = false;
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        break; 
      }
    }
  }
  
  public void checkDNWWin(int rows, int col, int player) {
    int sameCounter = 1;
    int nwIterations = 1;
    int seIterations = 1;
    
    while(rows <= row|| col >= columns){
      try {
        int tempPlayer = cells[rows - nwIterations][col - nwIterations].getPlayer();
        if (tempPlayer != player) {
          break; 
        } else if(tempPlayer == player) {
         sameCounter++;
         nwIterations++;
        }
        if(sameCounter == 4) {
          System.out.println("PLAYER " + player + " WINS!!");
          inProgress = false;
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        break; 
      }
    }
    
    while(rows <= row|| col >= columns){
      try{
        int tempPlayer = cells[rows + seIterations][col + seIterations].getPlayer();
        if (tempPlayer != player) {
          break; 
        } else if(tempPlayer == player) {
         sameCounter++;
         seIterations++;
        }
        if(sameCounter == 4) {
          System.out.println("PLAYER " + player + " WINS!!");
          inProgress = false;
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        break; 
      }
    }
  }
  
  public void initializeGame() {
    for (int i = 0; i < row; i ++) {
      for (int j = 0; j < columns; j ++) {
        cells[i][j] = new Cell();
      }
    }
    inProgress = true;
    moveCount = 0;
    player = 2;
  }
  
  public void highlight(int col) {
    if (inProgress == true) {
      cells[0][col].setPlayerTurn(player);
      for(int i = 0; i < columns; i++) {
        if(col == i) {
         cells[0][i].setRingTrue();
        } else {
         cells[0][i].setRingFalse(); 
        }
      }
    }
  }
}
