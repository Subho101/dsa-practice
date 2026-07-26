package com.subho.dsa.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubArrayMinimum {
    public static int sumSubarrayMins(int[] arr) {

        int mod = (int) 1e9 + 7;
        int sum = 0;

        int[] prevSmaller = prevSmallerOrEqualElement(arr);
        int[] nextSmaller = nextSmallerElement(arr);

        System.out.println("Elements " + Arrays.toString(arr));
        System.out.println("PrevSmaller: " + Arrays.toString(prevSmaller));
        System.out.println("NextSmaller: " + Arrays.toString(nextSmaller));

        for (int i = 0; i < arr.length; i++) {
            sum = (sum + ((nextSmaller[i] - i) * (i - prevSmaller[i]) * arr[i]) % mod) % mod;
        }

        return sum;
    }

    private static int[] prevSmallerOrEqualElement(int[] nums) {
        int[] result = new int[nums.length];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return result;
    }

    private static int[] nextSmallerElement(int[] nums) {
        int[] result = new int[nums.length];

        Stack<Integer> st = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? nums.length : st.peek();
            st.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 11, 81, 94, 43, 3 };

        System.out.println(sumSubarrayMins(arr));
    }
}
