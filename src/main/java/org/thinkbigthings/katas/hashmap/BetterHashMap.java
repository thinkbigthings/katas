
package org.thinkbigthings.katas.hashmap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * This implements a hash map, not necessarily Java Map.
 * This class is not thread safe, 
 * not optimized for performance, 
 * doesn't do null checking, and is generally not 
 * production-ready. But it shows how hashing works!
 * 
 * @param <K> type of the key
 * @param <V> type of the value
 */
public class BetterHashMap<K, V> implements SimpleMap<K,V> {
    
    private final LinkedList<Entry<K,V>>[] elements;
    private final Entry<K,V> nullEntry = new Entry(null, null);
    private final Supplier<LinkedList<Entry<K,V>>> newList = () -> new LinkedList<>();
    
    public BetterHashMap() {
        elements = new LinkedList[16];
        Arrays.fill(elements, null);
    }

    private LinkedList<Entry<K,V>> getElementList(K searchKey) {
        int index = searchKey.hashCode() % elements.length;
        elements[index] = Optional.ofNullable(elements[index]).orElseGet(newList);
        return elements[index];
    }

    @Override
    public V get(K inKey) {
        return (V) getElementList(inKey).stream()
                                        .filter(e -> e.getKey().equals(inKey))
                                        .findFirst()
                                        .orElse(nullEntry)
                                        .getValue();
    }

    @Override
    public V put(K inKey, V putValue) {
        remove(inKey);
        getElementList(inKey).add(new Entry<>(inKey, putValue));
        return putValue;
    }

    @Override
    public V remove(K inKey) {
        LinkedList<Entry<K,V>> list = getElementList(inKey);
        Entry<K,V> entry = list.stream()
                               .filter(e -> e.getKey().equals(inKey))
                               .findFirst()
                               .orElse(nullEntry);
        list.remove(entry);
        return entry.getValue();
    }
    
    public static class Entry<K,V> {
        private final K key;
        private final V value;
        public Entry(K k, V v) {
            key = k;
            value = v;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }
}
