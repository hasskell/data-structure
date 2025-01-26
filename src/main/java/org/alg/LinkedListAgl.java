package org.alg;

import lombok.AllArgsConstructor;
import lombok.Builder;

public class LinkedListAgl {

    public static void main(String[] args) {
        Node<Integer> head = Node.<Integer>builder()
                .withData(1)
                .build();

        Node<Integer> current = head;

        for (int i = 2; i < 7; i++) {
            current.next = Node.<Integer>builder()
                    .withData(i)
                    .build();
            current = current.next;
        }
        reverse(head);
    }

    private static <T> Node<T> reverse(Node<T> head) {
        Node<T> current = head;
        while (head != null) {
            Node<T> tmp = head.next;
            head.next = current;
            current = head;
            head = tmp;
        }
        return current;
    }

    @AllArgsConstructor
    @Builder(setterPrefix = "with")
    private static class Node<T> {
        T data;
        Node<T> next;
    }
}
