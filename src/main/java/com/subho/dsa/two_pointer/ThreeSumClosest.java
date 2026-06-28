package com.subho.dsa.two_pointer;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int result = -1;
        int minDiff = Integer.MAX_VALUE;
        int n = nums.length;

        for(int i=0; i<n; i++) {
            int j = i+1;
            int k = n-1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int currDiff = Math.abs(target - sum);
                if(currDiff < minDiff) {
                    minDiff = currDiff;
                    result = sum;
                }
                if(sum < target) {                    
                    j++;
                } else if(sum > target) {
                    k--;
                } else {
                    return sum;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // int[] nums = {-1,2,1,-4};
        // int target = 1;
        // int[] nums = {0,0,0};
        // int target = 1;

        int[] nums = {0,3,97,102,200};
        int target = 300; // expected 300

        System.out.println(threeSumClosest(nums, target));
    }
}
