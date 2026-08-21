package com.subho.dsa.binary_search;

import java.util.Arrays;

public class AggresiveCow {
    public static int aggressiveCows(int[] arr, int k) {

        Arrays.sort(arr);
        int low = 1, high = arr[arr.length - 1] - arr[0];
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCow(mid, k, arr)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private static boolean canPlaceCow(int minDist, int k, int[] arr) {
        int cowsPlaced = 1;
        int currCow = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[currCow] >= minDist) {
                cowsPlaced++;
                currCow = i;
            }
        }

        return cowsPlaced >= k;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 1, 2, 7, 5 };
        int k = 3;
        System.out.println(aggressiveCows(arr, k));
    }
}
