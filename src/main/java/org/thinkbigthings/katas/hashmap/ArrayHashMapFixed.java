
package org.thinkbigthings.katas.hashmap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import org.apache.commons.lang.ObjectUtils;

/**
 * This implements a hash map, not necessarily the Java Map interface.
 * This class is not thread safe, not optimized for performance, doesn't do null checking, and is generally not production-ready.
 * But it shows how hashing works!
 * 
 * @param <K> type of the key
 * @param <V> type of the value
 */
public class ArrayHashMapFixed<K, V> implements SimpleMap<K,V> {
    
    private LinkedList<Entry<K,V>>[] elements;
    private Entry<K,V> NULL_ENTRY = new Entry(null, null);
    
    public ArrayHashMapFixed() {
        elements = new LinkedList[16];
        Arrays.fill(elements, null);
    }

    private LinkedList<Entry<K,V>> getElementList(K searchKey) {
        int index = searchKey.hashCode() % elements.length;
        elements[index] = (LinkedList<Entry<K,V>>)ObjectUtils.defaultIfNull(elements[index], new LinkedList<>());
        elements[index] = Optional.ofNullable(elements[index]).orElseGet(() -> new LinkedList<>());
        return elements[index];
    }
    
    @Override
    public V get(K inKey) {
        return (V) getElementList(inKey).stream()
                                        .filter(e -> e.getKey().equals(inKey))
                                        .findFirst()
                                        .orElse(NULL_ENTRY)
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
                               .orElse(NULL_ENTRY);
        list.remove(entry);
        return entry.getValue();
    }
    
    public static class Entry<K,V> {
        private K key;
        private V value;
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
