package org.datastructures.interfaces;

import lombok.NonNull;

/**
 * Generic List Interface
 * @param <T>
 */
public interface CustomList <T> {

    /**
     * Adds element to specific index
     * @param element new element to add
     * @param index position of new element
     */
    void add(@NonNull T element, int index);

    /**
     * Adds element to first position in list
     * @param element new element to add
     */
    void addFirst(@NonNull T element);

    /**
     * Adds element to the end of the list
     * @param element new element to add
     */
    void addLast(@NonNull T element);

    /**
     * Removes element from specific position
     * @param element removing element
     * @param index position of element to remove
     */
    void remove(@NonNull T element, int index);

    /**
     * Removes element from beginning of the list
     */
    void removeFirst();

    /**
     * Removes element from end of the list
     */
    void removeLast();

    /**
     * Clears all element in list
     */
    void clear();

    /**
     * Returns current size of element
     * @return size of the list
     */
    int size();

    /**
     * Check if list is empty
     * @return true if list is empty false otherwise
     */
    boolean isEmpty();

    /**
     * Check if specific element present in list
     * @param element element to check for presents
     * @return true if element present false otherwise
     */
    boolean contains(@NonNull T element);

    /**
     * Gets element from list if it is present but not removes
     * @param element element to get from list
     * @return T element null otherwise
     */
    T get(@NonNull T element);

    /**
     * Gets element from beginning of list if it is present but not removes
     * @return T element null otherwise
     */
    T getFirst();

    /**
     * Gets element from end of list if it is present but not removes
     * @return T element null otherwise
     */
    T getLast();

    /**
     * Gets element from the list if it is present and removes at the same time
     * @param element element to get and remove
     * @return T element null otherwise
     */
    T poll(@NonNull T element);

    /**
     * Determine of List has next element
     * @return true if list has next element null otherwise
     */
    boolean hasNext();

    /**
     * Returns next element in list
     * @return next element or null
     */
    T next();
}
