package com.subho.dsa.recursion;

public class Atoi {
    public static int myAtoi(String s) {
        int i = 0;

        // skip leading whitespace
        while (i < s.length() && s.charAt(i) == ' ')
            i++;

        // check sign
        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        return helper(s, i, 0, sign);
    }

    private static int helper(String s, int i, long num, int sign) {
        // Base case
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return (int) (sign * num);
        }

        num = num * 10 + (s.charAt(i) - '0');

        if (sign * num <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (sign * num >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return helper(s, i + 1, num, sign);

    }

    public static void main(String[] args) {
        String s = "0    -1234words";
        System.out.println(myAtoi(s));
    }
}
