package com.subho.revise.sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        if (s.equals(t)) return t;

        // This map will store the frequency of character t
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        int countReq = countMap.size(); // This number of unique character required in substring

        int l = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r); // current character
            if (countMap.containsKey(ch)) { // this character exists in string t

                countMap.put(ch, countMap.get(ch) - 1); // decrease from count map since it is found

                if (countMap.get(ch) == 0)
                    countReq--; // check if all the character in t is found, then decrease the countReq

                if (countReq == 0) { // if countReq == 0. then it is valid substring
                    if (r - l + 1 < minLen) { // before storing, check whether it is lesser than the previously stored
                        minLen = r - l + 1;
                        result = s.substring(l, r + 1);
                    }

                    // Here in order to find the minimum window, we need to shrink the window from the l until it is valid.
                    // countReq == 0, means it is valid

                    while (l <= r && countReq == 0) {
                        char st = s.charAt(l); // We are going to remove the character at l in order to shrink
                        // if it present in countMap, then it is part of the string t. so increase the countReq
                        if (countMap.containsKey(st)) {
                            countMap.put(st, countMap.get(st) + 1);


                            // Here checking, if the required count is 1, then one of the valid character just left
                            // the window, so now it is not valid
                            if (countMap.get(st) == 1) {
                                countReq++;
                            }

                            // keeping track of the minwindow, since it is possible that irrelevant characters are
                            // getting removed from the start
                            if (r - l + 1 < minLen) {
                                minLen = r - l + 1;
                                result = s.substring(l, r + 1);
                            }

                        }
                        l++;
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
