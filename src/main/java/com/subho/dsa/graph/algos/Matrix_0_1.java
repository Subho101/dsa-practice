package com.subho.dsa.graph.algos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.subho.dsa.graph.util.Pair;

public class Matrix_0_1 {

    static class P {
        Pair pair;
        int dist;

        P(int i, int j, int dist) {
            this.pair = new Pair(i, j);
            this.dist = dist;
        }
    }

    public static int[][] nearest(int[][] grid) {

        int[][] result = new int[grid.length][grid[0].length];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<P> q = new LinkedList<>();

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.offer(new P(i, j, 0));
                }
            }
        }

        while(!q.isEmpty()) {

            P curr = q.poll();
            int i = curr.pair.i();
            int j = curr.pair.j();
            int dist = curr.dist;

            result[i][j] = dist;

            int[] dx = {-1,0,1,0};
            int[] dy = {0,1,0,-1};

            for(int k=0; k<4; k++) {
                int nrow = i + dx[k];
                int ncol = j + dy[k];
                if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length
                    && grid[nrow][ncol] == 0 && !visited[nrow][ncol]
                ) {
                    visited[nrow][ncol] = true;
                    q.offer(new P(nrow, ncol, dist + 1));
                }
            }
        }


        return result;

    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
              {0, 1, 1, 0}, {1, 1, 0, 0}, {0, 0, 1, 1} 
        };

        int[][] result = nearest(grid);

        for(int[] res : result) System.out.println(Arrays.toString(res));
    }

}
