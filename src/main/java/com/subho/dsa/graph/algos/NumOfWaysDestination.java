package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumOfWaysDestination {
    static int M = 1000000007;

    static class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public static int countPaths(int n, int[][] roads) {
        int[] ways = new int[n];
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;

        List<List<Pair>> adList = prepareAdList(n, roads);
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.time - p2.time);
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair currPair = pq.poll();
            int currNode = currPair.node;
            int currTime = currPair.time;

            List<Pair> adNbrs = adList.get(currNode);

            for (Pair adNbr : adNbrs) {
                int nbNode = adNbr.node;
                int nbTime = adNbr.time;

                if (currTime + nbTime == dist[nbNode]) {

                    ways[nbNode] = (ways[currNode] + ways[nbNode]) % M;

                } else if (currTime + nbTime < dist[nbNode]) {

                    dist[nbNode] = currTime + nbTime;
                    ways[nbNode] = ways[currNode];
                    pq.offer(new Pair(nbNode, currTime + nbTime));
                }
            }
        }
        // System.out.println(dist[n-1]);
        // System.out.println(ways[n-1]);
        return ways[n - 1] % M;
    }

    private static List<List<Pair>> prepareAdList(int n, int[][] roads) {
        List<List<Pair>> adList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adList.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            int src = roads[i][0];
            int dest = roads[i][1];
            int time = roads[i][2];

            adList.get(src).add(new Pair(dest, time));
            adList.get(dest).add(new Pair(src, time));
        }

        return adList;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {
            {0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}
        };
        int result = countPaths(n, roads);
        System.out.println(result);
    }
}
