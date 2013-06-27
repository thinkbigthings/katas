package org.thinkbigthings.katas.anagram;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang.ArrayUtils;

public class AnagramDetectorScanner implements AnagramDetector {
   @Override
   public boolean isAnagram(String input1, String input2) {
      
      if(input1 == null || input2 == null) {
         throw new IllegalArgumentException("input can't be null");
      }
      
      // return immediately if by definition it can't be an anagram
      if(input1.length() != input2.length()) {
         return false;
      }

      // get unique characters
      Set<Character> uniqueCharacters = new TreeSet<>(toCharacters(input1.toLowerCase()));

      List<Character> input1Set = toCharacters(input1.toLowerCase());
      List<Character> input2Set = toCharacters(input2.toLowerCase());
      
      // scan each string for each character
      // if the counts are different, they are not anagrams
      for(Character uniqueCharacter : uniqueCharacters) {
         char uniqueChar = uniqueCharacter.charValue();
         int count1 = Collections.frequency(input1Set, uniqueChar);
         int count2 = Collections.frequency(input2Set, uniqueChar);
         if(count1 != count2) {
            return false;
         }
      }

      return true;
   }
   
   private List<Character> toCharacters(String input) {
      return Arrays.asList(ArrayUtils.toObject(input.toLowerCase().toCharArray()));
   }

}
