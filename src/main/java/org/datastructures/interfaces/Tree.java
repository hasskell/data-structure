package org.datastructures.interfaces;

/**
 * Generic interface to construct Tree structure
 * @param <T> Type of Tree
 */
public interface Tree<T> {

    /**
     * Adds element to tree
     * @param element new element
     */
    void add(T element);

    /**
     * Removes element from tree
     * @param element element to remove
     */
    void remove(T element);

}
