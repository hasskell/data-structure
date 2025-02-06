package org.datastructures.cache;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.datastructures.interfaces.Manager;

import java.util.HashMap;

public class NotificationManager <T> implements Manager <T>{

    private final HashMap<T, Node<T>> notifications;
    private Node<T> head;

    public NotificationManager() {
        this.notifications = new HashMap<>();
        this.head = null;
    }

    public static <T> NotificationManager <T> of() {
        return new NotificationManager<>();
    }

    @Override
    public void add(T t) {
        Node<T> newNode = Node.<T>builder()
                .withValue(t)
                .build();
        if (this.notifications.containsKey(t)) {
            // move to top
            this.remove(t);
            setHead(t, newNode);
        } else {
            setHead(t, newNode);
        }
    }

    @Override
    public void remove(T t) {
        if (this.notifications.containsKey(t)) {
            Node<T> node = this.notifications.get(t);
            this.notifications.remove(t);

            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                this.head = node.next;
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                node.prev = null;
            }
        }
    }

    @Override
    public boolean contains(T t) {
        return this.notifications.get(t) != null;
    }

    @Override
    public T get() {
        return this.head.value;
    }

    @Override
    public int size() {
        return this.notifications.size();
    }

    private void setHead(T t, Node<T> newNode) {
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        this.notifications.put(t, newNode);
    }

    @AllArgsConstructor
    @Builder(setterPrefix = "with")
    private static class Node<T>{
        T value;
        Node<T> next;
        Node<T> prev;
    }
}
