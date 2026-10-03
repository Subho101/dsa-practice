package com.subho.revise.sliding_window;

import java.util.Arrays;

/*
https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description/

You are given an array of integers nums of length n and a positive integer k.

The power of an array is defined as:

    Its maximum element if all of its elements are consecutive and sorted in ascending order.
    -1 otherwise.

You need to find the power of all subarrays of nums of size k.

Return an integer array results of size n - k + 1, where results[i] is the power of nums[i..(i + k - 1)].

Example 1:

Input: nums = [1,2,3,4,3,2,5], k = 3

Output: [3,4,-1,-1,-1]

Explanation:

There are 5 subarrays of nums of size 3:

    [1, 2, 3] with the maximum element 3.
    [2, 3, 4] with the maximum element 4.
    [3, 4, 3] whose elements are not consecutive.
    [4, 3, 2] whose elements are not sorted.
    [3, 2, 5] whose elements are not consecutive.


*/

public class FindPowerOfKSizeSubArrayI {
    public static int[] resultsArray(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Arrays.fill(result, -1);

        // Here, in the questions, Its is said that maximum element if all of its
        // elements are consecutive and sorted in ascending order.
        // -1 otherwise.

        /*
         * Find Power of K-Size Subarrays I — Approach
         * 
         * Each window of size k is valid only if its elements are consecutive and
         * strictly increasing.
         * Maintain a consecutiveCount while traversing the array:
         * If the current element is exactly previous + 1, increment the count.
         * Otherwise, reset the count to 1.
         * When consecutiveCount >= k, the current window of size k is valid.
         * Since the window is strictly increasing, its last element is automatically
         * the maximum.
         * If the condition is not satisfied, the result for that window remains -1.
         * 
         * Key idea to remember:
         * 
         * Instead of checking every window separately, maintain the length of the
         * current consecutive-increasing sequence. Once its length reaches k, the
         * current element is the answer for that window.
         * 
         * if k == 1, that means, every element is max element of window size 1, so
         * return the array immediately
         */

        int consecutiveCount = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1;
            }

            if (i >= k - 1) {
                if (consecutiveCount >= k) {
                    result[i - k + 1] = nums[i];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 3, 2, 5 };
        int k = 3;

        System.out.println(Arrays.toString(resultsArray(arr, k)));
    }
}
