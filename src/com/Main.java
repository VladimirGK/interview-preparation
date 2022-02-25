package com;

import java.util.*;

public class Main {
    static class Pair {
        public int start;
        public int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
        

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return start == pair.start &&
                    end == pair.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        public boolean isBetween(int number) {
            return (number >= start && number <= end);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Pair> intervals = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            intervals.add(new Pair(s, e));
        }
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int count = 0;
            for (Pair interval : intervals) {
                if (interval.isBetween(l)) {
                    count++;
                }
            }
            System.out.print(count + " ");
        }
    }
}
