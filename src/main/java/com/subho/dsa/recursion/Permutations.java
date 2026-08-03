package com.subho.dsa.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int num : nums) {
            visited.put(num, false);
        }

        // helper(nums, visited, new ArrayList<>(), result);
        helperOpt(0, nums, result);

        return result;
    }

    private static void helper(int[] nums, Map<Integer, Boolean> visited,
            List<Integer> temp, List<List<Integer>> result) {

        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int idx = 0; idx < nums.length; idx++) {
            if (!visited.get(nums[idx])) {
                temp.add(nums[idx]);
                visited.put(nums[idx], true);
                helper(nums, visited, temp, result);
                temp.remove(temp.size() - 1);
                visited.put(nums[idx], false);
            }
        }
    }

    private static void helperOpt(int index, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums)
                temp.add(num);
            result.add(temp);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(index, i, nums);
            helperOpt(index + 1, nums, result);
            swap(i, index, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
    }
}
