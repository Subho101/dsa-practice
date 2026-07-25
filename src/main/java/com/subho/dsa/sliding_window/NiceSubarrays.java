package com.subho.dsa.sliding_window;

public class NiceSubarrays {
    public static int numberOfSubarrays(int[] nums, int k) {

        return numberOfSubarraysUtil(nums, k) - numberOfSubarraysUtil(nums, k - 1);
    }

    private static int numberOfSubarraysUtil(int[] nums, int k) {
        if (k < 0)
            return 0;
        int count = 0, numOfOdds = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            int num = nums[r];
            if (isOdd(num))
                numOfOdds++;

            while (numOfOdds > k) {
                if (isOdd(nums[l]))
                    numOfOdds--;
                l++;
            }

            count += r - l + 1;
        }
        return count;
    }

    private static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        int k = 2;

        System.out.println(numberOfSubarrays(nums, k));
    }
}
