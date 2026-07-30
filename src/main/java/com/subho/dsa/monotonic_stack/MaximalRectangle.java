package com.subho.dsa.monotonic_stack;

import java.util.Stack;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {

        int maxArea = Integer.MIN_VALUE;

        int[][] prefixMat = new int[matrix.length][matrix[0].length];

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] - '0' == 1) {
                prefixMat[0][j] = 1;
            }
        }

        maxArea = Math.max(maxArea, largestRectangleArea(prefixMat[0]));

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] - '0' == 1) {
                    prefixMat[i][j] = prefixMat[i - 1][j] + 1;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(prefixMat[i]));
        }

        return maxArea;
    }

    private static int largestRectangleArea(int[] heights) {

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
        char[][] matrix = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };

        System.out.println(maximalRectangle(matrix));
    }
}
