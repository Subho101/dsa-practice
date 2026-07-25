package com.subho.dsa.sliding_window;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int maxLen = 0;
        int l = 0, maxFreq = 0;
        int[] mp = new int[26];

        for (int r = 0; r < s.length(); r++) {
            mp[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, mp[s.charAt(r) - 'A']);

            int currLen = (r - l + 1);
            if (currLen - maxFreq > k) {
                mp[s.charAt(l) - 'A']--;
                l++;
            }

            if (currLen - maxFreq <= k) {
                maxLen = Math.max(maxFreq, currLen);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
}
