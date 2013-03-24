package org.thinkbigthings.katas.clockangle;

public class ClockAnglePreComputed implements ClockAngle {
   
   private double[][] degrees;
   
   public ClockAnglePreComputed() {
      degrees = createDegreeTable();
   }

   @Override
   public double getDegrees(int h, int m) {
      return degrees[h][m];
   }
  
   private double[][] createDegreeTable() {
     
     // roll through units of degrees
     double[][] data = new double[12][60];
     for(int h=0; h < 12; h++) {
        for(int m=0; m < 60; m++) {
           double md  = m*6;
           double hd  = m*0.1 + 30*h;
           double result = Math.abs(hd-md);
           data[h][m] = result > 180 ? 360 - result : result;
        }
     }
     
     return data;
  }
  
}
