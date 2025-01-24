package org.datastructures.interfaces;

/**
 * Generic interface for implementing Queue
 * @param <T> Type of the Queue
 */
public interface Queue <T>{

    /**
     * Adding element to queue
     * @param element new element
     */
    void enqueue(T element);

    /**
     * Retrieve element from queue
     * @return element from queue
     */
    T dequeue();

    /**
     * Check if queue is empty
     * @return true if queue is empty false otherwise
     */
    boolean isEmpty();

    /**
     * Returns current size of the queue
     * @return queue size
     */
    int size();

    /**
     * Does lookup of element but not retrieves it
     * @return queue element
     */
    T peek();
}
