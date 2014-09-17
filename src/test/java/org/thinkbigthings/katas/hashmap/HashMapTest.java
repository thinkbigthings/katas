package org.thinkbigthings.katas.hashmap;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class HashMapTest {

    private SimpleMap map = new BetterHashMap<>();
    
    @Test
    public void testPutAndGet() throws Exception {
        
        assertNull(map.get("1"));
        
        map.put("1", "apples");
        
        assertEquals("apples", map.get("1"));
    }
    
    @Test
    public void testPutReplaces() throws Exception {
        
        assertNull(map.get("1"));
        
        map.put("1", "apples");
        map.put("1", "oranges");
        
        assertEquals("oranges", map.get("1"));
    }

    @Test
    public void testTwoObjectsSameHash() throws Exception {
        
        Object k1 = new ConstantHash();
        Object k2 = new ConstantHash();
        
        map.put(k1, "apples");
        map.put(k2, "oranges");
        
        assertEquals("apples",  map.get(k1));
        assertEquals("oranges", map.get(k2));
    }
    

}
