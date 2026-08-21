package com.subho.dsa.binary_search;

public class FindSmallestDivisor {
    public static int smallestDivisor(int[] nums, int threshold) {

        int result = 1;
        int high = nums[0], low = 0;
        for (int num : nums)
            high = Math.max(high, num);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (findSum(mid, nums) > threshold) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }

        }

        return result;
    }

    private static int findSum(int divisor, int[] nums) {
        double sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += Math.ceil(((double) nums[i] / (double) divisor));
        }
        System.out.println("Divisor " + divisor + " Sum " + (int) sum);
        return (int) sum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 9 };
        int threshold = 6;

        System.out.println(smallestDivisor(nums, threshold));
    }
}
