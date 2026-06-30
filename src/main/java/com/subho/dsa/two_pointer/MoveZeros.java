package com.subho.dsa.two_pointer;

import java.util.Arrays;

public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        int insert = 0;

        for(int current = 0; current < nums.length; current++) {
            if(nums[current] != 0) {
                swap(insert, current, nums);
                insert++;
            }
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int [] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
