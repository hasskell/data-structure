package org.datastructures.linkedlists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.datastructures.interfaces.CustomList;

/**
 * Implementation of CustomDoublyLinkedList list
 * @param <T> Type of the list
 */
public class CustomDoublyLinkedList<T> implements CustomList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private CustomDoublyLinkedList() {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    /**
     * Static method to create empty list
     * @return CustomDoublyLinkedList
     * @param <T> Type of List
     */
    public static <T> CustomDoublyLinkedList<T> of() {
        return new CustomDoublyLinkedList<T>();
    }

    /**
     * Static method to create CustomDoublyLinkedList with one element
     * @param value first element in list
     * @return CustomDoublyLinkedList
     * @param <T> Type of List
     */
    public static <T> CustomDoublyLinkedList<T> of(@NonNull T value) {
        CustomDoublyLinkedList<T> linkedList = new CustomDoublyLinkedList<T>();
        linkedList.addLast(value);
        return linkedList;
    }

    /**
     * Static method to create CustomDoublyLinkedList with multiple element
     * @param values array of values to add as element to linked list
     * @return CustomDoublyLinkedList
     * @param <T> Type of List
     */
    public static <T> CustomDoublyLinkedList<T> of(@NonNull T ... values) {
        CustomDoublyLinkedList<T> linkedList = new CustomDoublyLinkedList<T>();
        for (T value : values) {
            linkedList.addLast(value);
        }
        return linkedList;
    }

    @AllArgsConstructor
    @RequiredArgsConstructor
    @Builder(setterPrefix = "with")
    private static class Node<T> {
        private T value;
        private CustomDoublyLinkedList.Node<T> next;
        private CustomDoublyLinkedList.Node<T> prev;
    }

    @Override
    public void add(@NonNull T element, int index) throws IndexOutOfBoundsException {

    }

    @Override
    public void addFirst(@NonNull T element) {

    }

    @Override
    public void addLast(@NonNull T element) {

    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(@NonNull T element) {
        return false;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public T poll(@NonNull T element) {
        return null;
    }
}
