package org.thinkbigthings.katas.anagram;

import java.util.Arrays;

public class AnagramDetectorLambdas implements AnagramDetector {
    
  private static final int MAX_VALUE = 65280;
 
  @Override
  public boolean isAnagram(String input1, String input2) {
 
      return false;
//     // null and length checks omitted for brevity
//     Supplier<Long[]> start = () -> { Long[] a = new Long[MAX_VALUE]; Arrays.fill(a, 0L); return a; };
//     ObjIntConsumer<Long[]> accumulator = (map, number) -> { map[number]++; };
//     BiConsumer<Long[],Long[]> combiner = (map1, map2) -> {  };
// 
//     return Arrays.equals( input1.chars().collect(start, accumulate, combine),
//                           input2.chars().collect(start, accumulate, combine));
 
  }

}
