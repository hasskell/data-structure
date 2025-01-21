package org.datastructures.linkedlists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.datastructures.interfaces.CustomList;

public class CustomCyclicLinkedList<T> implements CustomList<T>{
    private CustomLinkedList.Node<T> head;
    private CustomLinkedList.Node<T> tail;
    private int size;

    private CustomCyclicLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    /**
     * Static method to create empty list
     * @return CustomLinkedList
     * @param <T> Type of List
     */
    public static <T> CustomList<T> of() {
        return new CustomCyclicLinkedList<T>();
    }

    /**
     * Static method to create CustomCyclicLinkedList with one element
     * @param value first element in list
     * @return CustomLinkedList
     * @param <T> Type of List
     */
    public static <T> CustomList<T> of(@NonNull T value) {
        CustomList<T> linkedList = new CustomCyclicLinkedList<T>();
        linkedList.addLast(value);
        return linkedList;
    }

    /**
     * Static method to create CustomCyclicLinkedList with multiple element
     * @param values array of values to add as element to linked list
     * @return CustomLinkedList
     * @param <T> Type of List
     */
    public static <T> CustomList<T> of(@NonNull T ... values) {
        CustomList<T> linkedList = new CustomCyclicLinkedList<T>();
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
