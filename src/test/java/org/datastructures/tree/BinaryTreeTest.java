package org.datastructures.tree;

import org.datastructures.interfaces.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinaryTreeTest {

    private Tree<Integer> tree;

    @BeforeEach
    void setUp() {
        this.tree = BinaryTree.of();
    }
    @Test
    void test_add_element() {
        this.tree.add(10);
        this.tree.add(2);
        this.tree.add(72);
        this.tree.add(42);
    }
}