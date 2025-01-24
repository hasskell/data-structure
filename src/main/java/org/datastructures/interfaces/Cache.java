package org.datastructures.interfaces;

/**
 * Generic caching interface
 * @param <K> Cache Key
 * @param <V> Cache Value
 */
public interface Cache <K,V>{

    /**
     * Puts key in to the caches
     * @param key Cache Key
     * @param value Cache Values
     */
    void put(K key, V value);

    /**
     * Gets key from cache
     * @param key Cache Key
     * @return Cache Values
     */
    V get(K key);

    /**
     * Resets cache, essentially makes it empty
     */
    void clear();

    /**
     * Returns current size of Cache
     * @return Cache size
     */
    int size();
}
