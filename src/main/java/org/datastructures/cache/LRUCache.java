package org.datastructures.cache;

import lombok.Builder;
import org.datastructures.interfaces.Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of Least Recently Used cache (LRU) with O(1) complexity
 *
 * @param <K> Key of the cache
 * @param <V> Value of the cache
 */
public class LRUCache<K, V> implements Cache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> storage;
    private Node<K, V> head;
    private Node<K, V> tail;

    private LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.storage = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    private LRUCache() {
        this.capacity = 10;
        this.storage = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    /**
     * Creates instance of LRU cache with default capacity of 10 elements
     *
     * @param <K> Cache Key
     * @param <V> Cache Values
     * @return Cache instance
     */
    public static <K, V> LRUCache<K, V> of() {
        return new LRUCache<>();
    }

    /**
     * Creates instance of LRU cache with specified capacity
     *
     * @param <K> Cache Key
     * @param <V> Cache Values
     * @return Cache instance
     */
    public static <K, V> LRUCache<K, V> of(int capacity) {
        return new LRUCache<>(capacity);
    }

    @Override
    public void put(K key, V value) {
        if (this.storage.containsKey(key)){
            Node<K, V> node = this.storage.get(key);
            this.remove(node);
            this.setHead(node);
        } else {
            Node<K, V> newNode = Node.<K, V>builder()
                    .withKey(key)
                    .withValue(value)
                    .build();
            if (this.storage.size() >= this.capacity) {
                this.storage.remove(this.tail.key);
                this.remove(this.tail);
                this.setHead(newNode);
            } else {
                this.setHead(newNode);
            }
            this.storage.put(key, newNode);
        }
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
    public void clear() {
        this.storage.clear();
        while (head != null) {
            this.remove(head);
        }
    }

    @Override
    public int size() {
        return this.storage.size();
    }

    private void setHead(Node<K, V> node) {
        node.next = head;
        node.prev = null;

        if (this.head != null) {
            this.head.prev = node;
        }
        this.head = node;

        if (this.tail == null) {
            this.tail = this.head;
        }
    }

    private void remove(Node<K, V> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            this.head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            this.tail = node.prev;
        }
    }

    @Builder(setterPrefix = "with")
    private static class Node<K, V> {
        private K key;
        private V value;
        public Node<K, V> next;
        public Node<K, V> prev;
    }
}
