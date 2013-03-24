package org.thinkbigthings.katas.stringreverse;

public class RecursiveStringReverser implements StringReverser {

    @Override
    public String reverse(String input) {
        if (input == null) {
            return null;
        }
        if (input.length() <= 1) {
            return input;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(input.substring(input.length() - 1, input.length()));
        String substring = input.substring(0, input.length() - 1);
        buffer.append(reverse(substring));
        return buffer.toString();
    }
}
