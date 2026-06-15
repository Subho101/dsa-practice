package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DjiktraPrintShortestPath {

    static class Pair implements Comparable<Pair> {
        int node;
        int wt;

        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<Integer> result = new ArrayList<>();

        List<List<Pair>> adList = prepareAdList(m, edges);
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<List<Pair>> pq = new PriorityQueue<>((a, b) -> a.get(a.size() - 1).wt - b.get(b.size()-1).wt);
        pq.offer(new ArrayList<>(List.of(new Pair(1, 0))));

        while(!pq.isEmpty()) {
            int size = pq.size();
            
            List<Pair> currLevel = pq.poll();
            int lastNode = currLevel.get(currLevel.size() - 1).node;
            
            if(lastNode == n) {
                currLevel.stream().forEach(p -> result.add(p.node));
                break;
            }


            for(int i=0; i<size; i++) {
                List<Pair> adNbrs = adList.get(lastNode);

                for(Pair nbr : adNbrs) {
                    int nbrNode = nbr.node;
                    int nbrWt = nbr.wt;

                    if(dist[lastNode] + nbrWt < dist[nbrNode]) {
                        dist[nbrNode] = dist[lastNode] + nbrWt;
                        List<Pair> newList = new ArrayList<>(currLevel);
                        newList.add(new Pair(nbrNode, dist[nbrNode]));
                        pq.add(newList);
                    }
                }
            }

        }

        return result;
    }

    private static List<List<Pair>> prepareAdList(int V, int[][] edges) {
        List<List<Pair>> adList = new ArrayList<>();

        for(int i=1; i<=V; i++) {
            adList.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int wt = edges[i][2];

            adList.get(src).add(new Pair(dest, wt));
        }

        return adList;
    }

    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        System.out.println(shortestPath(n, m, edges));
    }

}
