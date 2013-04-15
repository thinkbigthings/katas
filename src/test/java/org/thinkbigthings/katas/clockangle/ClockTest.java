package org.thinkbigthings.katas.clockangle;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ClockTest {
   
   private static final double TOLERANCE = 10E-2;
   
   private BasicClockAngle basicClock  = new BasicClockAngle();
   
   private double expectedDegrees;
   private int hour;
   private int minute;
   private int second;
   
   public ClockTest(double d, int h, int m, int s) {
      expectedDegrees = d;
      hour = h;
      minute = m;
      second = s;
   }
   
   @Test
   public void testDegrees() {
      assertEquals(expectedDegrees, basicClock.getDegrees(hour, minute, second), TOLERANCE);
   }
  
    @Parameterized.Parameters
    public static Collection getTestArgs() {
       // elements of each row are: expected degrees, hour, minute
        return Arrays.asList(new Object[][] {
            {60.208, 3,  05, 25},
            {0,    0,  0,  0},
            {55,   0,  10, 0},
            {110,  0,  20, 0},
            {165,  0,  30, 0},
            {140,  0,  40, 0},
            {85,   0,  50, 0},
            {115,  1,  50, 0},
            {160,  2,  40, 0},
            {72.5, 7,  25, 0},
            {170,  10, 20, 0},
            {12.5, 5,  25, 0}
        });
    };
}
