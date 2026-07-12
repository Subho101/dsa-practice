package com.subho.dsa.graph.algos;

import com.subho.dsa.graph.util.Pair;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundRegion {

    public static void fillRegion(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                q.offer(new Pair(i, 0));
                visited[i][0] = true;
            }
            if (board[i][board[i].length - 1] == 'O') {
                q.offer(new Pair(i, board[i].length - 1));
                visited[i][board[i].length - 1] = true;
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                visited[0][j] = true;
                q.offer(new Pair(0, j));
            }

            if (board[board.length - 1][j] == 'O') {
                visited[board.length - 1][j] = true;
                q.offer(new Pair(board.length - 1, j));
            }
        }

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int i = curr.i();
            int j = curr.j();

            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int k = 0; k < 4; k++) {
                int nrow = i + dx[k];
                int ncol = j + dy[k];

                if (nrow >= 0
                        && ncol >= 0
                        && nrow < board.length
                        && ncol < board[0].length
                        && board[nrow][ncol] == 'O'
                        && !visited[nrow][ncol]) {
                    visited[nrow][ncol] = true;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};

        fillRegion(board);

        for (char[] res : board) System.out.println(Arrays.toString(res));
    }
}
