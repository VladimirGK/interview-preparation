package com.interview;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class InterviewAlgorithms {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 4};
        System.out.print(isBalanced(arr));
    }

    /**
     * String code interview
     */
    // Is string a palindrome or not?
    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
        }
        return true;
    }

    // Longest palindrome in a given string
    public static String longestPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            String subString = str.substring(i);
            if (isPalindrome(subString)) {
                return subString;
            }
        }
        return "";
    }

    // Find the first repeated character
    public static char firstRepeated(char[] arr) {
        HashSet<Character> set = new HashSet<>();
        for (char c : arr) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                return c;
            }
        }
        return ' ';
    }

    // Find the first non repeated character
    public static char firstNonRepeated(char[] arr) {
        Map<Character, Integer> map = new HashMap<>();
        // a a a b b c d
        for (char c : arr) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (char c : arr) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    // Count occurrence of a given character
    public static int occurrence(char[] arr, char c) {
        int count = 0;
        for (char ch : arr) {
            if (c == ch) count++;
        }
        return count;
    }

    // Is String anagram
    public static boolean isAnagram(char[] first, char[] second) {
        // SAFE - FESA
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }

    // Print duplicate characters from a string
    public static void printDuplicate(char[] arr) {
        Set<Character> set = new HashSet<>();
        for (char c : arr) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                System.out.println(c);
            }
        }
    }

    /**
     * Arrays code interview
     */
    // Paysafe Interview: Find the missing number in a given range of 1...?
    public static int missingNumberInRange(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] != middle + 1 && arr[middle - 1] == middle) {
                return middle + 1;
            }
            if (arr[middle] != middle + 1) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    // Paysafe Interview: Find the index of array where leftSum is equal to rightSum
    public static int equalSums(int[] arr) {
        int leftSum = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
            if (leftSum == sum) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    // VMWARE Interview: Is array balanced | Print the smallest element to be balanced
    public static int isBalanced(int[] arr) {
        int sumLeft = 0, sumRight = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            sumLeft += arr[i];
            sumRight += arr[arr.length - i - 1];
        }
        return Math.abs(sumLeft - sumRight);
    } // 1 2 3 4 5 | 6 2 7 9 4 2

    // Find the first duplicate number on a given integer array
    public static int findFirstDuplicate(int[] arr) {
        Set<Integer> map = new HashSet<>();
        for (int ele : arr) {
            if (!map.contains(ele)) {
                map.add(ele);
            } else {
                return ele;
            }
        }
        return -1;
    }

    // Find all pairs of an integer array whose sum is equal to a given number
    public static void getPairs(int[] arr, int number) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int ele : arr) {
            int differ = number - ele;
            if (!set.contains(differ)) {
                set.add(ele);
            } else {
                count++;
            }
        }
    }

    // Remove duplicates
    public static void removeDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int ele : arr) {
            set.add(ele);
        }

    }

    // Rotate left 'd' times
    public static void rotate(int[] arr, int k) {
        for (int j = 0; j < k; j++) {
            int firstNumber = arr[0];
            for (int i = 1; i < arr.length; i++) {
                arr[i - 1] = arr[i];
            }
            arr[arr.length - 1] = firstNumber;
        }
    }

    // Given two arrays find which number is not present in the second array
    public static void findNotPresent(int[] first, int[] second) {
        Set<Integer> firstSet = new HashSet<>();
        for (int ele : first) {
            firstSet.add(ele);
        }
        for (int ele : second) {
            if (!firstSet.contains(ele)) {
                System.out.print(ele + " ");
            }
        }
    }

    /**
     * Linked List code interview
     */
    // Get middle element in linked list
    public static int getMiddleElement(List<Integer> list) {
        Iterator<Integer> iterator = list.listIterator();
        int i = 0;
        while (iterator.hasNext()) {
            if (i == list.size() / 2) {
                return list.get(i);
            } else {
                i++;
                iterator.next();
            }
        }
        return -1;
    }

    // Get the 3rd element from last in a single pass
    public static int get3rdElement(List<Integer> list) {
//        Node current = head.next.next;
//        Node second = head;
//        while(current.next != null) {
//            current = current.next;
//            second = head.next;
//        }
//        return second.data;

        return -1;
    }

    /**
     * Binary Tree code interview
     */
    private class Node {
        int data;
        Node left, right;

        public Node(int elem) {
            this.data = elem;
            this.left = null;
            this.right = null;
        }
    }

    // Algorithm for checking if binary tree is BST
    public static boolean isBST(Node root) {
        return false;
    }

    // Given two trees find the there biggest common sub tree
}
