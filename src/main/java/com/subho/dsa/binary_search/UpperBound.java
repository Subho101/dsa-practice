package com.subho.dsa.binary_search;

public class UpperBound {
    public static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 7, 10, 11, 11, 25 };
        int target = 11;
        System.out.println(upperBound(arr, target));
    }
}
