package com.subho.dsa.graph.algos;

public class NumberOfEnclaves {

    public static int find(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int firstCol = 0, lastCol = grid[0].length - 1;
            if (grid[i][firstCol] == 1) {
                dfs(i, firstCol, visited, grid);
            }

            if (grid[i][lastCol] == 1) {
                dfs(i, lastCol, visited, grid);
            }
        }

        for (int j = 0; j < grid[0].length; j++) {
            int firstRow = 0, lastRow = grid.length - 1;
            if (grid[firstRow][j] == 1) {
                dfs(firstRow, j, visited, grid);
            }

            if (grid[lastRow][j] == 1) {
                dfs(lastRow, j, visited, grid);
            }
        }

        int count = 0;

        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) count++;
            }
        }

        return count;
    }

    private static void dfs(int i, int j, boolean[][] visited, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) return;

        visited[i][j] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int nrow = i + dx[k];
            int ncol = j + dy[k];
            dfs(nrow, ncol, visited, grid);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};

        int result = find(grid);
        System.out.println(result);
    }
}
