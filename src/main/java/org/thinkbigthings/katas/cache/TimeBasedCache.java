package org.thinkbigthings.katas.cache;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("serial")
public class TimeBasedCache<K,V> extends HashMap<K,V> {

    private final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
    private final Map<Instant, K> accessTime = new HashMap<>();
    
    public TimeBasedCache(final long scanPeriodMs, final long maxLifetimeMs) {
        executor.scheduleAtFixedRate( ()-> doCacheInvalidation(maxLifetimeMs), scanPeriodMs, scanPeriodMs, TimeUnit.MILLISECONDS);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        accessTime.put(Instant.now(), (K)key);
        return super.get(key);
    }
    
    @Override
    public V put(K key, V value) {
        accessTime.put(Instant.now(), key);
        return super.put(key,value);
    }
    
    protected final void doCacheInvalidation(final long maxLifetimeMs) {
        Instant oldestAllowed = Instant.now().minus(maxLifetimeMs, ChronoUnit.MILLIS);
        accessTime.entrySet()
                .stream()
                .filter( (entry) -> entry.getKey().compareTo(oldestAllowed) < 0)
                .forEach((entry) -> super.remove(entry.getValue()));
    }
    
}
