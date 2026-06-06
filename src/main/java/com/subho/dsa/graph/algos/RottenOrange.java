package com.subho.dsa.graph.algos;

import java.util.LinkedList;
import java.util.Queue;

import com.subho.dsa.graph.util.Pair;

public class RottenOrange {

    static class P {
        Pair pair;
        int t;

        P(int i, int j, int t) {
            this.pair = new Pair(i, j);
            this.t = t;
        }
    }

    public static int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length]; 
        int level = bfs(visited, grid);

        for(int[] ar : grid) {
            for(int a : ar) {
                if (a == 1) return -1;
            }
        }

        return level;
    }

    public static int bfs(boolean[][] visited, int[][] grid) {
        Queue<P> queue = new LinkedList<>();
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new P(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int maxTime = 0;

        while(!queue.isEmpty()) {

            P curr = queue.poll();
            maxTime = Math.max(maxTime, curr.t);
            int currTime = curr.t;

            int[] dx = {-1,0,1,0};
            int[] dy = {0,1,0,-1};

            for(int del=0; del<dx.length; del++) {
                int nrow = curr.pair.i() + dx[del];
                int ncol = curr.pair.j() + dy[del];

                if(nrow < 0 || ncol < 0 
                    || nrow >= grid.length || ncol >= grid[0].length 
                    || visited[nrow][ncol] 
                    || grid[nrow][ncol] == 0 || grid[nrow][ncol] == 2) continue;
                    
                    visited[nrow][ncol] = true;
                    grid[nrow][ncol] = 2;
                    queue.offer(new P(nrow, ncol, currTime+1));

            }
        }

        return maxTime;
    }


}
