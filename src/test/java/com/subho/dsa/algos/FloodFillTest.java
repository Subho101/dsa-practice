package com.subho.dsa.algos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


import org.junit.jupiter.api.Test;

import com.subho.dsa.graph.algos.FloodFill;

public class FloodFillTest {
    
    @Test
    public void test1() {
        int[][] image = { {1, 1, 1}, {1, 1, 0}, {1, 0, 1} };
        int[][] expected = { {2, 2, 2}, {2, 2, 0}, {2, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;

        FloodFill.floodFill(sr, sc, newColor, image);       

        assertArrayEquals(expected, image);
    }

    @Test
    public void test2() {
        int[][] image = { {0, 1, 0}, {1, 1, 0}, {0, 0, 1} };
        int[][] expected = { {0, 1, 0}, {1, 1, 0}, {0, 0, 3} };
        int sr = 2, sc = 2, newColor = 3;

        FloodFill.floodFill(sr, sc, newColor, image);       

        assertArrayEquals(expected, image);
    }

}
