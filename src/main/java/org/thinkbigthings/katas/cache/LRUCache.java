package org.thinkbigthings.katas.cache;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;


public class LRUCache<K, V> extends LinkedHashMap<K, Optional<V>> {

    private static final long serialVersionUID = 1L;
    private final int maxEntries;

    public LRUCache(final int maxEntries) {
        super(16, 0.75f, true);
        this.maxEntries = maxEntries;
    }
    
    @Override
    public Optional<V> get(Object key) {
        return super.get(key);
    }

    @Override
    protected boolean removeEldestEntry(final Map.Entry<K, Optional<V>> eldest) {
        return super.size() > maxEntries;
    }

    public Map<K, Optional<V>> asSynchronizedCache() {
        return Collections.synchronizedMap(this);
    }
}
