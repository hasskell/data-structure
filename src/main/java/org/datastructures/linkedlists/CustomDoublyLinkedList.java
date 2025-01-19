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
    public static <T> CustomList<T> of() {
        return new CustomDoublyLinkedList<T>();
    }

    /**
     * Static method to create CustomDoublyLinkedList with one element
     * @param value first element in list
     * @return CustomDoublyLinkedList
     * @param <T> Type of List
     */
    public static <T> CustomList<T> of(@NonNull T value) {
        CustomList<T> linkedList = new CustomDoublyLinkedList<T>();
        linkedList.addLast(value);
        return linkedList;
    }

    /**
     * Static method to create CustomDoublyLinkedList with multiple element
     * @param values array of values to add as element to linked list
     * @return CustomDoublyLinkedList
     * @param <T> Type of List
     */
    public static <T> CustomList<T> of(@NonNull T ... values) {
        CustomList<T> linkedList = new CustomDoublyLinkedList<T>();
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
        this.checkIndex(index, this.size);
        Node<T> newNode = Node.<T>builder()
                .withValue(element)
                .withNext(null)
                .withPrev(null)
                .build();

        if (index == 0 || this.head == null) {
            this.addFirst(element);
            return;
        }
        if(index == this.size){
            this.addLast(element);
            return;
        }
        int i = 0;
        Node<T> curr = this.head;
        while (curr != null) {
            if (i + 1 == index) {
                newNode.next = curr.next;
                newNode.prev = curr.prev;
                curr.next = newNode;
                this.size++;
                break;
            }
            i++;
            curr = curr.next;
        }
    }

    @Override
    public void addFirst(@NonNull T element) {
        Node<T> node = Node.<T>builder()
                .withValue(element)
                .withNext(null)
                .withPrev(null)
                .build();
        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            node.next = this.head;
            this.head.prev = null;
            this.head = node;
        }
        this.size++;
    }

    @Override
    public void addLast(@NonNull T element) {
        Node<T> node = Node.<T>builder()
                .withValue(element)
                .withNext(null)
                .build();

        if (this.head == null) {
            this.addFirst(element);
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
            this.size++;
        }
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        this.checkIndex(index, this.size);
        if (index == 0 && this.head != null) {
            if (this.head.next != null) {
                this.head = this.head.next;
                this.size--;
            } else {
                this.head = null;
                this.tail = null;
                this.size--;
                return;
            }
        }

        int i = 0;
        Node<T> curr = this.head;
        while (curr != null) {
            if (i + 1 == index) {
                curr.next = curr.next.next;
                curr.prev = curr.prev.prev;
                this.size--;
                break;
            }
            i++;
            curr = curr.next;
        }
    }

    @Override
    public void removeFirst() {
        if(this.head == null){
            return;
        }
        if(this.head.next == null){
            this.head = null;
            this.tail = null;
            return;
        }
        this.head = this.head.next;
        this.head.prev = null;
        this.size--;
    }

    @Override
    public void removeLast() {
        if(this.tail == null){
            return;
        }
        if(this.tail.next == null && this.tail.prev == null){
            this.head = null;
            this.tail = null;
        }

        if(this.tail != null){
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
    }

    @Override
    public void clear() {
        Node<T> node = this.head;
        while (node != null) {
            this.removeLast();
            node = node.next;
        }
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0 && this.head == null && this.tail == null;
    }

    @Override
    public boolean contains(@NonNull T element) {
        Node<T> node = this.head;
        while (node != null) {
            if (node.value.equals(element)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        Node<T> node = this.head;
        int i = 0;
        while (node != null && i < index) {
            i++;
            node = node.next;
        }
        return node != null ? node.value : null;
    }

    @Override
    public T getFirst() {
        return this.head != null ? this.head.value : null;
    }

    @Override
    public T getLast() {
        return this.tail != null ? this.tail.value : null;
    }

    @Override
    public T poll(@NonNull T element) {
        if (this.head == null) {
            return null;
        }
        if (this.head.value.equals(element)) {
            T value = this.head.value;
            this.head = head.next;
            this.size--;
            return value;
        }

        Node<T> curr = this.head;
        T value = null;
        while (curr != null) {
            if (curr.value.equals(element)) {
                value = curr.value;
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                this.size--;
                break;
            }
            curr = curr.next;
        }
        return value;
    }
}
