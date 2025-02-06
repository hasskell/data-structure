package org.datastructures.graphs;

import org.datastructures.interfaces.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndirectedGraph<T> implements Graph<T> {

    private final Map<Vertex<T>, List<Vertex<T>>> graph;

    public UndirectedGraph() {
        this.graph = new HashMap<>();
    }

    public static <T> UndirectedGraph<T> of() {
        return new UndirectedGraph<>();
    }

    @Override
    public void addVertex(T vertex) {
        Vertex<T> vertexToAdd = Vertex.<T>builder()
                .withData(vertex)
                .build();
        this.graph.putIfAbsent(vertexToAdd, new ArrayList<>());
    }

    @Override
    public void removeVertex(T vertex) {
        Vertex<T> vertexToRemove = Vertex.<T>builder()
                .withData(vertex)
                .build();
        this.graph.remove(vertexToRemove);
    }

    @Override
    public void addEdge(T edge1, T edge2) {
        Vertex<T> vertex1 = this.graph.keySet().stream()
                .filter(v -> v.data.equals(edge1))
                .findFirst()
                .orElse(Vertex.<T>builder().withData(edge1).build());

        Vertex<T> vertex2 = this.graph.keySet().stream()
                .filter(v -> v.data.equals(edge2))
                .findFirst()
                .orElse(Vertex.<T>builder().withData(edge2).build());

        this.graph.computeIfAbsent(vertex1, k -> new ArrayList<>()).add(vertex2);
        this.graph.computeIfAbsent(vertex2, k -> new ArrayList<>()).add(vertex1);
    }

    @Override
    public int vertexCount() {
        return this.graph.size();
    }

    @Override
    public int edgeCount() {
        int edgeCount = 0;

        for (Vertex<T> vertex : this.graph.keySet()) {
            edgeCount += this.graph.get(vertex).size();
        }
        return edgeCount;
    }

    public List<Vertex<T>> getNeighbors(T vertex) {
        return this.graph.keySet().stream()
                .filter(v -> v.data.equals(vertex))
                .toList();
    }
}
