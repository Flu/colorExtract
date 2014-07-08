import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class colorExtract extends PApplet {

/*
Image - random color extraction
by Adrian Fluturel
8th of July 2014
Made with Processing and PDE
*/

PImage inputImg;
int[] randomColors = new int[4];
String inputPath;

public void setup() {
  size(400, 400);
  selectInput("", "inputFile");
}

public void draw() {
  background(255);
  noStroke();
  
  fill(randomColors[0]);
  rect(0, 0, 200, 200);
  
  fill(randomColors[1]);
  rect(200,0,200,200);
  
  fill(randomColors[2]);
  rect(0,200,200,200);
  
  fill(randomColors[3]);
  rect(200,200,200,200);
}

public void inputFile(File inputFile) {
  if (inputFile == null) {
    println("Window was closed or user hit cancel.");
  } else {
    inputPath = inputFile.getAbsolutePath();
    inputImg = loadImage(inputPath);
    for (byte i = 0; i < 4; i++) {
      randomColors[i] = inputImg.get(PApplet.parseInt(random(0, inputImg.width)), PApplet.parseInt(random(0, inputImg.height)));
    }
  }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "colorExtract" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
