package org.thinkbigthings.katas.clockangle;

public class ClockAnglePreComputed implements ClockAngle {
   
   private double[][][] degrees;
   private ClockAngle calculator;
   
   public ClockAnglePreComputed(ClockAngle c) {
      calculator = c;
      degrees = createDegreeTable();
   }

   @Override
   public double getDegrees(int h, int m, int s) {
      return degrees[h][m][s];
   }

   private double[][][] createDegreeTable() {
     
     double[][][] data = new double[12][60][60];
     for(int h=0; h < 12; h++) {
        for(int m=0; m < 60; m++) {
           for(int s=0; s < 60; s++) {
              data[h][m][s] = calculator.getDegrees(h, m, s);
           }
        }
     }
     
     return data;
  }
  
}
