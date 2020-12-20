package com.interview;

public class SearchingAndSorting {
    // Quick sort
    public void quickSort(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int pivot = arr[low + +(high - low) / 2];
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j++;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(arr, low, j);
        if (i < high)
            quickSort(arr, i, high);
    }

    // Merge sort
    public void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);

            merge(arr, low, middle, high);
        }
    }

    private void merge(int[] arr, int low, int middle, int high) {
        int leftSize = middle - low + 1;
        int rightSize = high - middle;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = arr[low + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = arr[middle + 1 + i];
        }
        int i = 0, j = 0, k = low;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Merge two sorted arrays
    public int[] mergeTwoArrays(int[] first, int[] second) {
        int i = 0, j = 0, k = 0;
        int[] answer = new int[first.length + second.length];
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                answer[k] = first[i];
                i++;
            } else {
                answer[k] = second[j];
                j++;
            }
            k++;
        }
        while (i < first.length) {
            answer[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            answer[k] = second[j];
            j++;
            k++;
        }
        return answer;
    }

    // Write binary search algorithm
    public int binarySearch(int[] arr, int low, int high, int x) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == x)
                return middle;
            if (arr[middle] > x)
                return binarySearch(arr, low, middle - 1, x);
            return binarySearch(arr, middle + 1, high, x);
        }
        return -1;
    }

    // Is array balanced
    private boolean isBalanced(int[] arr) {
        int sumLeft = 0, sumRight = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length / 2)
                sumLeft += arr[i];
            else
                sumRight += arr[i];
        }
        return sumLeft == sumRight;
    }

    public int solve(int[] arr) {
        int result = 0;
        while (true) {
            for (int i = 0; i < arr.length; i++) {
                int temp = arr[i];
                arr[i] += result;
                if (isBalanced(arr)) return result;
                arr[i] = temp;
            }
            result++;
        }
    }

}