package org.thinkbigthings.katas.clockangle;

public interface ClockAngle {
   
   /**
    * @param hour from 0-12
    * @param minute from 0-59
    * @return smallest angle in degrees between the two hands of an analog clock with that time
    */
   double getDegrees(int hour, int minute);
   
   /**
    * @param hour from 0-12
    * @param minute from 0-59
    * @param second from 0-59
    * @param millisecond from 0-999
    * @return smallest angle in degrees between the two hands of an analog clock with that time,
    * assume all hands move the appropriate amount for each second and millisecond
    */
   double getDegrees(int hour, int minute, int second, int millisecond);
}
