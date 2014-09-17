
package org.thinkbigthings.katas.hashmap;

/**
 * This implements a limited and buggy hash map, but it shows how hashing works!
 * 
 * @param <K> type of the key
 * @param <V> type of the value
 */
public class BuggyHashMap<K, V> implements SimpleMap<K,V> {
    
    private Entry<K,V>[] elements;
    
    public BuggyHashMap() {
        elements = new Entry[16];
    }

    @Override
    public V get(K inKey) {
        int index = inKey.hashCode() % elements.length;
        Entry<K,V> entry = elements[index];
        return (entry == null) ? null : entry.value;
    }

    @Override
    public V put(K inKey, V putValue) {
        int index = inKey.hashCode() % elements.length;
        elements[index] = new Entry<>(inKey, putValue);
        return putValue;
    }

    @Override
    public V remove(K inKey) {
        int index = inKey.hashCode() % elements.length;
        Entry<K,V> entry = elements[index];
        elements[index] = null;
        return entry.value;
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
