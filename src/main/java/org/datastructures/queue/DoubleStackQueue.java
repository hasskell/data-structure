package org.datastructures.queue;

import org.datastructures.interfaces.Queue;

import java.util.Stack;

public class DoubleStackQueue <T> implements Queue<T> {
    private final Stack<T> input;
    private final Stack<T> output;

    private DoubleStackQueue() {
        this.input = new Stack<>();
        this.output = new Stack<>();
    }

    public static <T> DoubleStackQueue<T> of(){
        return new DoubleStackQueue<>();
    }

    @Override
    public void enqueue(T element) {

    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T peek() {
        return null;
    }
}
