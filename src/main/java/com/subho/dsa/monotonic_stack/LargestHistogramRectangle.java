package com.subho.dsa.monotonic_stack;

import java.util.Stack;

public class LargestHistogramRectangle {
    public static int largestRectangleArea(int[] heights) {

        int maxArea = Integer.MIN_VALUE;

        int[] prevSmaller = findPrevSmaller(heights);
        int[] nextSmaller = findNextSmaller(heights);

        for (int i = 0; i < heights.length; i++) {
            int area = (nextSmaller[i] - prevSmaller[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;

    }

    private static int[] findPrevSmaller(int[] heights) {
        int[] result = new int[heights.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < heights.length; i++) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);

        }

        return result;
    }

    private static int[] findNextSmaller(int[] heights) {
        int[] result = new int[heights.length];
        Stack<Integer> st = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? heights.length : st.peek();
            st.push(i);

        }

        return result;
    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));
    }
}
