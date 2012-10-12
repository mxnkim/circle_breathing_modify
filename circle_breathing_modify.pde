....

//breath mybreath;
ArrayList arraybreath;
float angle;
float radius = 50;
int newCircle = 250;
float[] xPos = new float[newCircle];
float[] yPos = new float[newCircle];
PImage img;
PImage img2;


void setup() {
  size(800, 600);
  smooth();
  img = loadImage("data/pattern.jpg");
  img = loadImage("data/pattern2.jpg");
  arraybreath = new ArrayList();
  arraybreath.add(new breath(random(0, width), random(0, height)));
}


void draw() {
  
//  background(img);
  
  for (int i = 0; i < arraybreath.size(); i++) {
    breath mybreath = (breath) arraybreath.get(i);
    mybreath.display();
  }

//  for (int i = 0; i < newCircle; i++) {
//
//    translate(width/2, height/2);
//    angle+=0.05;
//    xPos[i] = cos(angle) * radius;
//    yPos[i] = sin(angle) * radius;
//
//    //smallCircle
//    fill(0);
//    ellipse(xPos[i], yPos[i], 10, 10);
//    radius+=.01;
//  }
}

void mousePressed() {
  arraybreath.add(new breath(mouseX, mouseY));
}






