package com.subho.dsa.algos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.subho.dsa.graph.algos.NoOfIslands;



public class NoOfIslandsTest {

    @Test
    public void test1() {
        String[][]  grid = {             
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };

        int islands = NoOfIslands.countIsLands(grid);
        assertEquals(3, islands);
    }

    @Test
    public void test2() {
        String[][]  grid = {
            {"1","1","1","1","0"},
            {"1","1","0","1","0"},
            {"1","1","0","0","0"},
            {"0","0","0","0","0"}
        };

        int islands = NoOfIslands.countIsLands(grid);
        assertEquals(1, islands);
    }

}
