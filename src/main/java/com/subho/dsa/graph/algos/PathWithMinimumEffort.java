package com.subho.dsa.graph.algos;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    static class Pair {
        int i;
        int j;
        int effort;

        Pair(int i, int j, int effort) {
            this.i = i;
            this.j = j;
            this.effort = effort;
        }
    }

    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        pq.offer(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int row = curr.i;
            int col = curr.j;
            int currEffort = curr.effort;

            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int idx = 0; idx < 4; idx++) {
                int nrow = dx[idx] + row;
                int ncol = dy[idx] + col;

                if (nrow >= 0 && ncol >= 0 && nrow < m && ncol < n) {
                    int newEffort = Math.max(currEffort, Math.abs(heights[row][col] - heights[nrow][ncol]));
                    if (newEffort < dist[nrow][ncol]) {
                        dist[nrow][ncol] = newEffort;
                        pq.offer(new Pair(nrow, ncol, newEffort));
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(minimumEffortPath(heights));
    }
}
