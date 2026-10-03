package com.subho.dsa.sliding_window;

import java.util.Collections;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/
*/

public class LongestSubArrayAbsoluteDiff {

    static class Pair {
        int elem;
        int index;
        Pair(int elem, int index) {
            this.elem = elem;
            this.index = index;
        }
    }

    public static int longestSubarray(int[] nums, int limit) {
        int maxLen = Integer.MIN_VALUE;
        PriorityQueue<Pair> minQ = new PriorityQueue<>((p1, p2) -> p1.elem - p2.elem);
        PriorityQueue<Pair> maxQ = new PriorityQueue<>((p1, p2) -> p2.elem - p1.elem);

        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            maxQ.add(new Pair(nums[r], r));
            minQ.add(new Pair(nums[r], r));

            while(l <= r && Math.abs(maxQ.peek().elem - minQ.peek().elem) > limit) {
                int shrinkIndex = Math.min(maxQ.peek().index, minQ.peek().index) + 1;
                while (!maxQ.isEmpty() && maxQ.peek().index < shrinkIndex) {
                    maxQ.poll();
                }

                while (!minQ.isEmpty() && minQ.peek().index < shrinkIndex) {
                    minQ.poll();
                }
                l = shrinkIndex;
            }

            maxLen = Math.max(maxLen, r-l+1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        assert longestSubarray(new int[] { 8, 2, 4, 7 }, 4) == 2
                : "Expected 2, but got " + longestSubarray(new int[] { 8, 2, 4, 7 }, 4);

        assert longestSubarray(new int[] { 10, 1, 2, 4, 7, 2 }, 5) == 4
                : "Expected 4, but got " + longestSubarray(new int[] { 10, 1, 2, 4, 7, 2 }, 5);

        assert longestSubarray(new int[] { 4, 2, 2, 2, 4, 4, 2, 2 }, 0) == 3
                : "Expected 3, but got " + longestSubarray(new int[] { 4, 2, 2, 2, 4, 4, 2, 2 }, 0);

        assert longestSubarray(new int[] { 1,5,6,7,8,10,6,5,6 }, 4) == 5
                : "Expected 5, but got " + longestSubarray(new int[] { 1,5,6,7,8,10,6,5,6 }, 4);
    }
}
