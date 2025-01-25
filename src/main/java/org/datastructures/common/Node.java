package org.datastructures.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder(setterPrefix = "with")
public class Node<T> {
    public T value;
    public Node<T> next;
}