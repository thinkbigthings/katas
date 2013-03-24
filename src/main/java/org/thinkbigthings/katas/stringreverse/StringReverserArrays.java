package org.thinkbigthings.katas.stringreverse;

import org.apache.commons.lang.ArrayUtils;

public class StringReverserArrays implements StringReverser {

    @Override
    public String reverse(String input) {
        if (input == null) {
            return null;
        }
        char[] chars = input.toCharArray();
        ArrayUtils.reverse(chars);
        return new String(chars);
    }

}
