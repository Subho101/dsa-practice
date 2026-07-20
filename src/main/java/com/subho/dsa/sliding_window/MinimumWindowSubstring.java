package com.subho.dsa.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s.equals(t)) {
            return t;
        }
        Map<Character, Integer> freqMap = new HashMap<>();
        int l = 0, countRequired = 0, minSize = Integer.MAX_VALUE;
        String result = "";

        for (char ch : t.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        countRequired = freqMap.size();

        for (int r = 0; r < s.length(); r++) {
            char curr = s.charAt(r);
            if (freqMap.containsKey(curr)) {
                freqMap.put(curr, freqMap.get(curr) - 1);
                if (freqMap.get(curr) == 0) {
                    countRequired -= 1;
                }
            }

            if (countRequired == 0) {
                if (r - l + 1 < minSize) {
                    minSize = r - l + 1;
                    result = s.substring(l, r + 1);
                }

                while (countRequired == 0 && l <= r) {
                    char st = s.charAt(l);
                    if (freqMap.containsKey(st)) {
                        freqMap.put(st, freqMap.get(st) + 1);
                        if (freqMap.get(st) == 1) {
                            countRequired += 1;
                        }
                    }

                    if (r - l + 1 < minSize) {
                        minSize = r - l + 1;
                        result = s.substring(l, r + 1);
                    }
                    l++;
                }
            }
        }

        return result;
    }
}
