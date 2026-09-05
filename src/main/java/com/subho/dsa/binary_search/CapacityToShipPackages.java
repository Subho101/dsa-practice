package com.subho.dsa.binary_search;

public class CapacityToShipPackages {
    public static int shipWithinDays(int[] weights, int days) {

        int low = Integer.MIN_VALUE, high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (calculateDaysToShip(days, mid, weights)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private static boolean calculateDaysToShip(int days, int capacity, int[] weights) {
        int currWt = 0;
        int daysTaken = 1;

        for (int i = 0; i < weights.length; i++) {
            if (currWt + weights[i] <= capacity) {
                currWt += weights[i];
            } else {
                currWt = weights[i];
                daysTaken++;
            }
        }
        return daysTaken <= days;
    }

    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }
}
