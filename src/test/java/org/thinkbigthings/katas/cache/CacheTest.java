package org.thinkbigthings.katas.cache;

import static junit.framework.Assert.*;

import org.junit.Test;

public class CacheTest {

    @Test
    public void testCache() throws Exception {

        TimeBasedCache<Long,String> timeCache = new TimeBasedCache<>(10,30);
        
        timeCache.put(1L, "a");
        Thread.sleep(10);
        timeCache.put(2L, "a");
        
        assertTrue(timeCache.containsKey(1L));
        assertTrue(timeCache.containsKey(2L));
        
        Thread.sleep(30);
        assertFalse(timeCache.containsKey(1L));
        assertTrue(timeCache.containsKey(2L));
        
        Thread.sleep(20);
        assertFalse(timeCache.containsKey(1L));
        assertFalse(timeCache.containsKey(2L));        
    }

}
