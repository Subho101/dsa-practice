package com.subho.dsa.monotonic_stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {
    public static ArrayList<Integer> nextLargerElement(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }

            result.add(st.isEmpty() ? -1 : st.peek());
            st.push(arr[i]);

        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        System.out.println(nextLargerElement(arr));
    }
}
