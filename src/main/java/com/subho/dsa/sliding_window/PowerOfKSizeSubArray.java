package com.subho.dsa.sliding_window;

import java.util.Arrays;

public class PowerOfKSizeSubArray {
    public static int[] resultsArray(int[] nums, int k) {
        if(k == 1) return nums;
        int[] result = new int[nums.length - k + 1];
        Arrays.fill(result, -1);

        int i=0, j=k-1, a=0;

        while(j < nums.length) {
            if(isValid(i, j, nums)) {
                result[a] = nums[j]; 
            }
            i++;
            j++;
            a++;
        }

        return result;
    }

    public static int[] resultsArrayOptimzed(int[] nums, int k) {
        if(k == 1) return nums;
        int[] result = new int[nums.length - k + 1];
        Arrays.fill(result, -1);

        int consecutiveCount = 1;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] - nums[i-1] == 1) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1;
            }

            if(i >= k) {
                if(consecutiveCount >= k) {
                    result[i-k+1] = nums[i];
                }
            }
        }

        return result;
    }

    private static boolean isValid(int start, int end, int[] nums) {
        for(int i=start; i<end; i++) {
            if(nums[i+1] - nums[i] != 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3,2,5};
        int k = 3;
        // int[] nums = {2,2,2,2,2};
        // int k = 4;
        
        // int[] nums = {3,2,3,2,3,2};
        // int k = 2;
        // int[] nums = {1,4};
        // int k = 1;

        System.out.println(Arrays.toString(resultsArrayOptimzed(nums, k)));
    }
}
