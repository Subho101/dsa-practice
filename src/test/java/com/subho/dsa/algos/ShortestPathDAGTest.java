package com.subho.dsa.algos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.subho.dsa.graph.algos.ShortestPathDAG;
import org.junit.jupiter.api.Test;

public class ShortestPathDAGTest {

    @Test
    public void test1() {
        int[][] edges = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};
        int V = 6, E = 7;
        int[] path = ShortestPathDAG.shortestPath(V, E, edges);
        int[] expected = {0, 2, 3, 6, 1, 5};
        assertArrayEquals(expected, path);
    }
}
