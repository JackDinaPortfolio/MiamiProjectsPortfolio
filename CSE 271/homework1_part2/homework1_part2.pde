Car a;

ArrayList<Car> car;

void setup(){
  size(800,600);
  
  car = new ArrayList<Car>();
  
  for (int i = 0; i < 42; i ++) {
    car.add(new Car()); 
  }
  
  a = new Car();
}

void draw() {
  background(255);
  for (Car a : car) {
    a.display();
    a.drive();
  }
}

class Car {
  int x;
  int y;
  color col1;
  color col2;
  color tires;
  boolean notContact;
  
  Car(int startX, int startY) {
    x = startX;
    y = startY;
    col1 = color(random(256), random(256), random(256));
    col2 = color(random(256), random(256), random(256));
    notContact = true;
  }
  
  Car(int startX, int startY, int num1, int num2, int num3, int twoNum1, int twoNum2, int twoNum3) {
    x = startX;
    y = startY;
    col1 = color(num1, num2, num3);
    col2 = color(twoNum1, twoNum2, twoNum3);
    notContact = true;
  }
  
  Car() {
    x = (int)random(height);
    y = (int)random(width);
    col1 = color(random(256), random(256), random(256));
    col2 = color(random(256), random(256), random(256));
    notContact = true;
  }
  
  void display(){
    fill(col1);
    rect(x,y,60,30,45,45,0,0);
    fill(0);
    circle(x+15,y+30,20);
    circle(x+45,y+30,20);
    fill(col2);
    triangle(x+15,y,x+45,y,x+30,y-15);
  }
  
  void drive() {
    checkEdges();
    if(notContact){
      x++;
    }
  }
  
  void checkEdges(){
    if(x ==(width - 60)){
      notContact = false;
    }
  }
}
