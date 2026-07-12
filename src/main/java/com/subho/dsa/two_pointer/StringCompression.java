package com.subho.dsa.two_pointer;

public class StringCompression {

    public static int compress(char[] chars) {
        int high = 0, low = 0;
        int writeIndex = 0;

        while (high < chars.length) {
            while (high < chars.length && chars[low] == chars[high]) high++;

            int len = high - low;
            chars[writeIndex++] = chars[low];
            if (len > 1) {
                for (char ch : String.valueOf(len).toCharArray()) {
                    chars[writeIndex++] = ch;
                }
            }

            low = high;
        }
        System.out.println(String.valueOf(chars));
        return writeIndex;
    }

    public static void main(String[] args) {
        // char[] chars = {'a','a','b','b','c','c','c'};
        // char[] chars = {'a'};
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(chars));
    }
}
