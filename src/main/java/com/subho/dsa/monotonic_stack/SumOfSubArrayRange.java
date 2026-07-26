package com.subho.dsa.monotonic_stack;

import java.util.Stack;

public class SumOfSubArrayRange {

    public static long subArrayRanges(int[] nums) {
        long sum = 0;

        int[] prevSmallerElement = prevGreaterOrSmallerOrEqualElement(nums, true);
        int[] nextSmallerElement = nextGreaterOrSmallerOrEqualElement(nums, true);

        int[] prevGreaterElement = prevGreaterOrSmallerOrEqualElement(nums, false);
        int[] nextGreaterElement = nextGreaterOrSmallerOrEqualElement(nums, false);

        for (int i = 0; i < nums.length; i++) {

            long min = countContribution(i, nums, prevSmallerElement, nextSmallerElement);
            long max = countContribution(i, nums, prevGreaterElement, nextGreaterElement);

            sum += (max - min);

        }

        return sum;
    }

    private static long countContribution(int i, int[] nums, int[] prev, int[] next) {

        long left = i - prev[i];
        long right = next[i] - i;

        return 1l * left * right * nums[i];

    }

    private static int[] prevGreaterOrSmallerOrEqualElement(int[] nums, boolean isSmaller) {

        int[] result = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < nums.length; i++) {

            if (isSmaller) {
                while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                    st.pop();
                }
            } else {
                while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                    st.pop();
                }
            }

            result[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return result;
    }

    private static int[] nextGreaterOrSmallerOrEqualElement(int[] nums, boolean isSmaller) {

        int[] result = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {

            if (isSmaller) {
                while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                    st.pop();
                }
            } else {
                while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                    st.pop();
                }
            }

            result[i] = st.isEmpty() ? nums.length : st.peek();

            st.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, -2, -3, 4, 1 };
        System.out.println(subArrayRanges(nums));

    }

}
