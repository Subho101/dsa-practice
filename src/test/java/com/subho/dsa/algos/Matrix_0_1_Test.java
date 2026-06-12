package com.subho.dsa.algos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.subho.dsa.graph.algos.Matrix_0_1;

public class Matrix_0_1_Test {

    @Test
    public void test1() {
        int[][] grid = new int[][] {
              {0, 1, 1, 0}, {1, 1, 0, 0}, {0, 0, 1, 1} 
            };

        int[][] result = Matrix_0_1.nearest(grid);  
        int[][] expected = new int[][] {
            {1, 0, 0, 1}, {0, 0, 1, 1}, {1, 1, 0, 0}
        };
        
        assertArrayEquals(expected, result);
        
    }

    @Test
    public void test2() {
        int[][] grid = new int[][] {
               {1, 0, 1}, {1, 1, 0}, {1, 0, 0}  
            };

        int[][] result = Matrix_0_1.nearest(grid);  
        int[][] expected = new int[][] {
            {0, 1, 0}, {0, 0, 1}, {0, 1, 2}
        };
        
        assertArrayEquals(expected, result);
        
    }

}
