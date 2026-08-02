package com.subho.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class RatInAMaze {
    public static ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int[][] visited = new int[maze.length][maze[0].length];
        ArrayList<String> result = new ArrayList<>();

        helper(maze, visited, 0, 0, "", result);

        Collections.sort(result);

        return result;
    }

    private static void helper(int[][] maze, int[][] visited,
            int i, int j, String soFar, ArrayList<String> result) {

        // Dest reached
        if (i == maze.length - 1 && j == maze[i].length - 1) {
            result.add(soFar);
            return;
        }

        // Invalid
        if (i < 0 || j < 0 || i >= maze.length || j >= maze.length || maze[i][j] == 0 || visited[i][j] == 1) {
            return;
        }

        visited[i][j] = 1;

        helper(maze, visited, i + 1, j, soFar + "D", result);
        helper(maze, visited, i, j - 1, soFar + "L", result);
        helper(maze, visited, i, j + 1, soFar + "R", result);
        helper(maze, visited, i - 1, j, soFar + "U", result);

        visited[i][j] = 0;
    }

    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };

        System.out.println(ratInMaze(maze));
    }
}
