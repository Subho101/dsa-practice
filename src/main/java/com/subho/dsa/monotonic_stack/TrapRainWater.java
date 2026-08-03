package com.subho.dsa.monotonic_stack;

public class TrapRainWater {

    public static int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }

        max = Integer.MIN_VALUE;

        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }

        int totalWater = 0;
        for (int i = 0; i < height.length; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            totalWater += minHeight - height[i];
        }

        return totalWater;
    }

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }
}
