package com.subho.dsa.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ShortestSubarrayWithSumAtleastK {
    public static int shortestSubarray(int[] nums, int k) {
        int minLen = Integer.MAX_VALUE;

        // Find the cumulative sum

        int[] cumulative = new int[nums.length + 1];
        cumulative[0] = 0;

        // In this dq, we will store the cumulative sum in a increasing order
        // Because when the sum decreases, and again increase
        // that means we will find same or closer sum
        // with less window size
        // So When in the dq, we see a sum that is greater than current cumsum
        // we will remove the sum from the back
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            cumulative[i + 1] = cumulative[i] + nums[i];
        }

        System.out.println(Arrays.toString(cumulative));

        for (int i = 0; i < cumulative.length; i++) {

            // Trying to shrink the window.
            // Here we will check whether removing the cumsum from the front, will still
            // result >= k
            while (!dq.isEmpty() && cumulative[i] - cumulative[dq.peekFirst()] >= k) {
                // means we can remove the cumsum
                // from the first and sum will be still greater than equal to k

                // we are storing the index in dq
                // for eg, if current index is 4 and we can remove 0 index
                // new length is 4-0 = 4
                minLen = Math.min(minLen, i - dq.peekFirst());

                // remove from the first
                dq.pollFirst();
            }

            // now before pushing the element
            // chekc in the dq, whether there are elements in the back
            // that is greater than current cumsum
            // we well remove it
            while (!dq.isEmpty() && cumulative[dq.peekLast()] >= cumulative[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;

    }

    public static void main(String[] args) {
        int[] nums = { 84, -37, 32, 40, 95 };
        int k = 167;
        System.out.println(shortestSubarray(nums, k));
    }
}
