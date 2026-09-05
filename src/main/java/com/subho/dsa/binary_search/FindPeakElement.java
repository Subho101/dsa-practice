package com.subho.dsa.binary_search;

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            System.out.println(mid);
            System.out.println(low);
            System.out.println(high);
            System.out.println("---");

            if (mid == 0) {
                if (nums[mid] > nums[mid + 1])
                    return nums[mid];
                low = mid + 1;

            } else if (mid == nums.length - 1) {
                if (nums[mid] > nums[mid - 1])
                    return nums[mid];
                high = mid - 1;
            }

            else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return nums[mid];

            else if (nums[mid] > nums[mid - 1]) { // on the uphill, so eliminate left
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // int[] nums = { 1, 2, 1, 3, 5, 6, 4 };
        int[] nums = { 6, 5, 4, 3, 2, 3, 2 };
        System.out.println(findPeakElement(nums));
    }
}
