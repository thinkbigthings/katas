package org.thinkbigthings.katas.clockangle;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ClockTest {
   
   private static final double TOLERANCE = 10E-4;
   
   private ClockAngle defaultClock     = new ClockAngleNormalized();
   private ClockAngle precomputedClock = new ClockAngleNormalized();
   
   private double expectedDegrees;
   private int hour;
   private int minute;
   
   public ClockTest(double d, int h, int m) {
      expectedDegrees = d;
      hour = h;
      minute = m;
   }
   
   @Test
   public void testDegreesDefault() {
      assertEquals(expectedDegrees, defaultClock.getDegrees(hour, minute), TOLERANCE);
   }
  
   @Test
   public void testDegreesPreComputed() {
      assertEquals(expectedDegrees, precomputedClock.getDegrees(hour, minute), TOLERANCE);
   }
  
    @Parameterized.Parameters
    public static Collection getTestArgs() {
       // elements of each row are: expected degrees, hour, minute
        return Arrays.asList(new Object[][] {
            {0,    0,  0},
            {55,   0,  10},
            {110,  0,  20},
            {165,  0,  30},
            {140,  0,  40},
            {85,   0,  50},
            {115,  1,  50},
            {160,  2,  40},
            {72.5, 7,  25},
            {170,  10, 20},
            {12.5, 5,  25},
        });
    };
}
