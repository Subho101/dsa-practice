package com.subho.dsa.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSumK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixMap.containsKey(prefixSum - k)) {
                count += prefixMap.get(prefixSum - k);
            }

            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, -3, 1, 1, 1};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }
}
