package com.algorithms;

import java.util.Arrays;

// Complexity --> O(n log n)
// 1) Split the array of subarrays until all elements are separated
// 2) Merge the elements sorting them
// TO USE: 1) When data structure doesnt support random access 2) Used for stable sort
public class SortMerge {

    public static void main(String args[]) {
        Integer arr[] = {12, 11, 13, 4, 6, 7};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static Comparable[] mergeSort(Comparable[] list) {
        if (list.length <= 1) return list;
        Comparable[] first = new Comparable[list.length / 2];
        Comparable[] second = new Comparable[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        mergeSort(first);
        mergeSort(second);

        merge(first, second, list);
        return list;
    }

    public static void merge(Comparable[] first, Comparable[] second, Comparable[] result) {
        int iFirst = 0, iSecond = 0, iMerged = 0;
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].compareTo(second[iSecond]) < 0) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }
}
