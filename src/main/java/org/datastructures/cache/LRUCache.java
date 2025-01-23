package org.datastructures.cache;

import lombok.Builder;
import org.datastructures.interfaces.Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of Least Recently Used cache (LRU) with O(1) complexity
 * @param <K> Key of the cache
 * @param <V> Value of the cache
 */
public class LRUCache<K, V> implements Cache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> storage;
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
        if (storage.containsKey(key)) {
            Node<K, V> node = storage.get(key);
            this.remove(node);
            this.setHead(node);
            return node.value;
        }
        return null;
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public void clear() {
        this.storage.clear();
        while (head != null) {
            this.remove(head);
        }
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
