package com.subho.dsa.recursion;

public class SubSequenceWithSumK {
    public static boolean checkSubsequenceSum(int[] arr, int k) {

        return helper(arr, 0, 0, k);
    }

    private static boolean helper(int[] arr, int sum, int i, int k) {
        if (i >= arr.length) {
            return false;
        }

        if (sum == k)
            return true;

        boolean include = helper(arr, sum + arr[i], i + 1, k);
        boolean exclude = helper(arr, sum, i + 1, k);

        return include || exclude;
    }

    public static void main(String[] args) {
        // int[] arr = { 10, 1, 2, 7, 6, 1, 5 };
        // int k = 8;
        int[] arr = { 2, 3, 5, 7, 9 };
        int k = 1000;

        System.out.println(checkSubsequenceSum(arr, k));
    }
}
