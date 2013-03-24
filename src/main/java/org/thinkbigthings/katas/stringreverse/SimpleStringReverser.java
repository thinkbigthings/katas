package org.thinkbigthings.katas.stringreverse;

public class SimpleStringReverser implements StringReverser {

    @Override
    public String reverse(String input) {
        return input == null ? input : new StringBuffer(input).reverse().toString();
    }

}
