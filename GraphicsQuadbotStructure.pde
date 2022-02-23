void setup()
{
  size(640,640,P3D);
 background(0,0,0);
  ortho(-1,1,1,-1);
  resetMatrix();
  
}
color a = color(255,204,0);
color b = color(50,55,100);
color c= color (178,235,22);
color d= color(0,88,255);
color e=color(239,65,54);
color f=color(204,102,0);
color g = color(204,153,0);
color h = color(153,51,0);
color i = color(175,100,220);
final float[][] HEAD = {
  { 0.235, 0.697 },
  { -0.237, 0.694 },
  { -0.183, 0.231 },
  { 0.210, 0.228 }
};

final float[][] EYEBROW = {
  { 0.051, 0.637 },
  { 0.042, 0.597 },
  { 0.192, 0.594 },
  { 0.192, 0.628 }
};

final float[][] EYE = {
  { 0.042, 0.559 },
  { 0.160, 0.563 },
  { 0.148, 0.459 },
  { 0.045, 0.459 }
};

final float[][] EYEBALL = {
  { 0.089, 0.528 },
  { 0.089, 0.497 },
  { 0.133, 0.500 },
  { 0.133, 0.541 }
};

final float[][] NOSE = {
  { 0.010, 0.472 },
  { -0.024, 0.472 },
  { -0.046, 0.366 },
  { 0.048, 0.375 }
};

final float[][] LOWER_ANTENNA = {
  { 0.145, 0.837 },
  { 0.117, 0.675 },
  { 0.160, 0.684 },
  { 0.192, 0.831 }
};

final float[][] UPPER_ANTENNA = {
  { 0.167, 0.781 },
  { 0.345, 0.856 },
  { 0.301, 0.913 },
  { 0.163, 0.834 }
};

final float[][] TORSO = {
  { -0.065, 0.244 },
  { 0.085, 0.244 },
  { 0.198, -0.503 },
  { -0.240, -0.494 }
};

final float[][] UPPER_LEG = {
  { 0.148, -0.478 },
  { 0.042, -0.513 },
  { 0.132, -0.772 },
  { 0.245, -0.709 }
};

final float[][] LOWER_LEG = {
  { 0.145, -0.725 },
  { 0.214, -0.712 },
  { 0.260, -0.969 },
  { 0.095, -0.969 }
};

final float[][] UPPER_ARM = {
  { 0.107, -0.034 },
  { 0.092, 0.075 },
  { 0.410, 0.156 },
  { 0.398, 0.034 }
};

final float[][] LOWER_ARM = {
  { 0.351, 0.066 },
  { 0.404, 0.125 },
  { 0.579, -0.209 },
  { 0.464, -0.225 }
};
void draw()
{
 QuadBotAtRest();
 QuadBotJunior();
 QuadBotCloseUp();
 QuadBotThinking();
 QuadBotMiddle();
 QuadBotTerminatorMode();
 QuadBotClock();
 QuadBotJump();
 QuadBotCrash();
 
}
void QuadBotCrash()
{
  translate(0.66,-0.66);
  scale(0.3,0.3);
  rotate(radians(125));
  QuadBotFace();
  rotate(radians(180));
  LeftArm();
  rotate(radians(10));
  RightArm();
  rotate(radians(200));
  LeftLeg();
  rotate(radians(10));
  RightLeg();
  resetMatrix();
  translate(0.80,-0.80);
  scale(0.3,0.3);
  Torso();
}
void QuadBotJump()
{
  translate(0.0,-0.6);
  scale(0.3,0.3);
  QuadBotFace();
  Torso();
  LeftUpperArm();
  RightUpperArm();
  LeftUpperLeg();
  RightUpperLeg();
  resetMatrix();
  translate(0.0,-0.60);
  scale(0.3,0.3);
  rotate(radians(-30));
  ReflectedRightLowerArm();
  resetMatrix();
  translate(0.23,-0.61);
  scale(0.3,0.3);
  rotate(radians(-30));
  ReflectedRightLowerArm();
  resetMatrix();
  translate(0.11,-0.66);
  scale(0.3,0.3);
  rotate(radians(-30));
  RightLowerLeg();
  resetMatrix();
  translate(-0.11,-0.66);
  scale(0.3,0.3);
  rotate(radians(30));
  LeftLowerLeg();
  resetMatrix();  
}

void QuadBotClock()
{
   translate(-0.66,-0.66);
   scale(0.3,0.3);
  for(float i=30; i<=360.0; i+=30.0)
  {
    pushMatrix();
    rotate(radians((i-5)));
    QuadBotFace();
    popMatrix();
  }
  resetMatrix();
  
}
void QuadBotTerminatorMode()
{
  translate(0.66,0.0);
  scale(0.3,0.3);
  Head();
  LeftEye();
  RightEye();
  LeftEyeBall();
  RightEyeBall();
  Nose();
  LeftLowerAntenna();
  RightLowerAntenna();
  Torso();
  LeftLowerLeg();
  RightLowerLeg();
  LeftUpperLeg();
  RightUpperLeg();
  LeftUpperArm();
  RightUpperArm();
  resetMatrix();
  translate(0.72,0.0);
  scale(0.3,0.3);
  rotate(radians(20));
  LeftEyeBrow();
  resetMatrix();
  translate(0.6,0.0);
  scale(0.3,0.3);
  rotate(radians(-20));
  RightEyeBrow();
  resetMatrix();
  translate(0.66,0.0);
  scale(0.3,0.3);
  rotate(radians(105));
  resetMatrix();
  translate(0.96,0.26);
  scale(0.3,0.3);
  rotate(radians(105));
  LeftUpperAntenna();
  resetMatrix();
  translate(0.36,0.26);
  scale(0.3,0.3);
  rotate(radians(-105));
  RightUpperAntenna();
  resetMatrix();
  translate(0.6,0.005);
  scale(0.3*150/100,0.3*50/100);
  LeftLowerArm();
  resetMatrix();
  translate(0.72,0.005);
  scale(0.3*150/100,0.3*50/100);
  RightLowerArm();
  resetMatrix();
}
void QuadBotMiddle()
{
  translate(0.0,0.0);
  scale(0.3,0.3);
  QuadBot();
  resetMatrix();
}
void QuadBotThinking()
{
  translate(-0.66,0.0);
  rotate(radians(15));
  scale(0.3,0.3);
  QuadBotFace();
  resetMatrix();
  translate(-0.66,0.0);
  scale(0.3,0.3);
  Torso();
  LeftUpperArm();
  RightUpperArm();
  LeftLowerArm();
  LeftUpperLeg();
  RightUpperLeg();
  LeftLowerLeg();
  RightLowerLeg();
  resetMatrix();
  translate(-0.88,0.0);
  scale(0.3,0.3);
  rotate(radians(-150));
  RightLowerArm();
  resetMatrix();
}
void QuadBotCloseUp()
{
  translate(0.6,0.315);
  scale(0.3*225/100,0.3*255/100);
  QuadBotFace();
  resetMatrix();
}
void QuadBotJunior()
{
  translate(0.0,0.56);
  scale(0.3*50/100,0.2*80/100);
  QuadBot();
  resetMatrix();
}
void QuadBotAtRest()
{
  translate(-0.66,0.66);
  scale(0.3,0.3);
  rotate(radians(60));
   QuadBot();
   resetMatrix();
}
void QuadBotFace()
{
  Head();
  LeftEyeBrow();
  RightEyeBrow();
  LeftEye();
  RightEye();
  LeftEyeBall();
  RightEyeBall();
  Nose();
  LeftLowerAntenna();
  RightLowerAntenna();
  LeftUpperAntenna();
  RightUpperAntenna();
}
void QuadBot()
{
  Head();
  LeftEyeBrow();
  RightEyeBrow();
  LeftEye();
  RightEye();
  LeftEyeBall();
  RightEyeBall();
  Nose();
  LeftLowerAntenna();
  RightLowerAntenna();
  LeftUpperAntenna();
  RightUpperAntenna();
  Torso();
  LeftUpperLeg();
  RightUpperLeg();
  LeftLowerLeg();
  RightLowerLeg();
  RightUpperArm();
  LeftUpperArm();
  RightLowerArm();
  LeftLowerArm();}
void Head()
{
  
  beginShape(QUADS);
  fill(a);
  for(int i=0; i<4; i++)
  {
    vertex(HEAD[i][0],HEAD[i][1]);
  }
   endShape();
  
}
void LeftEyeBrow()
{
  beginShape(QUADS);
  fill(b);
  for(int i=0; i<4; i++)
  {
    vertex(EYEBROW[i][0],EYEBROW[i][1]);
  }
   endShape();
}
void RightEyeBrow()
{
  beginShape(QUADS);
  fill(b);
    for(int i=0; i<4; i++)
  {
    vertex((-1)*EYEBROW[i][0],EYEBROW[i][1]);
  }
   endShape();
}
void LeftEye()
{
  beginShape(QUADS);
  fill(c);
  for(int i=0; i<4; i++)
  {
    vertex(EYE[i][0],EYE[i][1]);
  }
   endShape();
}
void RightEye()
{
  beginShape(QUADS);
  fill(c);
  for(int i=0; i<4; i++)
  {
    vertex((-1)*EYE[i][0],EYE[i][1]);
  }
   endShape();
}
void LeftEyeBall()
{
  beginShape(QUADS);
  fill(d);
  for(int i=0; i<4; i++)
  {
    vertex(EYEBALL[i][0],EYEBALL[i][1]);
  }
   endShape();
}
void RightEyeBall()
{
  beginShape(QUADS);
  fill(d);
  for(int i=0; i<4; i++)
  {
    vertex((-1)*EYEBALL[i][0],EYEBALL[i][1]);
  }
   endShape();
}
void Nose()
{
  beginShape(QUADS);
  fill(e);
  for(int i=0; i<4; i++)
  {
    vertex(NOSE[i][0],NOSE[i][1]);
  } 
   endShape();
}
void LeftLowerAntenna()
{
  beginShape(QUADS);
  fill(f);
  for(int i=0; i<4; i++)
  {
    vertex(LOWER_ANTENNA[i][0],LOWER_ANTENNA[i][1]);
  } 
   endShape();
}
void RightLowerAntenna()
{
  beginShape(QUADS);
  fill(f);
  for(int i=0; i<4; i++)
  {
    vertex((-1)*LOWER_ANTENNA[i][0],LOWER_ANTENNA[i][1]);
  } 
   endShape();
}
void LeftUpperAntenna()
{
  beginShape(QUADS);
  fill(f);
  for(int i=0; i<4; i++)
  {
    vertex(UPPER_ANTENNA[i][0],UPPER_ANTENNA[i][1]);
  } 
   endShape();
}
void RightUpperAntenna()
{
  beginShape(QUADS);
  fill(f);
  for(int i=0; i<4; i++)
  {
    vertex((-1)*UPPER_ANTENNA[i][0],UPPER_ANTENNA[i][1]);
  } 
   endShape();
}
void Torso()
{
  beginShape(QUADS);
  fill(g);
  for(int i=0; i<4; i++)
  {
    vertex(TORSO[i][0],TORSO[i][1]);
  } 
   endShape();
}
void LeftUpperLeg()
{
  beginShape(QUADS);
  fill(h);
  for(int i=0; i<4; i++)
  {
    vertex(UPPER_LEG[i][0],UPPER_LEG[i][1]);
  } 
   endShape();
}
void RightUpperLeg()
{
  beginShape(QUADS);
  fill(h);
  for(int i=0; i<4; i++)
  {
    vertex((-1)*UPPER_LEG[i][0],UPPER_LEG[i][1]);
  } 
   endShape();
}
void RightLowerLeg()
{
  beginShape(QUADS);
  fill(h);
  for(int i=0; i<4; i++)
  {
    vertex((-1)*LOWER_LEG[i][0],LOWER_LEG[i][1]);
  } 
   endShape();
}
void LeftLowerLeg()
{
  beginShape(QUADS);
  fill(h);
  for(int i=0; i<4; i++)
  {
    vertex(LOWER_LEG[i][0],LOWER_LEG[i][1]);
  } 
   endShape();
}
void RightUpperArm()
{
  beginShape(QUADS);
  fill(i);
  for(int i=0; i<4; i++)
  {
    vertex((-1)*UPPER_ARM[i][0],UPPER_ARM[i][1]);
  } 
   endShape();
}
void LeftUpperArm()
{
  beginShape(QUADS);
  fill(i);
  for(int i=0; i<4; i++)
  {
    vertex(UPPER_ARM[i][0],UPPER_ARM[i][1]);
  } 
   endShape();
}
void RightLowerArm()
{
  beginShape(QUADS);
  fill(i);
  for(int i=0; i<4; i++)
  {
    vertex((-1)*LOWER_ARM[i][0],LOWER_ARM[i][1]);
  } 
   endShape();
}
void LeftLowerArm()
{
  beginShape(QUADS);
  fill(i);
  for(int i=0; i<4; i++)
  {
    vertex(LOWER_ARM[i][0],LOWER_ARM[i][1]);
  } 
  endShape();
}
void ReflectedRightLowerArm()
{
   beginShape(QUADS);
   fill(i);
  for(int i=0; i<4; i++)
  {
    vertex((-1)*LOWER_ARM[i][0],(-1)*LOWER_ARM[i][1]);
  } 
   endShape();}
   void ReflectedLeftLowerArm()
{
   beginShape(QUADS);
   fill(i);
  for(int i=0; i<4; i++)
  {
    vertex(LOWER_ARM[i][0],(-1)*(-1)*LOWER_ARM[i][1]);
  } 
   endShape();}
   void RightArm()
{
  beginShape(QUADS);
  fill(i);
  for(int i=0; i<4; i++)
  {
    vertex((-1)*LOWER_ARM[i][0],LOWER_ARM[i][1]);
  } 
  for(int i=0; i<4; i++)
  {
    vertex((-1)*UPPER_ARM[i][0],UPPER_ARM[i][1]);
  } 
   endShape();
}
   void LeftArm()
{
  beginShape(QUADS);
  fill(i);
  for(int i=0; i<4; i++)
  {
    vertex(LOWER_ARM[i][0],LOWER_ARM[i][1]);
  } 
  for(int i=0; i<4; i++)
  {
    vertex(UPPER_ARM[i][0],UPPER_ARM[i][1]);
  } 
   endShape();
}
void RightLeg()
{
  beginShape(QUADS);
  fill(h);
  for(int i=0; i<4; i++)
  {
    vertex((-1)*LOWER_LEG[i][0],LOWER_LEG[i][1]);
  }  
  for(int i=0; i<4; i++)
  {
    vertex((-1)*UPPER_LEG[i][0],UPPER_LEG[i][1]);
  } 
   endShape();
}
void LeftLeg()
{
  beginShape(QUADS);
  fill(h);
  for(int i=0; i<4; i++)
  {
    vertex(LOWER_LEG[i][0],LOWER_LEG[i][1]);
  }  
  for(int i=0; i<4; i++)
  {
    vertex(UPPER_LEG[i][0],UPPER_LEG[i][1]);
  } 
   endShape();
}
