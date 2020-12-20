package com.algorithms;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphDfsBfs {
    public static void main(String[] args) {
        Graph graph = new Graph();

        Graph.Vertex v0 = new Graph.Vertex("0");
        Graph.Vertex v1 = new Graph.Vertex("1");
        Graph.Vertex v2 = new Graph.Vertex("2");
        Graph.Vertex v3 = new Graph.Vertex("3");

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v0, v1, 2);
        graph.addEdge(v0, v2, 3);
        graph.addEdge(v1, v2, 1);
        graph.addEdge(v2, v0, 1);
        graph.addEdge(v2, v3, 4);
        graph.addEdge(v3, v3, 4);

        GraphDfsBfs bfs = new GraphDfsBfs(graph);
        bfs.DFS(v2);

    }


    private Graph graph;
    private boolean[] visited;

    public GraphDfsBfs(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.size()];
    }

    public void BFS(Graph.Vertex begin) {
        LinkedList<Graph.Vertex> queue = new LinkedList<>();
        LinkedList<Graph.Vertex> list = graph.getSet();
        visited[list.indexOf(begin)] = true;
        queue.add(begin);
        while (!queue.isEmpty()) {
            begin = queue.poll();
            System.out.print(begin + " ");
            for (Graph.Edge edge : begin.getEdges()) {
                if (!visited[list.indexOf(edge.getDestination())]) {
                    visited[list.indexOf(edge.getDestination())] = true;
                    queue.add(edge.getDestination());
                }
            }
        }
    }

    public void DFS(Graph.Vertex begin) {
        LinkedList<Graph.Vertex> list = graph.getSet();
        visited[list.indexOf(begin)] = true;
        System.out.print(begin + " ");
        Iterator<Graph.Vertex> it = list.listIterator();
        for (Graph.Edge edge : begin.getEdges()) {
            if (!visited[list.indexOf(edge.getDestination())]) {
                DFS(edge.getDestination());
            }
        }
    }
}
