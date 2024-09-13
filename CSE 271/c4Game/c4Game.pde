ConnectFour cf;

final int ROWS = 6;
final int COLS = 7;
final int CELL_WIDTH = 100;

void settings() {
  size(COLS * CELL_WIDTH, ROWS * CELL_WIDTH); 
}
  

void setup() {
 background (200, 200, 0);
 cf = new ConnectFour(ROWS, COLS);
 

}

void mousePressed() {
 int whichCol = int(mouseX / CELL_WIDTH);
 cf.makeMove(whichCol);
}

void mouseMoved() {
  int whichCol = int(mouseX / CELL_WIDTH);
 cf.highlight(whichCol);
}

void keyPressed()  {
 if(key == 'R') {
  cf.initializeGame(); 
 }
}

void draw() {
  cf.display();
}
