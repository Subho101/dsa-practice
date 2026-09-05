package com.subho.dsa.binary_search;

public class KokoEatingBanana {
    public static int kokoEat(int[] arr, int k) {
        int low = arr[0], high = arr[0];

        for (int i = 0; i < arr.length; i++) {
            low = Math.min(low, arr[i]);
            high = Math.max(high, arr[i]);
        }

        int minHour = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalHour = countHours(mid, arr);
            if (totalHour <= k) {
                minHour = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minHour;
    }

    private static int countHours(int bananaPerHour, int[] arr) {
        double total = 0;

        for (int pile : arr) {
            total += Math.ceil((double) pile / (double) bananaPerHour);
            System.out.println("Total " + total);
        }
        System.out.println("Time taken to eat all the piles in " + bananaPerHour + " banana/hour is " + total);
        return (int) total;
    }

    public static void main(String[] args) {
        // int arr[] = { 5, 10, 3 };
        // int k = 4;
        int arr[] = { 5, 10, 15, 20 };
        int k = 7;
        System.out.println(kokoEat(arr, k));
    }
}
