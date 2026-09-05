package com.subho.dsa.binary_search;

public class SearchIn2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length, m = matrix[0].length;

        int low = 0, high = (n * m) - 1;

        // Here we will try to virtually flatten the matrix
        // So low = 0 and high = n * m
        // to convert the flattened index to 2D index, we get row = index/m (because
        // every column has m elements, so row will start from multiples of m, like 0,
        // 4, 8 ....)
        // To get column, we can do index % m (remainder will get the column index)

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m, col = mid % m;

            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 13;
        System.out.println(searchMatrix(matrix, target));
    }
}
