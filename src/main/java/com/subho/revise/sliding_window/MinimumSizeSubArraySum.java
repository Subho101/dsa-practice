package com.subho.revise.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MinimumSizeSubArraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0;

        for(int r=0; r<nums.length; r++) {
            sum += nums[r];
            while (l <= r && sum >= target) {
                sum -= nums[l];
                minLen = Math.min(minLen, r-l+1);
                l++;
            }

        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static int minSubArrayLenBinarySearch(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;

        // TODO
        // Check the binary search option

        return minLen;
    }
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));
    }
}
