package org.datastructures.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.datastructures.interfaces.Tree;

public class BinaryTree <T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    private BinaryTree() {
        this.root = null;
    }

    /**
     * Creates empty Binary tree
     * @return empty binary tree
     * @param <T> Type of the binary tree
     */
    public static <T extends Comparable<T>> BinaryTree<T> of() {
        return new BinaryTree<>();
    }

    @Override
    public void add(T element) {
        Node<T> newNode = Node.<T>builder()
                .withValue(element)
                .build();

        if (this.root == null) {
            this.root = newNode;
            return;
        }

        Node<T> current = this.root;
        while (current != null) {
            if (newNode.value.compareTo(current.value) < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                } else {
                    current = current.right;
                }
            }
        }
    }

    @Override
    public void remove(T element) {

    }

    @AllArgsConstructor
    @Builder(setterPrefix = "with")
    private static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> left;
        private Node<T> right;
    }
}
