package org.thinkbigthings.katas.clockangle;

public class ClockAngleDefault extends AbstractClockAngle {

   @Override
   public double getDegrees(int h, int m, int s, int ms) {
      
      // check against https://sites.google.com/site/mymathclassroom/trigonometry/clock-angle-problems/clock-angle-problems-involving-second-hands
      
      // calculate all units in degrees per second
      double md  = m*6  + s*0.1; // the minute hand goes through 6 degrees per minute plus 1/10 degree per second
      double hd  = h*30 + m*0.5 + s*(1d/120d); // the hour hand goes through 30 degrees per hour plus 30/60=1/2 degree per minute plus (1/2)/60=1/120 degrees per second
      double result = Math.abs(hd-md);
      return result > 180 ? 360 - result : result;
   }

}
