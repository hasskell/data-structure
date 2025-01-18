package org.datastructures.linkedlists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.datastructures.interfaces.CustomList;

/**
 * Implementation of CustomLinked list
 * @param <T>
 */
@NoArgsConstructor
public class CustomLinkedList <T> implements CustomList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Static method to create empty list
     * @return CustomLinkedList
     * @param <T> Type of List
     */
    public static <T> CustomLinkedList<T> of() {
        return new CustomLinkedList<T>();
    }

    /**
     * Static method to create CustomLikedList with one element
     * @param value first element in list
     * @return CustomLinkedList
     * @param <T> Type of List
     */
    public static <T> CustomLinkedList<T> of(T value) {
        CustomLinkedList<T> linkedList = new CustomLinkedList<T>();
        linkedList.addFirst(value);
        return linkedList;
    }

    /**
     * Static method to create CustomLikedList with multiple element
     * @param values array of values to add as element to linked list
     * @return CustomLinkedList
     * @param <T> Type of List
     */
    public static <T> CustomLinkedList<T> of(T ... values) {
        CustomLinkedList<T> linkedList = new CustomLinkedList<T>();
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
        private Node<T> next;

    }

    @Override
    public void add(@NonNull T element, int index) {

    }

    @Override
    public void addFirst(@NonNull T element) {
        Node<T> newNode = new Node<>();
    }

    @Override
    public void addLast(@NonNull T element) {

    }

    @Override
    public void remove(@NonNull T element, int index) {

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
    public T get(@NonNull T element) {
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
    public T poop(@NonNull T element) {
        return null;
    }
}

