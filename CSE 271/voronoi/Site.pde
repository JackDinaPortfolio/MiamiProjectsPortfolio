//A Site has a location and color,
// and may or may not be highlighted

class Site {
  
  //Instance Variables
  private float siteX;
  private float siteY;
  private color col;
  private boolean highlighted;
  
  //constructor
  public Site(float x, float y, color col) {
    siteX = x;
    siteY = y;
    this.col = col;
    highlighted = false;
  }
  
  public Site(float x, float y) {
   this(x, y, color(random(256), random(256), random(256))); 
  }
  
  public Site(Site original) {
   this(original.siteX, original.siteY, original.col); 
  }
  
  public Site() {
   this(random(width),random(height),color(random(256), random(256), random(256))); 
  }
  
  //methods
  public float getX() {
   return siteX; 
  }
  
  public float getY() {
   return siteY; 
  }
  
  public int getColor() {
   return col; 
  }
  
  public float distFrom(float num1, float num2) {
   return dist(siteX, siteY, num1, num2); 
  }
  
  public boolean isHighlighted() {
    return highlighted;
  }
  
  public void setHighlight(boolean swap) {
   highlighted = swap; 
  }
  
  public void setX(float num) {
    siteX = num;
  }
  
  public void setY(float num) {
    siteY = num;
  }
  
  void setColor(color col) {
   this.col = col; 
  }
  
  public String toString() {
    return "(" + siteX + ", " + siteY + "), r=" + red(col) + ", g=" + green(col) + ", b=" + blue(col) + ", not highlighted"; 
  } 
}
