package com.subho.dsa.monotonic_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        Stack<Integer> st = new Stack<>();
        int[] lastSmaller = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            lastSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        System.out.println(Arrays.toString(lastSmaller));

        for (int i = 0; i < lastSmaller.length; i++) {
            result.add(i - lastSmaller[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 7, 7, 6, 1, 2, 6, 3, 7, 5 };
        System.out.println(calculateSpan(arr));
    }
}
