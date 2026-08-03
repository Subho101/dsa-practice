package com.subho.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets2 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void helper(int[] nums, int i, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp)); // Because every node is valid subset

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j - 1] == nums[j])
                continue;

            temp.add(nums[j]);
            helper(nums, j + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };
        System.out.println(subsetsWithDup(nums));
    }
}
