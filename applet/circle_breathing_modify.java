import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class circle_breathing_modify extends PApplet {

//breath mybreath;
ArrayList arraybreath;
float angle;
float radius = 50;
int newCircle = 250;
float[] xPos = new float[newCircle];
float[] yPos = new float[newCircle];
PImage img;
PImage img2;


public void setup() {
  size(800, 600);
  smooth();
  img = loadImage("data/pattern.jpg");
  img = loadImage("data/pattern2.jpg");
  arraybreath = new ArrayList();
  arraybreath.add(new breath(random(0, width), random(0, height)));
}


public void draw() {
  
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

public void mousePressed() {
  arraybreath.add(new breath(mouseX, mouseY));
}






class breath {
  float rad, rad2, rad3;
  float oscillation, oscillation2, oscillation3;
  float xPos, yPos;
//  float ySpeed;

  breath(float tempX, float tempY){
    xPos = tempX;
    yPos = tempY;

  }

  public void display() {
    rad = frameCount * 0.1f;
    oscillation = sin(rad); //sin of anything -1 and 1 
    float oscMapped = map(oscillation, -1, 1, 0, 0.6f);
    background(255);
    noStroke();
    fill(207, 255, 15,60);
    ellipse(xPos, yPos, 60*oscMapped, 60*oscMapped);

    rad2 = frameCount * 0.05f;
    oscillation2 = sin(rad2);
    float oscMapped2 = map(oscillation2, -1, 1, 0, 0.8f);
    noStroke();
    fill(255, 100, 23,60);
    ellipse(xPos, yPos, 60*oscMapped2, 60*oscMapped2);

    rad3 = frameCount * 0.05f;
    oscillation3 = sin(rad3);
    float oscMapped3 = map(oscillation3, -1, 1, 0, 1);
    noStroke();
    fill(255, 15, 111, 60);
    ellipse(xPos, yPos, 100*oscMapped2, 100*oscMapped2);

    //solid circle   
    fill(random(0,256), random(0,256), random(0,256),80);
    ellipse(xPos, yPos, 15, 15);
  }
  
  }

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "circle_breathing_modify" });
  }
}
