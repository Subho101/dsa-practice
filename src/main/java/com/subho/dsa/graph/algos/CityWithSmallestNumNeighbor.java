package com.subho.dsa.graph.algos;

import java.util.Arrays;

public class CityWithSmallestNumNeighbor {

    static class Pair {
        int i;
        int j;
        int wt;
        Pair(int i, int j, int wt) {
            this.i = i;
            this.j = j;
            this.wt = wt;
        }
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] adMatrix = new int[n][n];

        for(int i=0; i<n;i++) {
            for(int j=0; j<n;j++) {
                adMatrix[i][j] = (int)(1e9);
                if(i == j) adMatrix[i][j] = 0;
            }
        }

        for(int i=0; i<edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int wt = edges[i][2];

            adMatrix[src][dest] = wt;
            adMatrix[dest][src] = wt;
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    adMatrix[i][j] = Math.min(adMatrix[i][j], adMatrix[i][k] + adMatrix[k][j]);
                }
            }
        }


        for(int[] arr : adMatrix) System.out.println(Arrays.toString(arr));

        int minNbr = Integer.MAX_VALUE;
        int node = 0;

        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(i != j && adMatrix[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            System.out.println("Count " + count);
            if(count <= minNbr) {
                minNbr = count;
                node = i;
            }
        }

        return node;    
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int n = 4, distanceThreshold = 4;

        int result = findTheCity(n, edges, distanceThreshold);
        System.out.println(result);
    }
}
