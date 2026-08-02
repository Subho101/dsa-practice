package com.subho.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    public static List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> resultSet = new ArrayList<>();
        helper2(candidates, target, 0, new ArrayList<>(), resultSet);

        return new ArrayList<>(resultSet);
    }

    private static void helper(int[] candidates, int target, int i, List<Integer> temp, List<List<Integer>> result) {
        // Combination Sum I -- Allowed to take same element multiple times

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (i >= candidates.length)
            return;

        if (candidates[i] <= target) {
            temp.add(candidates[i]);
            helper(candidates, target - candidates[i], i, temp, result);
            temp.remove(temp.size() - 1);
        }

        helper(candidates, target, i + 1, temp, result);

    }

    private static void helper2(int[] candidates, int target, int i, List<Integer> temp,
            List<List<Integer>> result) {
        // Combination Sum II -- Not Allowed to take same element multiple times

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (i >= candidates.length)
            return;

        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j - 1] == candidates[j])
                continue;
            if (candidates[j] > target)
                break;
            System.out.println("i--" + i + " j " + j);
            temp.add(candidates[j]);
            helper2(candidates, target - candidates[j], j + 1, temp, result);
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        // int[] candidates = { 2, 3, 6, 7 };
        // int target = 7;

        // int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        // int target = 8;

        int[] candidates = { 1, 1, 1, 2, 2 };
        int target = 4;

        System.out.println(combinationSumII(candidates, target));
    }
}
