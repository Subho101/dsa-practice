package com.subho.dsa.two_pointer;

public class BackSpaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {

        String rs = getNormalizedString(s);
        String ts = getNormalizedString(t);

        return rs.equals(ts);
    }

    private static String getNormalizedString(String s) {
        int bp = 0;
        StringBuilder rs = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '#' && bp == 0) {
                rs.append(s.charAt(i));
                continue;
            }

            if (s.charAt(i) == '#') {
                bp++;
            } else {
                bp--;
            }
        }

        return rs.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "dab###", t = "ad#c";

        System.out.println(backspaceCompare(s, t));
    }
}
