// Inheritance is one of the four principles of Object-Oriented Programming.

Particle p;
NervousBall  b;

void setup() {
  size(800, 600);
  background(0);
  b = new NervousBall(5);
  //p = new Particle();
}

void draw() {
  b.update();
  b.display();
  //p.update();
  //p.showLocation();
}


//A nervous ball shakes when it moves
class NervousBall extends Ball {
  float nervousFactor;

  NervousBall(float nervousFactor) {
    super(width/2, 0, random(20, 50), color(255, 255, 0));
    this.nervousFactor = nervousFactor;
  }

  void display() {
    fill(col);
    circle(location.x + random(nervousFactor), location.y + random(nervousFactor), diameter);
  }
}


//"extends means that ball will inherit all public
//things from the Particle class.
//Particle is the Parent class, and ball is the child class.
//Particle is the super class, and Ball is the sub class.
class Ball extends Particle {
  float diameter;
  color col;

  Ball(float x, float y, float diameter, color col) {
    super(x, y);
    this.diameter = diameter;
    this.col = col;
  }

  void display() {
    fill(col);
    circle(location.x, location.y, diameter);
  }
}




// Simulates a particle moving under the force of gravity.
class Particle {
  PVector location;
  PVector velocity;
  PVector acceleration;

  /*
  Constructs a new particle at a specified location. The
   initial velocity and acceleration in the y-direction are random.
   There is no acceleration in the x-direction.
   */
  Particle(float x, float y) {
    location = new PVector(x, y);
    velocity = new PVector(random(-3, 3), random(-3, 3));
    acceleration = new PVector(0, random(0.1));
  }

  /*
  Constructs a new particle at a random location. The
   initial velocity and acceleration in the y-direction are random.
   There is no acceleration in the x-direction.
   */
  Particle() {
    this(random(width), random(height));
  }

  /*
  Updates the particle's position based on its velocity, and updates
   its velocity based on its acceleration. Then checks the edges and makes
   the particle "bounce" if it hits an edge.
   */
  void update() {
    location.add(velocity);
    velocity.add(acceleration);
    handleEdges();
  }


  void showLocation() {
    stroke(255, 255, 0);
    strokeWeight(3);
    point(location.x, location.y);
  }

  // Updates position and velocity if the particle hits an edge.
  void handleEdges() {
    if (location.x >= width) {
      location.x = width;
      velocity.x *= -1;
    } else if (location.x <= 0) {
      location.x = 0;
      velocity.x *= -1;
    }

    if (location.y >= height) {
      location.y = height;
      velocity.y *= -1;
    } else if (location.y <= 0) {
      location.y = 0;
      velocity.y *= -1;
    }
  }
}
