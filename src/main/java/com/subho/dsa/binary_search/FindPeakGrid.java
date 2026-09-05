package com.subho.dsa.binary_search;

import java.util.Arrays;

public class FindPeakGrid {
    public static int[] findPeakGrid(int[][] mat) {

        if (mat[0].length == 1) {
            int row = findMaxElementInCol(mat, 0);
            return new int[] { row, 0 };
        }

        // Here, peak element is greater than all 4 adjacent element
        // So if we can find the max element column wise (or row wise), that will take
        // care the vertical part
        // Now we need to check the left and right, which converts to find peak in 1D
        // element
        int n = mat.length, m = mat[0].length;
        int low = 0, high = m - 1;
        while (low <= high) {
            int col = low + (high - low) / 2; // Standing in column index

            // find the row where it is maximum
            int row = findMaxElementInCol(mat, col);

            // check if it is greater than the adjacent
            // I dont need to check row-1 and row+1, because given row is already maximum
            // so I only need to check col-1 and col+1

            if (col == 0 && mat[row][col] > mat[row][col + 1])
                return new int[] { row, col };
            if (col == m - 1 && mat[row][col] > mat[row][col - 1])
                return new int[] { row, col };

            if (mat[row][col] > mat[row][col + 1] && mat[row][col] > mat[row][col - 1])
                return new int[] { row, col };
            else if (mat[row][col] > mat[row][col - 1]) // In 1D it was uphill, so eliminate the left
                low = col + 1;
            else
                high = col - 1;

        }

        return new int[] { -1, -1 };
    }

    private static int findMaxElementInCol(int[][] mat, int colIdx) {
        // This will take an column, and return the row,col index where the element is
        // greater than top and bottom
        int row = -1;
        int max = Integer.MIN_VALUE;

        for (int r = 0; r < mat.length; r++) {
            if (mat[r][colIdx] > max) {
                max = mat[r][colIdx];
                row = r;
            }
        }

        return row;
    }

    public static void main(String[] args) {
        // int[][] mat = {
        // { 10, 20, 15 },
        // { 21, 30, 14 },
        // { 7, 16, 32 }
        // };
        int[][] mat = {
                { 1 },
                { 3 },
                { 2 }
        };

        System.out.println(Arrays.toString(findPeakGrid(mat)));

    }
}
