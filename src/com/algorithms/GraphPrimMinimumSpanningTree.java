package com.algorithms;

import com.datastructures.PriorityQueueList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class GraphPrimMinimumSpanningTree {
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

    static class HeapNode {
        int vertex;
        int key;
    }

    static class ResultSet {
        int parent;
        int weight;
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

        public void primMST() {
            boolean[] isPriorityQueue = new boolean[vertices];
            ResultSet[] resultSets = new ResultSet[vertices];
            int[] key = new int[vertices];
            HeapNode[] heapNodes = new HeapNode[vertices];
            for (int i = 0; i < vertices; i++) {
                heapNodes[i] = new HeapNode();
                heapNodes[i].vertex = i;
                heapNodes[i].key = Integer.MAX_VALUE;
                resultSets[i] = new ResultSet();
                resultSets[i].parent = -1;
                isPriorityQueue[i] = true;
                key[i] = Integer.MAX_VALUE;
            }
            heapNodes[0].key = 0;
            PriorityQueue<HeapNode> pq = new PriorityQueue<>(vertices,
                    Comparator.comparingInt(o -> o.key));
            for (int i = 0; i < vertices; i++)
                pq.offer(heapNodes[i]);
            while (!pq.isEmpty()) {
                HeapNode extractedNode = pq.poll();
                int extractedVertex = extractedNode.vertex;
                isPriorityQueue[extractedVertex] = false;
                LinkedList<Edge> list = adjacencyList[extractedVertex];
                for (int i = 0; i < list.size(); i++) {
                    Edge edge = list.get(i);
                    if (isPriorityQueue[edge.destination]) {
                        int destination = edge.destination;
                        int newKey = edge.weight;
                        if (key[destination] > newKey) {
                            decreaseKey(pq, newKey, destination);
                            resultSets[destination].parent = extractedVertex;
                            resultSets[destination].weight = newKey;
                            key[destination] = newKey;
                        }
                    }
                }
            }
            printMST(resultSets);
        }

        public void decreaseKey(PriorityQueue<HeapNode> pq, int newKey, int vertex) {
            Iterator it = pq.iterator();
            while (it.hasNext()) {
                HeapNode heapNode = (HeapNode) it.next();
                if (heapNode.vertex == vertex) {
                    pq.remove(heapNode);
                    heapNode.key = newKey;
                    pq.offer(heapNode);
                    break;
                }
            }
        }

        public void printMST(ResultSet[] resultSets) {
            int total_min_weight = 0;
            System.out.println("Minimum Spanning Tree: ");
            for (int i = 1; i < vertices; i++) {
                System.out.println("Edge: " + i + " - " +
                        resultSets[i].parent + " key: " +
                        resultSets[i].weight);
                total_min_weight += resultSets[i].weight;
            }
            System.out.println("Total minimum key: " + total_min_weight);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.primMST();
    }
}
