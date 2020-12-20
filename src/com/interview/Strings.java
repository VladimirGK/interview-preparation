package com.interview;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class Strings {
    // Is string a palindrome or not?
    static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }

    // Print all permutation of String
    static void printPermutation(String s, String result) {
        if (s.length() == 0) {
            System.out.println(result);
            return;
        } else {
            for (int i = 0; i < s.length(); i++) {
                String curr = s.substring(0, 1) + s.substring(i + 1);
                printPermutation(curr, result + s.charAt(i));
            }
        }
    }

    // Longest palindrome in a given string
    static String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, s.length());
            if (isPalindrome(temp)) {
                return temp;
            }
        }
        return "";
    }

    // Find the first non repeated character
    static char findNonRepeated(String s) {
        HashMap<Character, Integer> set = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.containsKey(s.charAt(i)))
                set.put(s.charAt(i), 1);
            else {
                set.put(s.charAt(i), set.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (set.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }
        return ' ';
    }

    // Count occurrence of a given character
    static int countOccurence(String s, char searched) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == searched) result++;
        }
        return result;
    }

    // Is string anagram
    static boolean isAnagram(String s, String anagram) {
        // PAYSAFE - SAFEPAY
        char[] sArray = s.toCharArray();
        char[] anagramArray = anagram.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(anagramArray);
        System.out.println(sArray);
        System.out.println(anagramArray);
        if (Arrays.equals(sArray, anagramArray)) return true;
        return false;
    }

    // Print duplicate characters from a string
    static void printDuplicate(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i)))
                System.out.println(s.charAt(i));
            else
                set.add(s.charAt(i));
        }
    }

    public static void main(String[] args) {
        String s = "PAYSAFE";
        System.out.println(isAnagram(s, "SAFEPAY"));
    }
}
// abbbac
// b