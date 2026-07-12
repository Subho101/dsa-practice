package com.subho.dsa.algos.two_pointer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.subho.dsa.two_pointer.BoatsToSavePeople;
import org.junit.jupiter.api.Test;

public class BoatsToSavePeopleTest {

    @Test
    public void test1() {
        int[] peopple = {1, 2};
        int limit = 3;
        int result = BoatsToSavePeople.numRescueBoats(peopple, limit);
        assertEquals(1, result);
    }

    @Test
    public void test2() {
        int[] peopple = {3, 2, 2, 1};
        int limit = 3;
        int result = BoatsToSavePeople.numRescueBoats(peopple, limit);
        assertEquals(3, result);
    }

    @Test
    public void test3() {
        int[] peopple = {3, 5, 3, 4};
        int limit = 5;
        int result = BoatsToSavePeople.numRescueBoats(peopple, limit);
        assertEquals(4, result);
    }

    @Test
    public void test4() {
        int[] peopple = {1, 5, 3, 5};
        int limit = 7;
        int result = BoatsToSavePeople.numRescueBoats(peopple, limit);
        assertEquals(3, result);
    }

    @Test
    public void test5() {
        int[] peopple = {5, 1, 4, 2};
        int limit = 6;
        int result = BoatsToSavePeople.numRescueBoats(peopple, limit);
        assertEquals(2, result);
    }
}
