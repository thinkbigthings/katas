package org.thinkbigthings.katas.clockangle;

public class ClockAngleNormalized implements ClockAngle {
  
  @Override
  public double getDegrees(int h, int m) {

     double normalizedMinutes = (double)m/60;
     double hours = h + normalizedMinutes;
     
     double normalizedHours = hours/12;
     double max = Math.max(normalizedHours, normalizedMinutes);
     double min = Math.min(normalizedHours, normalizedMinutes);
     double diff = max - min;
     
     double degreeDiff = diff * 360;
     if(degreeDiff > 180) {
        degreeDiff = 360 - degreeDiff;
     }
     
     return degreeDiff;
  }

}
