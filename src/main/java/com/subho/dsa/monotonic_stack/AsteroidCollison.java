package com.subho.dsa.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollison {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            boolean alive = true; // Does the current asteroid survives?

            while (alive
                    && asteroid < 0
                    && !st.isEmpty()
                    && st.peek() > 0) {

                if (st.peek() < -asteroid) {
                    st.pop(); // top asteroid explodes
                } else if (st.peek() == -asteroid) {
                    st.pop(); // existing asteroid explodes
                    alive = false; // current also dont survives
                } else {
                    alive = false; // existing asteroid is bigger, so current explodes
                }

            }
            if (alive)
                st.push(asteroid);
        }

        int[] result = new int[st.size()];
        int idx = st.size() - 1;
        for (int j = idx; j >= 0; j--) {
            result[j] = st.pop();
        }

        return result;
    }

    public static void main(String[] args) {

        int[] asteroids = { 3, 5, -6, 2, -1, 4 };
        // int[] asteroids = { 8, -8 };
        // int[] asteroids = { -2, -1, 1, 2 };
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
}
