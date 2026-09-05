package com.subho.dsa.binary_search;

public class SearchInRotatedSortedArrayII {
    public static boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        // identify the sorted half
        // then check in the sorted half whether target belongs in the range
        // but if the array contains duplicate elements, there might be a case
        // where arr[low] == arr[mid] == arr[high]
        // here we cant safely identify the sorted half
        // so we need to trim down search space low++ and high-- and continue with
        // normal logic

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return true;

            // extra condition where arr[low] == arr[mid] == arr[high]
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

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

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 1, 1 };
        int target = 0;
        System.out.println(search(nums, target));
    }
}
