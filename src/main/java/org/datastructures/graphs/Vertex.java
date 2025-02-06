package org.datastructures.graphs;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Vertex<T> {
    T data;
}