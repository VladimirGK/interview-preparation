package com.algorithms;

import javax.sound.midi.SysexMessage;

public class GreedyActivitySelection {
    public static void printMaxActivities(int[] s, int[] f, int n) {
        System.out.println("Following activities are selected: ");
        int i = 0, j;
        System.out.println(i + " ");
        for (j = 1; j < n; j++) {
            if (s[j] >= f[i]) {
                System.out.println(j + " ");
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        int[] s = {1, 3, 5, 5, 6, 5};
        int[] f = {2, 4, 8, 8, 9, 6};
        int n = s.length;
        printMaxActivities(s, f, n);
    }
}
