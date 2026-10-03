package com.subho.revise.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWORepeating {
    public static int lengthOfLongestSubstringBrute(String s) {
        if(s == null || s.length() == 0) return 0;
        int maxLen = Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for(int j=i; j<s.length(); j++) {
                char ch = s.charAt(j);
                if(set.contains(ch)) {
                    break;
                }
                set.add(ch);
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstringOpt(String s) {
        if(s == null || s.length() == 0) return 0;
        int maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> indexMap = new HashMap<>(); // This map will store the character and last occured index;
        int l = 0;

        for(int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if(indexMap.containsKey(ch)  // This checking whether the character existed
                && indexMap.get(ch) >= l // This check is needed because the character may have appeared before current window. eg - abba
            ) {
                l = indexMap.get(ch) + 1;
            }

            indexMap.put(ch, r); // Here updating the last occured index
            maxLen = Math.max(maxLen, r-l+1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstringOpt(s));
    }
}
