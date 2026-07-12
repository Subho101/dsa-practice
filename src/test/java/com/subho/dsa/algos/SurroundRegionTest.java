package com.subho.dsa.algos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.subho.dsa.graph.algos.SurroundRegion;
import org.junit.jupiter.api.Test;

public class SurroundRegionTest {

    @Test
    public void test1() {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};

        char[][] expected = {{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}};

        SurroundRegion.fillRegion(board);

        assertArrayEquals(expected, board);
    }
}
