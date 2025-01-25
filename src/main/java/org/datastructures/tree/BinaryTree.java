package org.datastructures.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.datastructures.interfaces.Tree;

public class BinaryTree <T> implements Tree<T> {

    private Node<T> root;

    @Override
    public void add(T element) {

    }

    @Override
    public void remove(T element) {

    }

    @AllArgsConstructor
    @Builder(setterPrefix = "with")
    private static class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;
    }
}
