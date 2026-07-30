package com.subho.dsa.monotonic_stack;

public class CelebrityProblem {
    public static int celebrity(int mat[][]) {

        int top = 0, bottom = mat.length - 1;

        while (top < bottom) {
            if (mat[top][bottom] == 1) {
                // top knows someone, cant be a celebrity
                top++;
            } else {
                // someone does not know bottom, cant be a celebrity
                bottom--;
            }
        }

        int c = top; // possible celebrity

        // We got a possible celebrity, but need to verify

        for (int i = 0; i < mat.length; i++) {
            if (i == c)
                continue;

            if (mat[c][i] == 1)
                return -1;
            if (mat[i][c] == 0)
                return -1;
        }

        return c;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 1, 0 },
                { 0, 1, 0 },
                { 0, 1, 1 } };

        System.out.println(celebrity(mat));
    }
}
