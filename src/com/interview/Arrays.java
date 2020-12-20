package com.interview;

import java.math.BigInteger;
import java.util.*;

import static java.util.Arrays.sort;

public class Arrays {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 7, 8};
        System.out.println(missingNumberFast(arr));
    }

    // Find the missing number in a given range of 1...? // 1 3 4 5 6 7 8 --> 2
    // 0 1 2 3 4 5 6
    static int missingNumberSlow(int[] arr) { // O(n)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return arr[i] - 1;
            }
        }
        return -1;
    }

    static int missingNumberFast(int[] arr) { // O(log n)
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] != mid + 1 && arr[mid - 1] == mid) {
                return (mid + 1);
            }
            if (arr[mid] != mid + 1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    // Find the first duplicate number on a given integer array
    static int findDuplicateSlow(int[] arr) { // O(n ^ n)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    static int findDuplicateFast(int[] arr) { // O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            } else {
                return arr[i];
            }
        }
        return -1;
    }

    // Find the k'th smallest/largest element in unsorted array
    static int findSmallest(int[] arr, int k) {
        if (k >= arr.length) return -1;
        sort(arr);
        return arr[k - 1];
    }

    // Find all pairs of an integer array whose sum is equal to a given number
    static int getPairsSlow(int[] arr, int sum) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int differ = sum - arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == differ) count++;
            }
        }
        return count;
    }

    static int getPairsFast(int[] arr, int sum) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int value : arr) {
            int target = sum - value;
            if (!set.contains(target))
                set.add(value);
            else
                count++;
        }
        return count;
    }

    // Remove duplicates
    static void removeDuplicates(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        //for(int i=0;i<arr.length;i++)
        //   list.add(arr[i]);
        //List<Integer> newList = list.stream().distinct().collect(Collectors.toList());

        //for(int ele : arr) {
        //    if(!list.contains(ele))
        //       list.add(ele);
        //}
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
    }

    // Rotate left 'd' times
    static void moveLeftByOne(int[] arr) {
        int temp = arr[0];
        for (int j = 0; j < arr.length - 1; j++)
            arr[j] = arr[j + 1];
        arr[arr.length - 1] = temp;
    }

    static int[] rotateLeft(int[] arr, int d) {
        for (int i = 0; i < d; i++) {
            moveLeftByOne(arr);
        }
        return arr;
    }

    // Given the arrays find which number is not present in the second array
    static int findNotPresentNumber(int[] first, int[] second) {
        // 1 2 3 4 5
        // 5 4 2 1 0
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < first.length; i++) {
            set.add(first[i]);
        }
        for (int i = 0; i < second.length; i++) {
            if (!set.contains(second[i]))
                return second[i];
        }
        return -1;
    }

    // Find the index of array where leftSum is equal to rightSum
    public static int binarySearch(int[] arr, int mid, int end, int sumLeft, int sumRight,
                                   boolean wasLeftLarger, boolean wasRightLarger) {
        if (end > mid && mid > -1) {
            for (int i = 0; i < mid; i++)
                sumLeft += arr[i];
            for (int i = mid + 1; i < end; i++)
                sumRight += arr[i];
            if (sumLeft == sumRight)
                return mid;
            if (sumLeft > sumRight) {
                if (wasRightLarger == true)
                    return -1;
                return binarySearch(arr, mid - 1, end, 0, 0, true, false);
            }
            if (sumLeft < sumRight) {
                if (wasLeftLarger == true)
                    return -1;
                return binarySearch(arr, mid + 1, end, 0, 0, false, true);
            }
        }
        return -1;
    }
    // 1 5 2 5 8
}
