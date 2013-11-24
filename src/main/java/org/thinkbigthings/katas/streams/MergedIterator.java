package org.thinkbigthings.katas.streams;

import java.util.Iterator;

public class MergedIterator<T extends Comparable<T>> implements Iterator<T> {

    private Iterator<T> s1;
    private Iterator<T> s2;
    private T next1;
    private T next2;

    public MergedIterator(Iterator<T> s1, Iterator<T> s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("arguments can't be null");
        }

        this.s1 = s1;
        this.s2 = s2;

        next1 = s1.hasNext() ? s1.next() : null;
        next2 = s2.hasNext() ? s2.next() : null;
    }

    // NOT THREAD SAFE
    @Override
    public boolean hasNext() {
        // if you use .hasNext() on the backing iterators, you'll never get the last element
        return next1 != null || next2 != null;
    }

    // NOT THREAD SAFE
    @Override
    public T next() {

        // returning null instead of throwing exceptions makes it easier to use parameterized tests
        if(!hasNext()) {
            return null;
        }
        
        // can use half the code at the expense of some readability
        boolean useStream1 = (next1 != null && next2 == null)  ||
                             (next1 != null && next2 != null && next1.compareTo(next2) <= 0);

        if(useStream1) {
            T returnObject = next1;
            next1 = s1.hasNext() ? s1.next() : null;
            return returnObject;            
        }
        else {
            T returnObject = next2;
            next2 = s2.hasNext() ? s2.next() : null;
            return returnObject;
        }
        
//        // if one stream is empty, can just continue streaming from the other
//        if (next1 == null && next2 != null) {
//            T returnObject = next2;
//            next2 = s2.hasNext() ? s2.next() : null;
//            return returnObject;
//        }
//
//        if (next1 != null && next2 == null) {
//            T returnObject = next1;
//            next1 = s1.hasNext() ? s1.next() : null;
//            return returnObject;
//        }
//
//        if (next1.compareTo(next2) <= 0) {
//            T returnObject = next1;
//            next1 = s1.hasNext() ? s1.next() : null;
//            return returnObject;
//        } 
//        else {
//            T returnObject = next2;
//            next2 = s2.hasNext() ? s2.next() : null;
//            return returnObject;
//        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported.");
    }

}
