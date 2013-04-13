package org.thinkbigthings.katas.clockangle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {
   
   private ClockAngle clockAngle;
   
   public Clock(ClockAngle ca) {
      clockAngle = ca;
   }
   
  public double getDegrees() {
     return getDegrees(new Date());
  }
  
  public double getDegrees(Date date) {

     // SimpleDateFormat is not thread safe, so instantiate each thread's own copy
     SimpleDateFormat format = new SimpleDateFormat("K m");
     String[] hourMinute = format.format(date).split(" ");
     int hour = Integer.parseInt(hourMinute[0]);
     int minute = Integer.parseInt(hourMinute[1]);
     
     return clockAngle.getDegrees(hour, minute, 0);
  }
}
