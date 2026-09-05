package com.subho.dsa.binary_search;

public class SearchIn2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {

        // Here, the matrix is sorted from left to right and top to bottom
        // If I am standing at a cell, which is greater than the target
        // Then, we can eliminate that col, because subsequent element will only
        // increase
        // Vice versa, we eliminate the row, if element is smaller than the target

        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                col--;
            else
                row++;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        int target = 5;

        System.out.println(searchMatrix(matrix, target));
    }
}
