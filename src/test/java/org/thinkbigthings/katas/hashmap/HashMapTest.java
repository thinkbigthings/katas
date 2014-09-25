package org.thinkbigthings.katas.hashmap;

import nl.jqno.equalsverifier.EqualsVerifier;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class HashMapTest {

    private SimpleMap map = new BetterHashMap<>();
    
    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(ConstantHash.class).verify();
    }
    
    @Test
    public void testRemove() throws Exception {
        
        assertNull(map.get("1"));
        
        map.put("1", "apples");
        map.remove("1");
        
        assertNull(map.get("1"));
    }
    
    @Test
    public void testGet() throws Exception {
        
        assertNull(map.get("1"));
        
        map.put("1", "apples");
        
        assertEquals("apples", map.get("1"));
    }
    
    @Test
    public void testReplaces() throws Exception {
        
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
