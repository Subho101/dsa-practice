package com.subho.dsa.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CombinationSum3 {
    static int[] nums = IntStream.range(1, 10).toArray();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private static void helper(int start, int k, int target, List<Integer> temp, List<List<Integer>> result) {
        if (target == 0 && k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0 || k == 0) {
            return;
        }

        for (int num = start; num <= 9; num++) {
            temp.add(num);
            helper(num + 1, k - 1, target - num, temp, result);
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        int n = 7, k = 3;
        System.out.println(combinationSum3(k, n));
    }
}
