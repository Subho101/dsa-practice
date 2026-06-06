package com.subho.dsa.graph.algos;

import java.util.Arrays;

public class FloodFill {
    public static void floodFill(int sr, int sc, int newColor, int[][] image) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(sr, sc, newColor, image[sr][sc], visited, image);
        for(int[] im : image) System.out.println(Arrays.toString(im));
    }

    public static void dfs(int i, int j, int newColor, int initialColor, boolean[][] visited, int[][] image) {
        if(i<0 || j<0 || i>=image.length || j>=image[0].length || visited[i][j] || image[i][j] != initialColor) return;

        visited[i][j] = true;
        image[i][j] = newColor;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        for(int k = 0; k<dx.length; k++) {
            int nrow = dx[k] + i;
            int ncol = dy[k] + j;
            dfs(nrow, ncol, newColor, initialColor, visited, image);
        }
    }

    public static void main(String[] args) {
        int[][] image = { {1, 1, 1}, {1, 1, 0}, {1, 0, 1} };
        int sr = 1, sc = 1, newColor = 2;

        FloodFill.floodFill(sr, sc, newColor, image);
    }
}
