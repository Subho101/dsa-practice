package com.subho.dsa.two_pointer;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;

        int left = 0, right = people.length - 1;

        while (left <= right) {
            int sum = people[left] + people[right];
            if (sum <= limit) {
                count++;
                left++;
                right--;
            } else {
                count++;
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // int[] people = {3,2,2,1};
        // int limit = 3;

        // int[] people = {3,5,3,4};
        // int limit = 5;

        int[] people = {1, 5, 3, 5}; // expected 3
        int limit = 7;

        System.out.println(numRescueBoats(people, limit));
    }
}
