package org.thinkbigthings.katas.clockangle;

public abstract class AbstractClockAngle implements ClockAngle {
  
  @Override
  public double getDegrees(int h, int m) {
     return getDegrees(h, m, 0);
  }
  
  protected boolean isValidTime(int h, int m, int s) {
      boolean valid = true;
      valid &= (0 <= h  && h  <= 11);
      valid &= (0 <= m  && m  <= 59);
      valid &= (0 <= s  && s  <= 59);
      return valid;
  }

}
