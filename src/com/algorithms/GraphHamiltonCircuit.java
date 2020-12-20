package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphHamiltonCircuit {
    private int vertexes;
    private int[][] adj;

    public int getVertexes() {
        return vertexes;
    }

    public int[][] getAdj() {
        return adj;
    }

    public GraphHamiltonCircuit(int vertexes) {
        this.vertexes = vertexes;
        adj = new int[vertexes][vertexes];
        for (int i = 0; i < vertexes; i++)
            for (int j = 0; j < vertexes; j++)
                if (i != j)
                    adj[i][j] = 0;
    }

    public void addEdge(int i, int j) {
        adj[i][j] = 1;
    }

    public void removeEdge(int i, int j) {
        adj[i][j] = 0;
    }

    public boolean hasEdge(int i, int j) {
        return (adj[i][j] != 0);
    }

    public List<Integer> neighbours(int vertex) {
        List<Integer> edges = new ArrayList<>();
        for (int i = 0; i < vertexes; i++) {
            if (hasEdge(vertex, i))
                edges.add(i);
        }
        return edges;
    }

    public void print() {
        for (int i = 0; i < vertexes; i++) {
            List<Integer> edges = neighbours(i);
            System.out.print(i + " ");
            for (int j = 0; j < edges.size(); j++) {
                System.out.print(edges.get(j) + " ");
            }
            System.out.println();
        }
    }

    public void hamCircuit() {
        int[] path = new int[vertexes];
        Arrays.fill(path, -1);
        path[0] = 0;
        if (!solveHamCircuit(path, 1)) {
            System.out.println("Solution doesnt exist");
        } else {
            System.out.print("Solution --> ");
            for (int i = 0; i < vertexes; i++)
                System.out.print(path[i] + " ");
        }
    }

    public boolean canBeAdded(int v, int[] path, int pos) {
        if (adj[pos - 1][v] == 0) return false;
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) return false;
        }
        return true;
    }

    public boolean solveHamCircuit(int[] path, int pos) {
        if (pos == vertexes) {
            return adj[path[pos - 1]][path[0]] == 1;
        }
        for (int v = 1; v < vertexes; v++) {
            if (canBeAdded(v, path, pos)) {
                path[pos] = v;
                if (solveHamCircuit(path, pos + 1))
                    return true;
                path[pos] = -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphHamiltonCircuit graph = new GraphHamiltonCircuit(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 4);
        graph.addEdge(3, 0);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        graph.print();
        graph.hamCircuit();
    }

}
