package com.subho.dsa.sliding_window;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfSubstringsAll3Char {
    // Brute
    public static int numberOfSubstrings(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(s.charAt(j));
                if (set.size() == 3) {
                    count = count + n - j;
                    break;
                }
            }
        }

        return count;
    }

    public static int numberOfSubstringsOpt(String s) {
        int count = 0, n = s.length();

        int[] hash = new int[3];
        Arrays.fill(hash, -1);

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            hash[ch - 97] = i;
            int minIndex = findMinIndex(hash);
            if (minIndex >= 0) {
                count = count + minIndex + 1;
            }
        }

        return count;
    }

    private static int findMinIndex(int[] hash) {

        return Math.min(Math.min(hash[0], hash[1]), hash[2]);
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstringsOpt(s));
    }
}
