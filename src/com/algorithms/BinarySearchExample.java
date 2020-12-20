package com.algorithms;

public class BinarySearchExample {
    public static int pivotIndex(int[] arr, int middle, int end,
                                 int leftSum, int rightSum, boolean wasLeftLarger, boolean wasRightLarger) {
        if (middle > -1 && middle < end) {
            for (int i = 0; i < middle; i++) {
                leftSum += arr[i];
            }
            for (int i = middle + 1; i < end; i++) {
                rightSum += arr[i];
            }
            System.out.println(leftSum + " " + rightSum);
            if (leftSum > rightSum) {
                if (wasRightLarger)
                    return -1;
                return pivotIndex(arr, middle - 1,
                        end, 0, 0, true, false);
            } else if (leftSum < rightSum) {
                if (wasLeftLarger)
                    return -1;
                return pivotIndex(arr, middle + 1,
                        end, 0, 0, false, true);
            } else {
                return middle;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 0, 9};
        int middle = arr.length / 2;
        System.out.println(pivotIndex(arr, middle, arr.length,
                0, 0, false, false));
    }
}
