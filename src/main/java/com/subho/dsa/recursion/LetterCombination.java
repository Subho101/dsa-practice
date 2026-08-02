package com.subho.dsa.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombination {

    private static Map<Character, String[]> map = Map.of(
            '2', "abc".split(""),
            '3', "def".split(""),
            '4', "ghi".split(""),
            '5', "jkl".split(""),
            '6', "mno".split(""),
            '7', "pqrs".split(""),
            '8', "tuv".split(""),
            '9', "wxyz".split("")

    );

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        helper(0, "", digits, result);
        return result;
    }

    private static void helper(int i, String soFar, String digits, List<String> result) {
        if (i == digits.length()) {
            result.add(soFar);
            return;
        }

        String[] possibleChars = map.get(digits.charAt(i));
        for (String s : possibleChars) {
            helper(i + 1, soFar + s, digits, result);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
