void setup() {
   size(800, 600);
   
   for (int x = 0; x < width; x++) {
     for (int y = 0; y < height; y++) {
       
         float d = dist(x, y, 0, 0);
       
         set(x, y, color(0, 0, 255-d)); 
     }
   }
   
   //do this after you are ALL done setting pixels
   updatePixels();
}
