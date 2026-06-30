package com.subho.dsa.two_pointer;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxWater = 0;

        while(left < right) {
            int currWater = (right - left) * Math.min(height[right], height[left]);
            maxWater = Math.max(maxWater, currWater);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));
    }
}
