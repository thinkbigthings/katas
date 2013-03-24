package org.thinkbigthings.katas.clockangle;

public interface ClockAngle {
   
   /**
    * @param hour from 0-12
    * @param minute from 0-59
    * @return smallest angle in degrees between the two hands of an analog clock with that time
    */
   double getDegrees(int hour, int minute);
}
