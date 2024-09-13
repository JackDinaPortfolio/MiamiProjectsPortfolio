// A brief review of finding the minimum value
//in an array.
void setup() {
 
    /*int[] data = {-17,2, 15, 8, 11,-300};
    
    //computes minimum value
    int smallestSoFar = Integer.MAX_VALUE;
    for (int num : data) {
      if (num < smallestSoFar) {
         smallestSoFar = num;
      }
      println(smallestSoFar);
    }*/
    minVariation();
}

//What if we also needed to know Where the min
//was located.
void minVariation () {
  int[] data = {-17,2, 15, 8, 11,-300};
    
      //computes minimum value
      int smallestSoFar = Integer.MAX_VALUE;
      int indexOfSmallest = -1;
      
      for (int i = 0; i < data.length; i ++) {
        if (data[i] < smallestSoFar) {
           smallestSoFar = data[i];
           indexOfSmallest = i;
        }
    }
    println("smallest", smallestSoFar);
    println("index of smallest", indexOfSmallest);
}
