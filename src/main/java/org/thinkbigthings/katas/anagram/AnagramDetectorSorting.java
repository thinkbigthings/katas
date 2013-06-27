package org.thinkbigthings.katas.anagram;

import java.util.Arrays;

public class AnagramDetectorSorting implements AnagramDetector {
   @Override
   public boolean isAnagram(String input1, String input2) {
      
      if(input1 == null || input2 == null) {
         throw new IllegalArgumentException("input can't be null");
      }
      
      // return immediately if by definition it can't be an anagram
      if(input1.length() != input2.length()) {
         return false;
      }

      char[] input1Chars = input1.toLowerCase().toCharArray();
      char[] input2Chars = input2.toLowerCase().toCharArray();
      Arrays.sort(input1Chars);
      Arrays.sort(input2Chars);
      return Arrays.equals(input1Chars, input2Chars);
   }

}
