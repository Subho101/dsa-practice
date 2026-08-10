package com.subho.dsa.binary_search;

public class SearchInRotatedSortedArrayI {
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        // identify the sorted half
        // then check in the sorted half whether target belongs in the range

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[low] <= nums[mid]) { // left half is sorted
                if (nums[low] <= target && target <= nums[mid]) { // element belongs in this left half, eleminate the
                                                                  // right half
                    high = mid - 1;
                } else { // element belongs in the right half, eleminate the left half
                    low = mid + 1;
                }
            } else { // right half is sorted
                if (nums[mid] <= target && target <= nums[high]) { // element belongs in this right half, eleminate the
                                                                   // left half
                    low = mid + 1;
                } else { // element belongs in the left half, eleminate the right half
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(search(nums, target));
    }
}
