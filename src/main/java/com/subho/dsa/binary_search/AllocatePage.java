package com.subho.dsa.binary_search;

public class AllocatePage {

    public static int findPages(int[] arr, int k) {
        // code here
        if (k > arr.length)
            return -1;
        long result = -1;
        long low = 0, high = 0;
        for (int page : arr) {
            low = Math.max(low, page);
            high += page;
        }

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (allocatedStudent(mid, arr) > k) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }

        return (int) result;
    }

    private static int allocatedStudent(long minPage, int[] arr) {
        int allocatedStudent = 1;
        long currAllocated = 0;

        for (int i = 0; i < arr.length; i++) {
            if (currAllocated + arr[i] <= minPage) {
                currAllocated += arr[i];
            } else {
                allocatedStudent++;
                currAllocated = arr[i];
            }
        }

        return allocatedStudent;
    }
}