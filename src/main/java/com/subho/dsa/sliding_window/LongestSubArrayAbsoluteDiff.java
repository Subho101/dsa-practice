package com.subho.dsa.sliding_window;

import java.util.Collections;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/
*/

public class LongestSubArrayAbsoluteDiff {
    public static int longestSubarray(int[] nums, int limit) {

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        int maxLen = Integer.MIN_VALUE;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            int currElem = nums[r];
            minQ.offer(currElem);
            maxQ.offer(currElem);

            while ((!maxQ.isEmpty() || !minQ.isEmpty()) &&
                    (maxQ.peek() - minQ.peek() > limit)) {
                int start = nums[l];
                if (start == minQ.peek()) {
                    minQ.poll();
                } else {
                    maxQ.poll();
                }

                l++;
            }

            int minElem = minQ.peek();
            int maxElem = maxQ.peek();

            if (maxElem - minElem <= limit) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

        }

        return maxLen;
    }

    public static void main(String[] args) {
        assert longestSubarray(new int[] { 8, 2, 4, 7 }, 4) == 2
                : "Expected 2, but got " + longestSubarray(new int[] { 8, 2, 4, 7 }, 4);

        assert longestSubarray(new int[] { 10, 1, 2, 4, 7, 2 }, 5) == 4
                : "Expected 2, but got " + longestSubarray(new int[] { 10, 1, 2, 4, 7, 2 }, 5);

        assert longestSubarray(new int[] { 4, 2, 2, 2, 4, 4, 2, 2 }, 0) == 3
                : "Expected 2, but got " + longestSubarray(new int[] { 4, 2, 2, 2, 4, 4, 2, 2 }, 0);
    }
}
