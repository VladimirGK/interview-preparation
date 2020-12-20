package com.datastructures;

import java.util.*;

public class Main {
    public static int maxProfit(int[] arr) {
//        int min = Arrays.stream(arr).min().getAsInt();
//        int max = Arrays.stream(arr).max().getAsInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
            if (j < min) {
                min = j;
            }
        }
        return max - min;
    }

    public static int uniqueCount(int A, int B) {
        int count = 0;
        while (A <= B) {
            if (isUnique(A)) {
                count++;
            }
            A++;
        }
        return count;
    }

    private static boolean isUnique(int number) {
        HashSet<Integer> set = new HashSet<>();
        while (number != 0) {
            int a = number % 10;
            if (!set.contains(a)) {
                set.add(a);
            } else {
                return false;
            }
            number /= 10;
        }
        return true;
    }

    public static int firstMissingPositive(int[] arr) {
        List<int[]> list = Arrays.asList(arr);
        if (arr[0] != 1) {
            return 1;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= 0) {
                continue;
            }
            if (arr[i] + 1 != arr[i + 1]) {
                return arr[i] + 1;
            }
        }
        return -1;
    }

    // Опашка за дюнери
    public static int findClosestFreePlace(String s) {
        char[] arr = s.toCharArray();
        if (!s.contains("-")) {
            return -1;
        }
        int result = 0;
        int innerFirstResult = 0, innerSecondResult = 0;
        if (arr[0] == '-') {
            int index = 1;
            while (index < arr.length - 1) {
                if (arr[index] == '-') {
                    index++;
                    innerFirstResult++;
                } else {
                    break;
                }
            }
        }
        if (arr[arr.length - 1] == '-') {
            int index = arr.length - 2;
            while (index >= 0) {
                if (arr[index] == '-') {
                    index--;
                    innerSecondResult++;
                } else {
                    break;
                }
            }
        }
        result = Math.max(innerFirstResult, innerSecondResult);
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == 'x') {
                continue;
            }
            if (arr[i - 1] == 'x' || arr[i + 1] == 'x') {
                continue;
            }
            int currentMaxDistance = maxDistance(arr, i);
            if (currentMaxDistance > result) {
                result = currentMaxDistance;
            }
        }
        return result;
    } // x---x-----

    private static int maxDistance(char[] arr, int index) {
        int leftResult = 0, rightResult = 0;
        if (index >= 1) {
            for (int i = index - 1; i >= 0; i--) {
                if (arr[i] == '-') {
                    leftResult++;
                } else {
                    break;
                }
            }
        }
        if (index + 1 < arr.length) {
            for (int i = index + 1; i < arr.length; i++) {
                if (arr[i] == '-') {
                    rightResult++;
                } else {
                    break;
                }
            }
        }
        return Math.max(leftResult, rightResult);
    }

    public static int findDistinct(int number) {
        int result = 0;
        int s = number;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 9);
        map.put(2, 9 * 9);
        map.put(3, 9 * 9 * 8);
        map.put(4, 9 * 9 * 8 * 7);
        map.put(5, 9 * 9 * 8 * 7 * 6);
        map.put(6, 9 * 9 * 8 * 7 * 6 * 5);
        map.put(7, 9 * 9 * 8 * 7 * 6 * 5 * 4);
        map.put(8, 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3);
        map.put(9, 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2);
        map.put(10, 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2);

        List<Integer> arr = new ArrayList<>();
        number++;

        while (number != 0) {
            arr.add(number % 10);
            number /= 10;
        }

        Collections.reverse(arr);

        for (int i = 1; i < arr.size(); i++) {
            result += map.get(i);
        }

        int test = (int) Math.pow(10, arr.size() - 1);

        while (test <= s) {
            if (isUnique(test)) {
                result++;
            }
            test++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        System.out.println(findDistinct(B) - findDistinct(A - 1));
    }
} // 1 -> 2 -> 3 -> 6
