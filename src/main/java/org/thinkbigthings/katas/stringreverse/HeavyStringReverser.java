package org.thinkbigthings.katas.stringreverse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;

public class HeavyStringReverser implements StringReverser {

   @Override
    public String reverse(String input) {
        if (input == null) {
            return null;
        }
        char[] chars = input.toCharArray();
        Character[] characters = ArrayUtils.toObject(chars);
        List<Character> characterList = Arrays.asList(characters);
        Collections.reverse(characterList);
        chars = ArrayUtils.toPrimitive((Character[]) characterList.toArray());
        return new String(chars);
    }

}
