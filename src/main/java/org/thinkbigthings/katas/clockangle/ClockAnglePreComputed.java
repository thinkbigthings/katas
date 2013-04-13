package org.thinkbigthings.katas.clockangle;

public class ClockAnglePreComputed extends AbstractClockAngle {
   
   private double[][][] degrees;
   
   public ClockAnglePreComputed() {
      degrees = createDegreeTable();
   }

   @Override
   public double getDegrees(int h, int m, int s) {
      return degrees[h][m][s];
   }

   private double calculateDegrees(int h, int m, int s) {
      
      // calculate all units in degrees per second
      double md  = m*6  + s*0.1; // the minute hand goes through 6 degrees per minute plus 1/10 degree per second
      double hd  = h*30 + m*0.5 + s*(1d/120d); // the hour hand goes through 30 degrees per hour plus 30/60=1/2 degree per minute plus (1/2)/60=1/120 degrees per second
      double result = Math.abs(hd-md);
      return result > 180 ? 360 - result : result;
   }
   
   private double[][][] createDegreeTable() {
     
     // roll through units of degrees
     double[][][] data = new double[12][60][60];
     for(int h=0; h < 12; h++) {
        for(int m=0; m < 60; m++) {
           for(int s=0; s < 60; s++) {
              data[h][m][s] = calculateDegrees(h, m, s);
           }
        }
     }
     
     return data;
  }
  
}
