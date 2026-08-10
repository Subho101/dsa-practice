package com.subho.dsa.binary_search;

public class SingleElementInSortedArray {
    public static int singleNonDuplicate(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        if (nums[0] != nums[1])
            return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2])
            return nums[nums.length - 1];

        int low = 1, high = nums.length - 2;

        // Idea is, in the left half of the single element, duplicate elements will be
        // placed in a even,odd manner
        // and, in the right half of the single element, duplicate elements will be
        // placed in a odd,even manner
        // So, in order to eleminate one of the half (lets say left half), if the index
        // is odd and index-1 is same
        // or index if even and index+1 is same, then eliminate the left half and vice
        // versa

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // if element at left and right are not equal, then it is the element
            if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1])
                return nums[mid];

            if ((mid % 2) == 1 && nums[mid] == nums[mid - 1] ||
                    (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println(singleNonDuplicate(nums));
    }
}
