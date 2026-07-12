package com.subho.dsa.graph.algos;

import com.subho.dsa.graph.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountDistinctIslands {

    public static int countIslands(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<List<Pair>> set = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<Pair> list = new ArrayList<>();
                    dfs(i, j, i, j, visited, grid, list);
                    set.add(list);
                }
            }
        }

        int count = set.size();

        return count;
    }

    private static void dfs(int basei, int basej, int i, int j, boolean[][] visited, int[][] grid, List<Pair> list) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) return;

        visited[i][j] = true;
        list.add(new Pair(i - basei, j - basej));

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int nrow = i + dx[k];
            int ncol = j + dy[k];

            dfs(basei, basej, nrow, ncol, visited, grid, list);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}
        };

        System.out.println(countIslands(grid));
    }
}
