package org.thinkbigthings.katas.anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.ArrayUtils;

public class AnagramDetectorFrequencyMap implements AnagramDetector {
   @Override
   public boolean isAnagram(String input1, String input2) {
      
      if(input1 == null || input2 == null) {
         throw new IllegalArgumentException("input can't be null");
      }
      
      // return immediately if by definition it can't be an anagram
      if(input1.length() != input2.length()) {
         return false;
      }

      List<Character> input1Set = toCharacters(input1.toLowerCase());
      List<Character> input2Set = toCharacters(input2.toLowerCase());

      return createFrequencyMap(input1Set).equals(createFrequencyMap(input2Set));
   }
   
   private Map<Character, Integer> createFrequencyMap(List<Character> inputs) {
      // the count of character appearances
      Map<Character, Integer> frequencies = new HashMap<>();
      for(Character c : inputs) {
         Integer count = frequencies.get(c);
         count = (count == null) ? 0 : count;
         frequencies.put(c, count + 1);
      }
      return frequencies;
   }

   private List<Character> toCharacters(String input) {
      return Arrays.asList(ArrayUtils.toObject(input.toLowerCase().toCharArray()));
   }

}
