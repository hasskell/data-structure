package org.datastructures.linkedlists;

import lombok.NonNull;
import org.datastructures.common.Node;
import org.datastructures.interfaces.CustomList;

/**
 * Implementation of CustomLinked list
 * @param <T> Type of the list
 */
public class CustomLinkedList <T> implements CustomList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private CustomLinkedList(){
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
        return new CustomLinkedList<T>();
    }

    /**
     * Static method to create CustomLikedList with one element
     * @param value first element in list
     * @return CustomLinkedList
     * @param <T> Type of List
     */
    public static <T> CustomList<T> of(@NonNull T value) {
        CustomList<T> linkedList = new CustomLinkedList<T>();
        linkedList.addLast(value);
        return linkedList;
    }

    /**
     * Static method to create CustomLikedList with multiple element
     * @param values array of values to add as element to linked list
     * @return CustomLinkedList
     * @param <T> Type of List
     */
    public static <T> CustomList<T> of(@NonNull T ... values) {
        CustomList<T> linkedList = new CustomLinkedList<T>();
        for (T value : values) {
            linkedList.addLast(value);
        }
        return linkedList;
    }

    @Override
    public void add(@NonNull T element, int index) {
        this.checkIndex(index, this.size);
        Node<T> newNode = Node.<T>builder()
                .withValue(element)
                .withNext(null)
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
                .build();

        if (this.head == null) {
            this.head = node;
            this.tail = head;
        } else {
            node.next = this.head;
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
            this.tail = this.tail.next;
            this.size++;
        }
    }

    @Override
    public void remove(int index) {
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
                this.size--;
                break;
            }
            i++;
            curr = curr.next;
        }
    }

    @Override
    public void removeFirst() {
        if (this.head != null) {
            this.head = this.head.next;
        }
        this.size--;
    }

    @Override
    public void removeLast() {
        Node<T> prev = this.head;
        if (prev == null) {
            return;
        }

        if (prev.next == null) {
            this.head = null;
            return;
        }

        while (prev.next.next != null) {
            prev = prev.next;
        }
        prev.next = null;
        this.tail = prev;
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
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null && this.size == 0;
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
    public T get(int index) {
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
        if (this.head != null) {
            return this.head.value;
        }
        return null;
    }

    @Override
    public T getLast() {
        if (this.tail != null) {
            return this.tail.value;
        }
        return null;
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

        Node<T> prev = this.head;
        T value = null;
        while (prev.next != null) {
            if (prev.next.value.equals(element)) {
                value = prev.next.value;
                prev.next = prev.next.next;
                this.size--;
                break;
            }
            prev = prev.next;
        }
        return value;
    }
}

