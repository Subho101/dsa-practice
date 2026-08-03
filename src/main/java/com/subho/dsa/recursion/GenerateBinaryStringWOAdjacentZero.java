package com.subho.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringWOAdjacentZero {
    public static List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();

        helper(n, "0", result, 1);
        helper(n, "1", result, 1);

        return result;
    }

    private static void helper(int n, String sofar, List<String> result, int i) {
        if (i == n) {
            result.add(sofar);
            return;
        }

        if (sofar.charAt(i - 1) == '0') {
            helper(n, sofar + "1", result, i + 1);
        } else {
            helper(n, sofar + '0', result, i + 1);
            helper(n, sofar + '1', result, i + 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(validStrings(n));
    }
}
