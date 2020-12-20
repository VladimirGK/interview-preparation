package com.algorithms;

public class ArrayMinimumProductSubset {
    static int minProductSubset(int[] a, int n) {
        if (n == 1) return a[0];

        int negativeMax = Integer.MIN_VALUE;
        int positiveMin = Integer.MAX_VALUE;
        int countNegative = 0, countZero = 0;
        int product = 1;

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                countZero++;
                continue;
            }
            if (a[i] < 0) {
                countNegative++;
                negativeMax = Math.max(negativeMax, a[i]);
            }
            if (a[i] > 0 && a[i] < positiveMin)
                positiveMin = a[i];
            product *= a[i];
        }
        if (countZero == n || (countNegative == 0 && countZero > 0))
            return 0;
        if (countNegative == 0)
            return positiveMin;
        if (countNegative % 2 == 0 && countNegative != 0)
            product = product / negativeMax;
        return product;
    }

    public static void main(String[] args) {
        int[] a = {-1, -1, -2, 4, 3};
        int n = a.length;
        System.out.println(minProductSubset(a, n));
    }
}
