package org.datastructures.interfaces;

import lombok.NonNull;

/**
 * Generic List Interface
 * @param <T>
 */
public interface CustomList <T> {

    /**
     *
     * Adds element to specific index
     * @param element new element to add
     * @param index position of new element
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    void add(@NonNull T element, int index) throws IndexOutOfBoundsException;

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
     * @param index position of element to remove
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    void remove(int index) throws IndexOutOfBoundsException;

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
     * @param index element position
     * @return T element null otherwise
     */
    T get(int index) throws IndexOutOfBoundsException;

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

}
