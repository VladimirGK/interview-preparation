package com.algorithms;

import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
    static class Vertex {
        private String name;
        private LinkedList<Edge> edgeList;

        public Vertex(String name) {
            this.name = name;
            edgeList = new LinkedList<Edge>();
        }

        public String getName() {
            return name;
        }

        public LinkedList<Edge> getEdges() {
            return edgeList;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Edge {
        private int weight;
        private Vertex destination;

        public Edge(Vertex dest, int w) {
            this.destination = dest;
            this.weight = w;
        }

        public Edge(Vertex dest) {
            this.destination = dest;
            this.weight = 1;
        }

        public int getWeight() {
            return weight;
        }

        public Vertex getDestination() {
            return destination;
        }
    }

    private LinkedList<Vertex> nodes;

    public Graph() {
        nodes = new LinkedList<>();
    }

    public boolean addVertex(Vertex v) {
        return nodes.add(v);
    }

    public boolean addEdge(Vertex v1, Vertex v2, int weight) {
        return v1.getEdges().add(new Edge(v2, weight));
        //v2.getEdges().add(new Edge(v1, weight)); * FOR UNDIRECTED GRAPH *
    }

    public int size() {
        return nodes.size();
    }

    public LinkedList<Vertex> getSet() {
        return nodes;
    }

    public void printGraph() {
        for (Vertex v : nodes) {
            System.out.println("Vertex name: " + v.getName());
            for (Edge e : v.getEdges()) {
                System.out.print("Destination Vertex: " + e.getDestination().getName() +
                        " with weight " + e.getWeight() + "  |  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v0, v1, 2);
        graph.addEdge(v1, v2, 3);
        graph.addEdge(v2, v0, 1);
        graph.addEdge(v2, v3, 1);
        graph.addEdge(v3, v2, 4);

        graph.printGraph();
    }
}
