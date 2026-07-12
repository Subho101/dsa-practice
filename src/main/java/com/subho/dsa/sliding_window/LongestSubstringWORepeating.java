package com.subho.dsa.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWORepeating {
    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int maxLen = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            if (!map.containsKey(ch)) {
                maxLen = Math.max(maxLen, r - l + 1);
                map.put(ch, r);
            } else {
                if (map.get(ch) >= l) {
                    l = map.get(ch) + 1;
                }

                maxLen = Math.max(maxLen, r - l + 1);
                map.put(ch, r);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String out = "Expected %d, got %d";
        assert lengthOfLongestSubstring("abcabcbb") == 3 : String.format(out, 3, lengthOfLongestSubstring("abcabcbb"));
        assert lengthOfLongestSubstring("cadbzabcd") == 5
                : String.format(out, 3, lengthOfLongestSubstring("cadbzabcd"));
        assert lengthOfLongestSubstring("bbbbb") == 1 : String.format(out, 3, lengthOfLongestSubstring("bbbbb"));
        assert lengthOfLongestSubstring("pwwkew") == 3 : String.format(out, 3, lengthOfLongestSubstring("pwwkew"));
    }
}
