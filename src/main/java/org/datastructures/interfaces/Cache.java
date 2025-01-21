package org.datastructures.interfaces;

/**
 * Generic caching interface
 * @param <K> Cache Key
 * @param <V> Cache Value
 */
public interface Cache <K,V>{

    void put(K key, V value);

    V get(K key);

    void remove(K key);

    void clear();

    int size();
}
