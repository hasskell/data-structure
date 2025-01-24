package org.datastructures.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LRUCacheTest {
    private LRUCache<Integer, Integer> cache;

    @BeforeEach
    public void setUp(){
        this.cache = LRUCache.of();
    }

    @Test
    public void test_constructor(){
        assertThrows(IllegalArgumentException.class, () -> LRUCache.of(-120));
    }

    @Test
    public void test_put_element(){
        this.cache.put(1, 1);
        assertEquals(1, cache.get(1));

        this.cache.put(2, 2);
        assertEquals(2, cache.get(2));
        assertEquals(2, cache.size());
    }

    @Test
    public void test_get_element(){
        this.cache.put(1, 1);
        assertEquals(1, cache.get(1));

        this.cache.put(2, 2);
        assertEquals(2, cache.get(2));
        assertEquals(2, cache.size());
        assertNull(cache.get(3));
    }

    @Test
    public void test_size(){
        this.cache.put(1, 1);
        this.cache.put(2, 2);
        this.cache.put(3, 3);
        assertEquals(3, cache.size());
    }

    @Test
    public void test_clear(){
        this.cache.put(1, 1);
        this.cache.put(2, 2);
        this.cache.put(3, 3);
        assertEquals(3, cache.size());

        this.cache.clear();
        assertEquals(0, cache.size());
    }
}