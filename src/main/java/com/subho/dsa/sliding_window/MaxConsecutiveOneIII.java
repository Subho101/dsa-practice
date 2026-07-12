package com.subho.dsa.sliding_window;

public class MaxConsecutiveOneIII {

    public static int findMaxConsecutiveOnes(int[] nums, int k) {
        int maxLen = 0;
        int l = 0, z = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                z++;
                if (z > k) {
                    while (l < nums.length) {
                        if (z <= k) break;
                        if (nums[l] == 1) {
                            l++;
                        } else {
                            z--;
                            l++;
                        }
                    }
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String out = "Expected %d, got %d";
        assert findMaxConsecutiveOnes(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2) == 6
                : String.format(out, 6, findMaxConsecutiveOnes(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        assert findMaxConsecutiveOnes(new int[] {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3) == 10
                : String.format(
                        out,
                        10,
                        findMaxConsecutiveOnes(new int[] {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
