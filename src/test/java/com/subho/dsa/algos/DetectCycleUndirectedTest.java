package com.subho.dsa.algos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.subho.dsa.graph.algos.DetectCycleUndirected;

public class DetectCycleUndirectedTest {

    @Test
    public void test1() {
        int V = 6; 
        List<List<Integer>> adList = List.of(
            List.of(1,3),
            List.of(0,2,4),
            List.of(1,5),
            List.of(0,4),
            List.of(1,3,5),
            List.of(2,4)
        );

        boolean result = DetectCycleUndirected.isCycle(V, adList);
        assertTrue(result, "Incorrect result");
    }

    @Test
    public void test2() {
        int V = 4; 
        List<List<Integer>> adList = List.of(
            List.of(1, 2),
            List.of(0),
            List.of(0, 3),
            List.of(2)
        );

        boolean result = DetectCycleUndirected.isCycle(V, adList);
        assertFalse(result, "Incorrect result");
    }

    @Test
    public void test3() {
        int V = 3; 
        List<List<Integer>> adList = List.of(
            List.of(1),            
            List.of(2),
            List.of(0)            
        );

        boolean result = DetectCycleUndirected.isCycle(V, adList);
        assertTrue(result, "Incorrect result");
    }

    @Test
    public void test4() {
        int V = 1; 
        List<List<Integer>> adList = List.of(
            List.of(1)           
        );

        boolean result = DetectCycleUndirected.isCycle(V, adList);
        assertFalse(result, "Incorrect result");
    }

}
