package com.algorithms;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphFindLongestPathDAG {
    static class Edge {
        int source, destination, weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.destination = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        List<List<Edge>> adjList = null;

        Graph(List<Edge> edges, int n) {
            adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
            for (Edge edge : edges) {
                adjList.get(edge.source).add(edge);
            }
        }
    }

    private static int DFS(Graph graph, int v, boolean[] visited, int[] departure, int time) {
        visited[v] = true;
        for (Edge e : graph.adjList.get(v)) {
            int u = e.destination;
            if (!visited[u])
                time = DFS(graph, u, visited, departure, time);
        }
        departure[time] = v;
        time++;
        return time;
    }

    public static void findLongestDistance(Graph graph, int source, int n) {
        int[] departure = new int[n];
        Arrays.fill(departure, -1);
        boolean[] visited = new boolean[n];
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                time = DFS(graph, i, visited, departure, time);
        }
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[source] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int v = departure[i];
            for (Edge e : graph.adjList.get(v)) {
                int u = e.destination;
                int w = e.weight * -1;
                if (cost[v] != Integer.MAX_VALUE && cost[v] + w < cost[u]) {
                    cost[u] = cost[v] + w;
                }
            }
        }
        for (int i = 0; i < n; i++)
            System.out.printf("dist(%d,%d) = %2d\n", source, i, cost[i] * -1);
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(0, 6, 2), new Edge(1, 2, -4),
                new Edge(1, 4, 1), new Edge(1, 6, 8), new Edge(3, 0, 3),
                new Edge(3, 4, 5), new Edge(5, 1, 2), new Edge(7, 0, 6),
                new Edge(7, 1, -1), new Edge(7, 3, 4), new Edge(7, 5, -4)
        );
        int n = 8;
        Graph graph = new Graph(edges, n);
        int source = 7;
        findLongestDistance(graph, source, n);
    }
}
