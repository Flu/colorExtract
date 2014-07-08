/*
Image - random color extraction
by Adrian Fluturel
8th of July 2014
Made with Processing and PDE
*/

PImage inputImg;
color[] randomColors = new color[4];
String inputPath;

void setup() {
  size(400, 400);
  selectInput("", "inputFile");
}

void draw() {
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

void inputFile(File inputFile) {
  if (inputFile == null) {
    println("Window was closed or user hit cancel.");
  } else {
    inputPath = inputFile.getAbsolutePath();
    inputImg = loadImage(inputPath);
    for (byte i = 0; i < 4; i++) {
      randomColors[i] = inputImg.get(int(random(0, inputImg.width)), int(random(0, inputImg.height)));
    }
  }
}

