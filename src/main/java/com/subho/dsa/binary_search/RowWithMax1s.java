package com.subho.dsa.binary_search;

public class RowWithMax1s {
    public static int rowWithMax1s(int[][] arr) {
        // code here
        int maxCount = -1, maxIdx = -1;
        for (int i = 0; i < arr.length; i++) {
            int upperBoundIdx = findUpperBound(arr[i], 0);

            int ones = arr[i].length - upperBoundIdx;
            if (ones > maxCount) {
                maxCount = ones;
                maxIdx = i;
            }

        }
        System.out.println("maxCount " + maxCount);
        return maxCount == 0 ? -1 : maxIdx;
    }

    private static int findUpperBound(int[] row, int target) {
        int low = 0, high = row.length - 1;
        int ans = row.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // int[][] arr = {
        // { 0, 0, 1 },
        // { 0, 1, 1 },
        // { 0, 0, 0 }
        // };

        int[][] arr = {
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }

        };

        System.out.println(rowWithMax1s(arr));
    }
}
