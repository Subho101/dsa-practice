package com.subho.dsa.two_pointer;

/*
https://leetcode.com/problems/separate-black-and-white-balls/description/
*/

public class SeperateBlackWhiteBalls {
    public static long minimumSteps(String s) {
        long black = 0;
        long swap = 0;

        char[] chars = s.toCharArray();

        for(int i=0; i<chars.length; i++) {
            if(chars[i] == '1') {
                black++;
            } else {
                swap += black;
            }
        }
        
        return swap;
    }

    public static void main(String[] args) {
        //String s = "101";
        String s = "100";

        System.out.println(minimumSteps(s));
    }
}
