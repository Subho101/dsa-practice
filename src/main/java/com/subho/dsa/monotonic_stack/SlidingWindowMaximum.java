package com.subho.dsa.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        System.out.println(result.length);

        // Stores the index
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        // Need to create a deque.
        // Here we are trying to store the element in Decreasing fashion
        // Because that would help to fetch the next greater element, without scanning
        // the window
        // We will push to the front
        // And when window size is greater, we will remove the element from the last

        for (int i = 0; i < nums.length; i++) {
            System.out.println(dq);
            // First check, whether the last element is out of window, then just pop once
            if (!dq.isEmpty() && dq.peekLast() <= i - k) {
                dq.pollLast(); // remove the oldest item
            }

            // Now check from the top of the dq, if there are elments in the dq that are
            // smaller than current
            // pop them out, we dont need them, because this will be max element anyway

            while (!dq.isEmpty() && nums[dq.peekFirst()] <= nums[i]) {
                dq.pollFirst();
            }

            dq.offerFirst(i);

            if (i >= k - 1) {
                System.out.println(i - k + 1);
                result[i - k + 1] = nums[dq.peekLast()];
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
