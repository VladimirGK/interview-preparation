package com.algorithms;

import java.util.Arrays;
import java.util.Random;

// Complexity --> O(n log n)
//
// 1) Select an element as a pivot element, generally from middle
// 2) Data elements are grouped into two parts: one with elements that are in lower order than pivot element.
// one with element that are in higher order than the pivot element
// 3) Sort the both parts separately by repeating step 1 and 2
// 4) С две думи, разделяме масива на под-масиви
//
// TO USE: When fast sorting is desired
// AVOID: 1) Space is limited
public class SortQuick {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{12, 15, 5, 2, 0, 16, 19};

        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(Integer[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(arr, low, j);
        if (high > i)
            quickSort(arr, i, high);
    }

    public static void swap(Integer array[], int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
