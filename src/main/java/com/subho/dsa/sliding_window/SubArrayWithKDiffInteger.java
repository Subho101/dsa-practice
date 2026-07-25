package com.subho.dsa.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDiffInteger {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithKDistinctUtil(nums, k) - subarraysWithKDistinctUtil(nums, k - 1);
    }

    private static int subarraysWithKDistinctUtil(int[] nums, int k) {
        if (k < 0)
            return 0;
        int count = 0, l = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < nums.length; r++) {
            int num = nums[r];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while (l < nums.length && map.size() > k) {

                map.put(nums[l], map.get(nums[l]) - 1);

                if (map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            }

            if (map.size() <= k) {
                count += r - l + 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;

        System.out.println(subarraysWithKDistinct(nums, k));
    }
}
