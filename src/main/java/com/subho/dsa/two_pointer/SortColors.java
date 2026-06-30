package com.subho.dsa.two_pointer;

import java.util.Arrays;

public class SortColors {
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(low, mid, nums);
                low++;
                mid++;   
            } else if(nums[mid] == 1) mid++;
            else {
                swap(mid, high, nums);
                high--;
            }
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));    
    }
}
