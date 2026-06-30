package com.subho.dsa.two_pointer;

public class BackSpaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {

        System.out.println(getValidIndex(s, s.length()-1));

        
        return false;
    }

    private static int getValidIndex(String s, int index) {
        int backspace = 0;

        while(index >= 0) {
            if (backspace == 0 && s.charAt(index) != '#') break;
            else if(s.charAt(index) == '#') backspace++;
            else backspace--;
            index--;
        }

        return index;
    }

    public static void main(String[] args) {
        String s = "dab###", t = "ad#c";

        System.out.println(backspaceCompare(s, t));
    }
}
