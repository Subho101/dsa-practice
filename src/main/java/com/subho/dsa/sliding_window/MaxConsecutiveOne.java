package com.subho.dsa.sliding_window;

public class MaxConsecutiveOne {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int l = 0;

        int[] mp = { -1, -1 };

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 1) {

                if (mp[0] >= l) {
                    l = mp[0] + 1;
                }

                maxLen = Math.max(maxLen, r - l + 1);

            } else {
                mp[0] = r;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String out = "Expected %d, got %d";
        assert findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }) == 3
                : String.format(out, 3, findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
        assert findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0, 1 }) == 2
                : String.format(out, 3, findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0, 1 }));
    }
}
