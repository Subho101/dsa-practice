package com.subho.dsa.algos.monotonic_stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.subho.dsa.monotonic_stack.AsteroidCollison;

public class AsteroidCollisonTest {

    @Test
    public void test1() {
        int[] asteroids = { 3, 5, -6, 2, -1, 4 };
        int[] expected = { -6, 2, 4 };
        // int[] asteroids = { 8, -8 };
        // int[] asteroids = { -2, -1, 1, 2 };
        int[] result = AsteroidCollison.asteroidCollision(asteroids);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {
        int[] asteroids = { 8, -8 };
        int[] expected = {};
        // int[] asteroids = { 8, -8 };
        // int[] asteroids = { -2, -1, 1, 2 };
        int[] result = AsteroidCollison.asteroidCollision(asteroids);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test3() {
        int[] asteroids = { 10, 2, -5 };
        int[] expected = { 10 };
        // int[] asteroids = { 8, -8 };
        // int[] asteroids = { -2, -1, 1, 2 };
        int[] result = AsteroidCollison.asteroidCollision(asteroids);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test4() {
        int[] asteroids = { -2, -1, 1, 2 };
        int[] expected = { -2, -1, 1, 2 };
        // int[] asteroids = { 8, -8 };
        // int[] asteroids = { -2, -1, 1, 2 };
        int[] result = AsteroidCollison.asteroidCollision(asteroids);
        assertArrayEquals(expected, result);
    }
}
