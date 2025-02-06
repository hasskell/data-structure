package org.datastructures.interfaces;

import java.util.List;

public interface Graph<T> {

    void addVertex(T vertex);

    void removeVertex(T vertex);

    void addEdge(T edge1, T edge2);

    int vertexCount();

    int edgeCount();

}
