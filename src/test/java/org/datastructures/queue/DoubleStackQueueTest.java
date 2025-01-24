package org.datastructures.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DoubleStackQueueTest {

    private DoubleStackQueue<Integer> queue;

    @BeforeEach
    public void setUp(){
        this.queue = DoubleStackQueue.of();
    }

    @Test
    void test_enqueue() {
        this.queue.enqueue(1);
        assertEquals(1, this.queue.peek());
        this.queue.enqueue(2);
        assertEquals(1, this.queue.peek());
        assertEquals(2, this.queue.size());
    }

    @Test
    void test_dequeue() {
        this.queue.enqueue(1);
        assertEquals(1, this.queue.peek());

        this.queue.enqueue(2);
        assertEquals(1, this.queue.peek());

        assertEquals(2, this.queue.size());
        this.queue.dequeue();
        assertEquals(2, this.queue.peek());
        assertEquals(1, this.queue.size());
    }

    @Test
    void test_is_empty() {
        this.queue.enqueue(1);
        assertEquals(1, this.queue.peek());
        this.queue.enqueue(2);
        assertEquals(1, this.queue.peek());
        assertEquals(2, this.queue.size());

        this.queue.dequeue();
        this.queue.dequeue();
        assertTrue(this.queue.isEmpty());
    }
}