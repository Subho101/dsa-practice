package com.subho.dsa.binary_search;

import java.util.Arrays;

public class FindRange {
    public static int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, target);

        if (lb == nums.length || nums[lb] != target) {
            return new int[] { -1, -1 };
        }

        int ub = upperBound(nums, target);

        return new int[] { lb, ub - 1 };
    }

    public static int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int upperBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        System.out.println(Arrays.toString(searchRange(nums, target)));

        int[] nums2 = { 5, 7, 7, 8, 8, 10 };
        int target2 = 6;

        System.out.println(Arrays.toString(searchRange(nums2, target2)));
    }
}
