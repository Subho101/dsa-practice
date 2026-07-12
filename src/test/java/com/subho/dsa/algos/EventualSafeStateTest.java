package com.subho.dsa.algos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.subho.dsa.graph.algos.EventualSafeState;
import java.util.List;
import org.junit.jupiter.api.Test;

public class EventualSafeStateTest {

    @Test
    public void test1() {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        List<Integer> safenodes = EventualSafeState.eventualSafeNodes(graph);
        List<Integer> expected = List.of(2, 4, 5, 6);
        assertEquals(expected, safenodes);
    }

    @Test
    public void test2() {
        int[][] graph = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
        List<Integer> safenodes = EventualSafeState.eventualSafeNodes(graph);
        List<Integer> expected = List.of(4);
        assertEquals(expected, safenodes);
    }
}
