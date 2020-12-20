package com.algorithms;

import java.util.LinkedList;

public class GraphDetectCycle {

    static class Edge {
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }

        int getSource() {
            return source;
        }
    }

    static class Graph {
        private int vertices;
        private LinkedList<Edge>[] adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++)
                adjacencyList[i] = new LinkedList<>();
        }

        public void addEdge(int source, int destination) {
            Edge edge = new Edge(source, destination);
            adjacencyList[source].addFirst(edge);
        }

        public int find(int[] parent, int i) {
            if (parent[i] == i)
                return i;
            return find(parent, parent[i]);
        }

        public void union(int[] parent, int x, int y) {
            int x_set = find(parent, x);
            int y_set = find(parent, y);
            parent[x_set] = y_set;
        }

        public boolean isCycle() {
            int[] parent = new int[vertices];
            for (int i = 0; i < vertices; i++)
                parent[i] = i;
            for (int i = 0; i < vertices; i++) {
                for (Edge edge : adjacencyList[i]) {
                    int x = find(parent, edge.source);
                    int y = find(parent, edge.destination);
                    if (x == y)
                        return true;
                    union(parent, x, y);
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(3);
        graph.addEdge(0, 0);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        if (graph.isCycle())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}
