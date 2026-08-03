package com.subho.dsa.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {

            int orgIdx = i % n;

            while (!st.isEmpty() && nums[orgIdx] >= st.peek()) {
                st.pop();
            }

            if (i < n) {
                result[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(nums[orgIdx]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 3 };
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
