package com.algorithms;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class GraphDijkstra {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge>[] adjacencyList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++)
                adjacencyList[i] = new LinkedList<>();
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencyList[source].addFirst(edge);

            edge = new Edge(destination, source, weight);
            adjacencyList[destination].addFirst(edge);
        }

        public void dijkstraGetMinDistances(int sourceVertex) {
            boolean[] SPT = new boolean[vertices];
            int[] distance = new int[vertices];
            int[] parentVertex = new int[vertices];

            parentVertex[0] = -1;
            for (int i = 0; i < vertices; i++)
                distance[i] = Integer.MAX_VALUE;

            PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(vertices,
                    new Comparator<Pair<Integer, Integer>>() {
                        @Override
                        public int compare(Pair<Integer, Integer> t1, Pair<Integer, Integer> t2) {
                            return t1.getKey() - t2.getKey();
                        }
                    });
            distance[0] = 0;
            Pair<Integer, Integer> p0 = new Pair<>(distance[0], 0);
            pq.offer(p0);
            while (!pq.isEmpty()) {
                Pair<Integer, Integer> extractedPair = pq.poll();
                int extractedVertex = extractedPair.getValue();
                if (!SPT[extractedVertex]) {
                    SPT[extractedVertex] = true;
                    LinkedList<Edge> list = adjacencyList[extractedVertex];
                    for (Edge edge : list) {
                        int destination = edge.destination;
                        if (!SPT[destination]) {
                            int newKey = distance[extractedVertex] + edge.weight;
                            int currentKey = distance[destination];
                            if (currentKey > newKey) {
                                Pair<Integer, Integer> p = new Pair<>(newKey, destination);
                                pq.offer(p);
                                distance[destination] = newKey;
                                parentVertex[destination] = extractedVertex;
                            }
                        }
                    }
                }
            }
            printDijkstra(parentVertex, distance, sourceVertex);
        }

        public void printDijkstra(int[] parent, int[] distance, int sourceVetex) {
            System.out.println("Dijkstra Algorithm: ");
            for (int i = 0; i < vertices; i++) {
                System.out.print("Source Vertex: " + sourceVetex + " to vertex " +
                        i + " distance: " + distance[i] + " Path: ");
                printPathUtil(parent, i);
                System.out.println();
            }
        }

        public void printPathUtil(int[] parent, int destination) {
            if (parent[destination] == -1) {
                System.out.print("0 ");
                return;
            }
            printPathUtil(parent, parent[destination]);
            System.out.print(destination + " ");
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.dijkstraGetMinDistances(0);
    }
}
