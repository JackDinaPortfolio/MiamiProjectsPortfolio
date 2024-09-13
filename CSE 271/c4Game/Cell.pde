public class Cell {
  private int player;
  private boolean winningCell;
  private boolean ring;
  private int playerTurn;
  
  public Cell() {
  }
  
  public void setRingTrue() {
    ring = true;
  }
  
  public void setRingFalse() {
   ring = false; 
  }
  
  public void setWinner() {
    winningCell = true;
  }
  
  public void setPlayer(int col) {
      if (col != 0 && col != 1 && col != 2) {
         throw new IllegalArgumentException();
      }
      this.player = col;
  }
  
  public void setPlayerTurn(int turn) {
   playerTurn = turn; 
  }
  
  public int getPlayer() {
    return player;
  }
  
  public void display(float x, float y) {
    strokeWeight(1);
    stroke(0);
    if (winningCell == true) {
      fill(0,255,0); 
    } else {
      fill(200,200,0);
    }
    square(x, y, 100);
    if (player == 0) {
      fill(100);
    } else if (player == 1) {
      fill(255, 0, 0); 
    } else if (player == 2) {
      fill(0, 0, 0); 
    }
    circle(x + 50,y + 50,90);
    
    if(ring == true) {
     strokeWeight(5);
     if(playerTurn == 2) {
       stroke(255,0,0);
     } else if (playerTurn == 1) {
       stroke(0); 
     }
     circle(x + 50, y+50, 90);
    }
  }
}
