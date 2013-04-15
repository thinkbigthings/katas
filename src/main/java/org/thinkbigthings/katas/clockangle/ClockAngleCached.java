package org.thinkbigthings.katas.clockangle;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// TODO make a thread safe subclass
/**
 * 
 * This class is not thread safe.
 */
public class ClockAngleCached implements ClockAngle {
   
   protected ClockAngle calculator;
   
   // to make this map thread safe, wrap in Collections.synchronizedMap()
   protected MaxSizeHashMap<List<Integer>, Double> cache;
   
   public ClockAngleCached(ClockAngle c, int cacheSize) {
      if(cacheSize <= 0) {
         throw new IllegalArgumentException();
      }
      calculator = c;
      cache = new MaxSizeHashMap<>(cacheSize);
   }
   
   @Override
   public double getDegrees(int h, int m, int s) 
   {
      List<Integer> time = Arrays.asList(h, m, s);
      Double result = cache.get(time);
      result = (result == null) ? calculator.getDegrees(h, m, s) : result;
      cache.put(time, result);
      
      return result;
   }
   
   public static class MaxSizeHashMap<K, V> extends LinkedHashMap<K, V> 
   {
       private final int maxSize;

       public MaxSizeHashMap(int maxSize) {
           this.maxSize = maxSize;
       }

       @Override
       protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
           return size() > maxSize;
       }
   }
}
