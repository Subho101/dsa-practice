package com.subho.dsa.binary_search;

public class MinDaysToMakeBouque {
    public static int minDays(int[] bloomDay, int m, int k) {

        int low = bloomDay[0], high = bloomDay[0];
        int ans = -1;

        for (int i = 0; i < bloomDay.length; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouque(mid, m, k, bloomDay)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static boolean canMakeBouque(int day, int m, int k, int[] bloomDay) {
        int startingK = k;

        for (int i = 0; i < bloomDay.length; i++) {
            if (day >= bloomDay[i]) {
                startingK--;
            } else {
                startingK = k;
            }

            if (startingK == 0) {
                startingK = k;
                m--;
            }
        }

        System.out.println(m);
        return m <= 0;
    }

    public static void main(String[] args) {
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3, k = 2;
        System.out.println(minDays(bloomDay, m, k));
    }
}
