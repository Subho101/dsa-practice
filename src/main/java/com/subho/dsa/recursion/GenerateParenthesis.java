package com.subho.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        helper(n, 1, "(", result);

        return result;
    }

    private static void helper(int n, int count, String soFar, List<String> result) {
        if (count < 0)
            return;
        if (soFar.length() == 2 * n) {
            if (count == 0) {
                result.add(soFar);
            }
            return;
        }

        helper(n, count + 1, soFar + "(", result);
        helper(n, count - 1, soFar + ")", result);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
