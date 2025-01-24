package org.datastructures.queue;

import org.datastructures.interfaces.Queue;

import java.util.Stack;

/**
 * Implementation of Queue using two stack, one stack is served as Input
 * second stack as output, element are copied from input to output when
 * dequeue() method called which guaranties ordering of elements.
 * Peek element is backtracked which guaranties O(1) access to that elements
 * @param <T>
 */
public class DoubleStackQueue <T> implements Queue<T> {
    private final Stack<T> input;
    private final Stack<T> output;
    private T peekElement;

    private DoubleStackQueue() {
        this.input = new Stack<>();
        this.output = new Stack<>();
        this.peekElement = null;
    }

    public static <T> DoubleStackQueue<T> of(){
        return new DoubleStackQueue<>();
    }

    @Override
    public void enqueue(T element) {
        if (this.input.isEmpty()){
            this.peekElement = element;
        }
        this.input.push(element);
    }

    @Override
    public T dequeue() {
        if (!this.output.isEmpty()) {
            return this.output.pop();
        } else {
            while (!this.input.isEmpty()) {
                this.output.push(this.input.pop());
            }
            this.peekElement = null;
        }
        return this.output.isEmpty() ? null : this.output.pop();
    }

    @Override
    public boolean isEmpty() {
        return this.input.isEmpty() && this.output.isEmpty();
    }

    @Override
    public int size() {
        return this.input.size() + this.output.size();
    }

    @Override
    public T peek() {
        if(this.peekElement != null){
            return this.peekElement;
        }
        return this.output.isEmpty() ? null : this.output.peek();
    }
}
