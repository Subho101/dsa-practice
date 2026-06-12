package com.subho.dsa.algos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.subho.dsa.graph.algos.CountDistinctIslands;

public class CountDistinctIslandsTest {

    @Test
    public void test1() {
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}
        };

        int result = CountDistinctIslands.countIslands(grid);
        assertEquals(1, result);
    }
    @Test
    public void test2() {
        int[][] grid = {{1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}};

        int result = CountDistinctIslands.countIslands(grid);
        assertEquals(3, result);
    }
}   
