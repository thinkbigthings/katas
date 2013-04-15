package org.thinkbigthings.katas.clockangle;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class ClockCacheTest {
   
   ClockAngle mockClock = mock(ClockAngle.class);
   private ClockAngle cacheClock = new ClockAngleCached(mockClock, 1);
   
   @Before
   public void setup() throws Exception{
      when(mockClock.getDegrees(3, 5, 25)).thenReturn(new Double(60.208));
      when(mockClock.getDegrees(0, 0, 0 )).thenReturn(new Double(0));
   }

   @Test(expected=IllegalArgumentException.class)
   public void testConstructorArgs() {
      ClockAngle invalid = new ClockAngleCached(null, -1);
   }
   
   @Test
   public void testCacheOverrite() {
      cacheClock.getDegrees(3, 5, 25);
      cacheClock.getDegrees(0, 0, 0);
      cacheClock.getDegrees(3, 5, 25);
      
      verify(mockClock, times(2)).getDegrees(3,5,25);
   }
   
   @Test
   public void testCacheSingle() {
      cacheClock.getDegrees(3, 5, 25);
      cacheClock.getDegrees(3, 5, 25);
      cacheClock.getDegrees(3, 5, 25);
      
      verify(mockClock, times(1)).getDegrees(3,5,25);
   }

}
