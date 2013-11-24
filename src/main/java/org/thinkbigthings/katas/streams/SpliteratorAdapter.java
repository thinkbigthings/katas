
package org.thinkbigthings.katas.streams;

import java.util.Iterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/**
 * Recommend using with StreamSupport.stream(iteratorStream, false);
 */
public class SpliteratorAdapter<T> extends Spliterators.AbstractSpliterator <T>{
    
    private final Iterator<T> iterator;
    
    public SpliteratorAdapter(Iterator<T> iter) {
        super(Long.MAX_VALUE, 0);
        iterator = iter;
    }

    @Override
    public synchronized boolean tryAdvance(Consumer<? super T> action) {
        if(iterator.hasNext()) {
            action.accept(iterator.next());
            return true;
        }
        return false;
    }

}
