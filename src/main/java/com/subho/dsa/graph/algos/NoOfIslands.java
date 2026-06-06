package com.subho.dsa.graph.algos;

import java.util.Arrays;

public class NoOfIslands {

    public static int countIsLands(String[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(boolean[] v : visited) {
            System.out.println(Arrays.toString(v));
        }

        int count = 0;

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                
                if(!visited[i][j] && matrix[i][j] == "1") {
                    count++;
                    dfs(i, j, visited, matrix);
                    
                }
            }
        }

        return count;
    }

    private static boolean dfs(int i, int j, boolean[][] visited, String[][] matrix) {

        if(!isValidPos(i, j, matrix) || visited[i][j]) return false;
        
        visited[i][j] = true;   
        dfs(i-1, j, visited, matrix);
        dfs(i, j+1, visited, matrix);
        dfs(i+1, j, visited, matrix);
        dfs(i, j-1, visited, matrix);
        return true;
        
    }

    private static boolean isValidPos(int i, int j, String[][] matrix) {
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length || matrix[i][j] == "0") return false;
        return true;
    }

    public static void main(String[] args) {
        String[][]  grid = {             
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };

        int islands = countIsLands(grid);
        assert islands == 3 : "Incorrect result " + islands;
        System.out.println("Test Case passed " + islands);
    }
    
}