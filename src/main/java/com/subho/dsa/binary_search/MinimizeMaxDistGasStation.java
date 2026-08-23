package com.subho.dsa.binary_search;

public class MinimizeMaxDistGasStation {
    public static double minMaxDist(int[] stations, int k) {
        // code heres
        int[] additionalStations = new int[stations.length - 1];

        for (int gasStation = 1; gasStation <= k; gasStation++) {
            double maxDist = -1;
            int maxIndex = -1;

            for (int j = 0; j < stations.length - 1; j++) {
                double sectionLength = ((double) stations[j + 1] - stations[j]) / ((double) additionalStations[j] + 1);
                if (sectionLength > maxDist) {
                    maxDist = sectionLength;
                    maxIndex = j;
                }
            }

            additionalStations[maxIndex]++;
        }

        double maxDist = 0;

        for (int i = 0; i < stations.length - 1; i++) {
            double sectionLength = ((double) stations[i + 1] - stations[i]) / ((double) additionalStations[i] + 1);
            maxDist = Math.max(maxDist, sectionLength);
        }

        return maxDist;

    }

    public static void main(String[] args) {
        int[] stations = { 3, 6, 12, 19, 33 };
        int k = 3;

        System.out.println(minMaxDist(stations, k));
    }
}
