package org.thinkbigthings.katas.clockangle;

public class ValidatingClockAngle implements ClockAngle {

   private ClockAngle calculator;
   
   public ValidatingClockAngle(ClockAngle c) {
      calculator = c;
   }
  
  public boolean isValidTime(int h, int m, int s) {
      boolean valid = true;
      valid &= (0 <= h  && h  <= 11);
      valid &= (0 <= m  && m  <= 59);
      valid &= (0 <= s  && s  <= 59);
      return valid;
  }

   @Override
   public double getDegrees(int hour, int minute, int second)
   {
      if(!isValidTime(hour, minute, second)) {
         throw new IllegalArgumentException();
      }
      
      return calculator.getDegrees(hour, minute, second);
   }

}
