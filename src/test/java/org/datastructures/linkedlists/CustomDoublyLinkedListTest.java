package org.datastructures.linkedlists;

import org.datastructures.interfaces.CustomList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomDoublyLinkedListTest {

    @Test
    public void test_null_constructor(){
        assertThrows(NullPointerException.class, () -> CustomDoublyLinkedList.of(null));
    }

    @Test
    public void test_null_methods()  {
        CustomList<Integer> test = CustomDoublyLinkedList.of();
        assertThrows(NullPointerException.class, () -> test.add(null, 1));
        assertThrows(NullPointerException.class, () -> test.addFirst(null));
        assertThrows(NullPointerException.class, () -> test.addLast(null));
        assertThrows(NullPointerException.class, () -> test.contains(null));
        assertThrows(NullPointerException.class, () -> test.poll(null));
    }

    @Test
    public void test_add_element(){
        CustomList<Integer> test = CustomDoublyLinkedList.of(1, 4, 5);
        test.add(2, 1);
        test.add(3, 2);
        assertEquals(2, test.get(1));
        assertEquals(3, test.get(2));
    }

    @Test
    public void test_add_element_to_empty_list(){
        CustomList<Integer> test = CustomDoublyLinkedList.of();
        assertThrows(IndexOutOfBoundsException.class, () -> test.add(12, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> test.add(13, 10));
        test.add(10, 0);
        test.add(11, 1);
        test.add(12, 1);

        assertEquals(10, test.get(0));
        assertEquals(12, test.get(1));
        assertEquals(11, test.get(2));

    }

    @Test
    public void test_add_first_element(){
        CustomList<Integer> test = CustomDoublyLinkedList.of();
        test.addFirst(2);
        test.addFirst(1);
        assertEquals(2, test.get(1));
        assertEquals(1, test.get(0));
    }

    @Test
    public void test_add_last_element(){
        CustomList<Integer> test = CustomDoublyLinkedList.of();
        test.addLast(4);
        test.addLast(5);
        test.addLast(1);
        assertEquals(4, test.get(0));
        assertEquals(5, test.get(1));
        assertEquals(1, test.get(2));
    }

    @Test
    public void test_remove_element(){
        CustomList<Integer> test = CustomDoublyLinkedList.of(1, 2, 3, 4, 5);
        test.remove(0);
        assertEquals(2, test.get(0));

        test.remove(1);
        assertEquals(4, test.get(1));

        test.remove(2);
        assertEquals(4, test.get(1));

        assertThrows(IndexOutOfBoundsException.class, () -> test.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> test.remove(10));

    }

    @Test
    public void test_remove_first_element(){
        CustomList<Integer> test = CustomDoublyLinkedList.of( 3, 4, 5);
        test.removeFirst();
        assertEquals(4, test.get(0));
        test.removeFirst();
        assertEquals(5, test.get(0));
    }

    @Test
    public void test_remove_last_element(){
        CustomList<Integer> test = CustomDoublyLinkedList.of( 1, 2, 3);
        test.removeLast();
        assertEquals(2, test.get(test.size() - 1));
        test.removeLast();
        assertEquals(1, test.get(test.size() - 1));
    }

    @Test
    public void test_clear_elements(){
        CustomList<Integer> test = CustomDoublyLinkedList.of( 1, 2, 3);
        test.clear();
        assertTrue(test.isEmpty());
    }

    @Test
    public void test_size(){
        CustomList<Integer> test = CustomDoublyLinkedList.of(1, 2, 3, 4, 5);
        assertEquals(5, test.size());
    }

    @Test
    public void test_is_empty(){
        CustomList<Integer> test = CustomDoublyLinkedList.of();
        assertTrue(test.isEmpty());
    }

    @Test
    public void test_contains(){
        CustomList<Integer> test = CustomDoublyLinkedList.of(1, 2, 3, 4, 5);
        assertTrue(test.contains(1));
        assertTrue(test.contains(4));
        assertFalse(test.contains(10));
        assertFalse(test.contains(12));
    }

    @Test
    public void test_get(){
        CustomList<Integer> test = CustomDoublyLinkedList.of(1, 2, 3, 4, 5);
        assertEquals(3, test.get(2));
        assertEquals(5, test.get(4));
        assertNull(test.get(10));
    }

    @Test
    public void test_get_first(){
        CustomList<Integer> test = CustomDoublyLinkedList.of(1, 2, 3, 4, 5);
        assertEquals(1, test.getFirst());
    }

    @Test
    public void test_get_last(){
        CustomList<Integer> test = CustomDoublyLinkedList.of(1, 2, 3, 4, 5);
        assertEquals(5, test.getLast());
    }

    @Test
    public void test_poll(){
        CustomList<Integer> test = CustomDoublyLinkedList.of(1, 2, 3, 4, 5);
        Integer item = test.poll(2);
        assertEquals(2, item);
        assertEquals(1, test.get(0));
        assertEquals(3, test.get(1));
        assertEquals(4, test.get(2));
        assertEquals(5, test.get(3));
        assertEquals(4, test.size());
    }
}