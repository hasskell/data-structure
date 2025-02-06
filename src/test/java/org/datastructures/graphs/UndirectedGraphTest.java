package org.datastructures.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UndirectedGraphTest {

    private UndirectedGraph<String> graph;

    @BeforeEach
    void setUp() {
        this.graph = UndirectedGraph.of();
    }

    @Test
    public void test_add_vertex() {
        this.graph.addVertex("A");
        this.graph.addVertex("B");
        this.graph.addVertex("C");
        this.graph.addVertex("D");
        this.graph.addVertex("E");

        assertEquals(5, this.graph.vertexCount());
        assertEquals(0, this.graph.edgeCount());
    }

    @Test
    public void test_add_edge() {
        this.graph.addVertex("A");
        this.graph.addVertex("B");
        this.graph.addVertex("C");
        this.graph.addVertex("D");
        this.graph.addVertex("E");

        this.graph.addEdge("A", "B");
        this.graph.addEdge("A", "C");
        this.graph.addEdge("A", "D");
        this.graph.addEdge("B", "E");
        this.graph.addEdge("B", "C");
        this.graph.addEdge("B", "D");

        assertEquals(5, this.graph.vertexCount());
        assertEquals(12, this.graph.edgeCount());
    }

    @Test
    public void test_bfs() {
        this.graph.addVertex("A");
        this.graph.addVertex("B");
        this.graph.addVertex("C");
        this.graph.addVertex("D");
        this.graph.addVertex("E");

        this.graph.addEdge("A", "B");
        this.graph.addEdge("A", "C");
        this.graph.addEdge("A", "D");
        this.graph.addEdge("B", "E");
        this.graph.addEdge("B", "C");
        this.graph.addEdge("B", "D");

        Traversal.bfs(this.graph, "A");

    }

}