
package org.thinkbigthings.katas.hashmap;

public interface SimpleMap<K,V> {
    V get(K inKey);
    V put(K inKey, V putValue);
    V remove(K inKey);
}
