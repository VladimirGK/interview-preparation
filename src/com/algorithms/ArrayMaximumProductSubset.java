package com.algorithms;

public class ArrayMaximumProductSubset {
    static int maxProductSubset(int[] a, int n) {
        if (n == 1) return a[0];
        int maxNegative = Integer.MIN_VALUE;
        int countNegative = 0, countZero = 0;
        int products = 1;
        for (int i = 0; i < n; i++) {

            if (a[i] == 0) {
                countZero++;
                continue;
            }
            if (a[i] < 0) {
                countNegative++;
                maxNegative = Math.max(maxNegative, a[i]);
            }
            products = products * a[i];
        }
        if (countZero == n) return 0;
        if (countNegative % 2 == 1) {
            if (countNegative == 1 && countZero > 0 && countZero + countNegative == n) return 0;
            products = products / maxNegative;
        }
        return products;
    }

    public static void main(String[] args) {
        int[] a = {-1, -1, -2, 4, 3};
        int n = a.length;
        System.out.println(maxProductSubset(a, n));
    }
}
