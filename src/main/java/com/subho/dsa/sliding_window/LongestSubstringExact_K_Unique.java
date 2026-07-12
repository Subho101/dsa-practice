package com.subho.dsa.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringExact_K_Unique {
    public static int longestKSubstr(String s, int k) {
        int maxLen = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            if (map.size() > k) {
                while (map.size() > k) {
                    char fl = s.charAt(l);
                    map.put(fl, map.get(fl) - 1);
                    if (map.get(fl) == 0) {
                        map.remove(fl);
                    }
                    l++;
                }
            }

            if (map.size() == k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }

        return maxLen == 0 ? -1 : maxLen;
    }

    public static void main(String[] args) {
        // String s = "aabacbebebe";
        // int k = 3;
        String s = "aabaaab";
        int k = 2;

        System.out.println(longestKSubstr(s, k));
    }
}
