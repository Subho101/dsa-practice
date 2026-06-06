package com.subho.dsa.algos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.subho.dsa.graph.algos.RottenOrange;

public class RottenOrangeTest {

    @Test
    public void test1() {
        int[][] grid =  { {2, 1, 1} , {0, 1, 1} , {1, 0, 1} };
        int expected = -1;
        int result = RottenOrange.orangesRotting(grid);
        assertEquals(expected, result, "Incorrect Result");
    }

    @Test
    public void test2() {
        int[][] grid = { {2,1,1} , {1,1,0} , {0,1,1} } ;
        int expected = 4;
        int result = RottenOrange.orangesRotting(grid);
        assertEquals(expected, result, "Incorrect result");
    }

    @Test
    public void test3() {
        int[][] grid = {
            {0,1,2},
            {0,1,2},
            {2,1,1}};
        int expected = 1;
        int result = RottenOrange.orangesRotting(grid);
        assertEquals(expected, result, "Incorrect result");
    }
}
