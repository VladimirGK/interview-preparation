package com.datastructures;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {
    private Map<Integer, Integer> parent = new HashMap();

    private void makeSet(int[] universe) {
        for (int i : universe)
            parent.put(i, i);
    }

    private int find(int k) {
        if (parent.get(k) == k)
            return k;
        return find(parent.get(k));
    }

    private void union(int x, int y) {
        int x_set = find(x);
        int y_set = find(y);

        parent.put(x_set, y_set);
    }

    public static void printSets(int[] universe, UnionFind un) {
        for (int i : universe)
            System.out.print(un.find(i) + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] universe = {1, 2, 3, 4, 5};
        UnionFind un = new UnionFind();
        un.makeSet(universe);
        printSets(universe, un);

        un.union(4, 3);
        printSets(universe, un);

        un.union(4, 1);
        printSets(universe, un);

    }
}
