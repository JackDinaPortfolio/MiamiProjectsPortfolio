ArrayList<Tree> forest;

Tree t1, t2;

void setup() {
  size(800, 600);
  background(0);
  forest = new ArrayList<Tree>();
  
  for (int i = 0; i < 10; i++) {
    forest.add(new Tree());
  }
  
  //drawScenery();

  /*t1 = new Tree();
  t2 = new Tree();

  t1.show();
  t2.show();*/
  println(tallestHeight(forest));
  for (Tree t : forest) {
    print(t.trunkHeight + " "); 
  }
  
  doubleHeightOfTallestTree(forest);
  
}

//Makes the tallest tree double in height
void doubleHeightOfTallestTree(ArrayList<Tree> myTrees) {
  
  float tallestTree = Float.MIN_VALUE;
  int indexOfTallestTree = -1;
  
  for(int i = 0; i < myTrees.size(); i ++){
    if (myTrees.get(i).trunkHeight > tallestTree) {
      tallestTree = myTrees.get(i).trunkHeight;
      indexOfTallestTree = i;
    }
  }
  
  //Once you know the index, how do you make that tree grow?
  myTrees.get(indexOfTallestTree).trunkHeight *= 5;
  
  drawForest(); //redraw all trees 
}

//computes the highest of the tallest tree
//in an arraylist
float tallestHeight(ArrayList<Tree> myTrees) {
    float tallest = Float.MIN_VALUE;
    for (Tree t: myTrees) {
        if (t.trunkHeight > tallest) {
           tallest = t.trunkHeight;
         }
    }
    
    
    
    return tallest;
}

void draw() {
  drawScenery();
  for(Tree t : forest) {
   t.show(); 
  }
}

// Sky and beautiful green lawn.
void drawScenery() {
  fill(155, 201, 240); // blue sky
  rect(0, 0, width, height/3);
  fill(26, 95, 37); // green grass
  rect(0, height/3, width, 2 * height/3);
}

// Draws all the trees in the forest
void drawForest() {
  for (Tree t : forest) {
    t.show();
  }
}

// A tree class
class Tree {
  // trunkX, trunkY are coordinates of lower-left corner.
  //Remember in real java these should be private.
  float trunkX;
  float trunkY;
  float trunkHeight;
  color leafColor;

  // Constructs a tree with a random location and size.
  // The trunk will be brown and the leaves will be a random color.
  Tree() {
    trunkX = random(50, width - 50);
    trunkY = random(height/2, height - 10);
    trunkHeight = random(20, 150);
    leafColor = color(random(256), random(256), random(256), 220);
  }

  //grows the tree. This is inside the class because it's all about one tree.
  void grow() {
     trunkHeight++;
  }

  // Displays the tree
  void show() {
    float trunkWidth = trunkHeight/4;
    float leafDiam = trunkHeight;

    fill(165, 58, 37); // brown trunk
    rect(trunkX, trunkY - trunkHeight, trunkWidth, trunkHeight);
    fill(255, 255, 0);

    fill(leafColor);
    circle(trunkX + trunkWidth/2, trunkY - trunkHeight - leafDiam/2 + 5, leafDiam);
  }
  
  String toString() {
    
   return trunkX + ", " + trunkY + ", " + trunkHeight + ", "  + red(leafColor) + ", " +  green(leafColor) + ", " + blue(leafColor);
  }
}
