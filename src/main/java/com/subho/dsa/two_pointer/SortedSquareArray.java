package com.subho.dsa.two_pointer;

import java.util.Arrays;

public class SortedSquareArray {


    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length-1;
        int lastIndex = nums.length-1;
        while(left <= right) {

            if(Math.pow(nums[left], 2) > Math.pow(nums[right], 2)) {
                result[lastIndex--] = (int)Math.pow(nums[left], 2);
                left++;
            }  else {
                result[lastIndex--] = (int)Math.pow(nums[right], 2);
                right--;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
