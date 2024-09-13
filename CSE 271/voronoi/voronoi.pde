ArrayList<Site> location;

void setup() {
  size(800,600);
  
  location = new ArrayList<Site>();
  
  for(int i = 0; i < 25; i++) {
      location.add(new Site());
  }
}

void draw() {
  modPixels();
  drawSite();
}

Site getNearestSite(ArrayList<Site> location, float x, float y) {
    Site nearest = location.get(0);
    for (int i = 0; i < location.size(); i++) {
        if (location.get(i).distFrom(x,y) < nearest.distFrom(x,y)) {
           nearest = location.get(i);
         }
    }
    return nearest;
}

void modPixels(){
  for (int x = 0; x < width; x++) {
     for (int y = 0; y < height; y++) {
       Site nearest = getNearestSite(location, x, y);
       color nearestCol = nearest.getColor();
       set(x,y, color(red(nearestCol), green(nearestCol), blue(nearestCol)));
     }
  }
  updatePixels();
}

void drawSite() {
    for( Site t : location) {
      fill(0);
      circle(t.getX(), t.getY(), 5); 
    }
}

void mouseClicked(){
  if (mouseButton == RIGHT) {
    location.add(new Site(mouseX, mouseY));
  }
}

void mousePressed() {
  if(!(location.size() == 1)){
    if (mouseButton == LEFT) {
      Site nearest = getNearestSite(location, mouseX, mouseY);
      location.remove(nearest);
    }
  }
}
