package com.subho.dsa.two_pointer;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int low = 0;

        for (int high = 0; high < nums.length; high++) {
            if (nums[high] != val) {
                nums[low] = nums[high];
                low++;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int vals = 2;

        System.out.println(removeElement(nums, vals));
    }
}
