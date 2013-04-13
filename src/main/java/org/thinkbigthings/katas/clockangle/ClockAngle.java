package org.thinkbigthings.katas.clockangle;

public interface ClockAngle {

   /**
    * @param hour from 0-12
    * @param minute from 0-59
    * @param second from 0-59
    * @return smallest angle in degrees between the two hands of an analog clock with that time,
    * assume all hands move an amount for each tic of one second
    */
   double getDegrees(int hour, int minute, int second);
}
