package com.subho.dsa.algos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.subho.dsa.graph.algos.DetectCycleDirected;

public class DetectCycleDirectedTest {
    
    @Test
    public void test1() {
        int V = 4; 
        int edges[][] = {{0, 1}, {1, 2}, {2, 0}, {2, 3}};

        assertTrue(DetectCycleDirected.detectCycle(V, edges));
    }
    
    @Test
    public void test2() {
        int V = 4;
        int edges[][] = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};

        assertFalse(DetectCycleDirected.detectCycle(V, edges));
    }
}
