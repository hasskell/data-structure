package org.datastructures.graphs;

import java.util.*;

public class Traversal {

    public static <T> List<Vertex<T>> dfs(UndirectedGraph<T> graph, Vertex<T> root) {
        Stack<Vertex<T>> stack = new Stack<>();
        Set<Vertex<T>> visited = new HashSet<>();
        List<Vertex<T>> path = new ArrayList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Vertex<T> vertex = stack.pop();
            if (!visited.contains(vertex)) {
                path.add(vertex);
                visited.add(vertex);
                List<Vertex<T>> v = graph.getNeighbors(vertex.data);
                for (Vertex<T> neighbor : v) {
                    stack.push(neighbor);
                }
            }
        }
        return path;
    }

    public static <T> List<Vertex<T>> bfs(UndirectedGraph<T> graph, Vertex<T> root) {
        List<Vertex<T>> path = new ArrayList<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        Set<Vertex<T>> visited = new HashSet<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            Vertex<T> vertex = queue.poll();
            if (!visited.contains(vertex)) {
                path.add(vertex);
                visited.add(vertex);
                List<Vertex<T>> v = graph.getNeighbors(vertex.data);
                for (Vertex<T> neighbor : v) {
                    queue.add(neighbor);
                }
            }
        }
        return path;
    }
}
