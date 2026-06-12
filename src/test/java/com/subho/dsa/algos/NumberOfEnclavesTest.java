package com.subho.dsa.algos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.subho.dsa.graph.algos.NumberOfEnclaves;

public class NumberOfEnclavesTest {

    @Test
    public void test1() {
        int[][] grid = {
            {0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}
        };

        int result = NumberOfEnclaves.find(grid);
        assertEquals(3, result);
    }

    @Test
    public void test2() {
        int[][] grid = {
            {0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}
        };

        int result = NumberOfEnclaves.find(grid);
        assertEquals(0, result);
    }

    @Test
    public void test3() {
        int[][] grid = {
             {0, 0, 0, 1},{0, 0, 0, 1}, {0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}
        };

        int result = NumberOfEnclaves.find(grid);
        assertEquals(3, result);
    }

}
