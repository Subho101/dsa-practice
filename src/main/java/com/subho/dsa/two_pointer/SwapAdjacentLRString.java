package com.subho.dsa.two_pointer;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/swap-adjacent-in-lr-string/submissions/2051066355/
*/

public class SwapAdjacentLRString {
    public static boolean canTransform(String start, String result) {
        if (start.length() != result.length()) return false;

        if (!start.replace("X", "").equals(result.replace("X", ""))) return false;

        System.out.println(start.replace("X", ""));
        System.out.println(result.replace("X", ""));

        List<Integer> lStart = new ArrayList<>();
        List<Integer> lEnd = new ArrayList<>();
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') lStart.add(i);
        }

        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == 'L') lEnd.add(i);
        }

        if (lStart.size() != lEnd.size()) return false;

        List<Integer> RStart = new ArrayList<>();
        List<Integer> REnd = new ArrayList<>();

        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'R') RStart.add(i);
        }

        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == 'R') REnd.add(i);
        }

        if (RStart.size() != REnd.size()) return false;

        for (int i = 0; i < lStart.size(); i++) {
            if (lStart.get(i) < lEnd.get(i)) return false;
        }

        for (int i = 0; i < RStart.size(); i++) {
            if (RStart.get(i) > REnd.get(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // String start = "RXXLRXRXL", result = "XRLXXRRLX";
        String start = "RXXL", result = "XLRX";
        System.out.println(canTransform(start, result));
    }
}
