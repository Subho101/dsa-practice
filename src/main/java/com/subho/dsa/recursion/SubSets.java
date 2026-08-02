package com.subho.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void helper(int[] nums, int i, List<Integer> temp, List<List<Integer>> result) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        helper(nums, i + 1, temp, result);
        temp.remove(temp.size() - 1);
        helper(nums, i + 1, temp, result);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subsets(nums));
    }
}
