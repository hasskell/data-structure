package org.datastructures.cache;

import org.datastructures.interfaces.Cache;

public class LRUCache<K, V> implements Cache<K, V> {
    private int capacity;

    private LRUCache(int capacity) {
        this.capacity = capacity;
    }

    private LRUCache() {
        this.capacity = 10;
    }

    /**
     * Creates instance of LRU cache with default capacity of 10 elements
     * @return Cache instance
     * @param <K> Cache Key
     * @param <V> Cache Values
     */
    public static <K, V> LRUCache<K, V> of() {
        return new LRUCache<>();
    }

    /**
     * Creates instance of LRU cache with specified capacity
     * @return Cache instance
     * @param <K> Cache Key
     * @param <V> Cache Values
     */
    public static <K, V> LRUCache<K, V> of(int capacity) {
        return new LRUCache<>(capacity);
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }
}
