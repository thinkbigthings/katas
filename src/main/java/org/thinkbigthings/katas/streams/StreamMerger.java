
package org.thinkbigthings.katas.streams;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class StreamMerger<T extends Comparable<T>> {
 
    public Stream<T> merge(Stream<T> stream1, Stream<T> stream2) {

        MergedIterator<T> iterator = new MergedIterator<>(stream1.iterator(), stream2.iterator());
        Spliterator<T> spliterator = new SpliteratorAdapter<>(iterator);
        
        return StreamSupport.stream(spliterator, false);
    }

}
