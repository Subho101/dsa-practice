package com.subho.dsa.graph.algos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    static class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int n = grid.length, m = grid[0].length;
        int[][] dist = new int[n][m];
        for(int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        
        dist[0][0] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int currI = curr.i;
            int currJ = curr.j;

            for(int i=-1; i<=1; i++) {
                for(int j=-1; j<=1; j++) {
                    int newI = currI + i;
                    int newJ = currJ + j;

                    if(newI == currI && newJ == currJ) continue;
                    
                    if(newI >= 0 && newJ >= 0 
                        && newI < n && newJ < m
                        && grid[newI][newJ] == 0
                    ) {                        

                        if(dist[currI][currJ] + 1 < dist[newI][newJ]) {
                            dist[newI][newJ] = dist[currI][currJ] + 1;
                            q.offer(new Pair(newI, newJ));
                        }
                    }
                }
            }
        }

        for(int[] d : dist) {
            System.out.println(Arrays.toString(d));
        }
        return dist[n-1][m-1] == Integer.MAX_VALUE ? -1 : dist[n-1][m-1] + 1;
    }

    public static void main(String[] args) {
        //int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        int[][] grid = {{1,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
