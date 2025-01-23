package org.datastructures.cache;

import lombok.Builder;
import org.datastructures.interfaces.Cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> implements Cache<K, V> {
    private final int capacity;
    private final Map<K, V> storage;
    private Node<K, V> head;
    private Node<K, V> tail;
    private int size;

    private LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.storage = new HashMap<>();
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private LRUCache() {
        this.capacity = 10;
        this.storage = new HashMap<>();
        this.head = null;
        this.tail = null;
        this.size = 0;
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
        return this.size;
    }

    private void setHead(Node<K, V> node) {

    }

    private void remove(Node<K, V> node) {

    }

    @Builder(setterPrefix = "with")
    private static class Node<K, V> {
        private K key;
        private V value;
        public Node<K, V> next;
        public Node<K, V> prev;
    }
}
