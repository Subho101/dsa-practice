package com.subho.dsa.two_pointer;

import java.util.Arrays;
import java.util.function.Predicate;

public class SortByParity {
    public static int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length-1;

        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isOdd = num -> num % 2 != 0;

        while(left < right) {
            int leftElem = nums[left];
            int rightElem = nums[right];

            if(isEven.test(leftElem) && isOdd.test(rightElem)) {
                left++;
                right--;
            } else if(isOdd.test(leftElem)) {
                if(isEven.test(rightElem)) {
                    swap(left, right, nums);
                    left++;
                    right--;
                } else {
                    right--;
                }
            } else { // left is even and right is even
                left++;
            }
        }
        return nums;
    }

    public static int[] sortArrayByParityOptimized(int[] nums) {
        int insert = 0;

        Predicate<Integer> isEven = num -> num % 2 == 0;

        for(int current = 0; current < nums.length; current++) {
            if(isEven.test(nums[current])) {
                swap(insert, current, nums);
                insert++;
            }
        }
        
        return nums;
    }

    

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        //int[] nums = {3,2,5,4,1,9,8,7};
        int[] nums = {3,1,2,4};
        int[] result = sortArrayByParityOptimized(nums);
        System.out.println(Arrays.toString(result));
    }
}
