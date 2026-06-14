package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Djiktra {

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

        @Override
        public String toString() {
                return "{" + node + " " + wt + "}";
        }
    }

    public static int[] dijkstra(int V, int[][] edges, int src) {

        List<List<Pair>> adList = createAdList(V, edges);
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currNode = curr.node;

            List<Pair> adNbrs = adList.get(currNode);

            for(Pair adNbr : adNbrs) {
                int nbNode = adNbr.node;    
                int nbWt = adNbr.wt;

                
                if(dist[currNode] + nbWt < dist[nbNode]) {
                    dist[nbNode] = dist[currNode] + nbWt;
                    pq.offer(new Pair(nbNode, dist[nbNode]));
                }
            }
        }

        for(int i=0; i<dist.length; i++) {
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
    }

    private static List<List<Pair>> createAdList(int V, int[][] edges) {
        List<List<Pair>> adList = new ArrayList<>();
        
        for(int i=0; i<V; i++) {
            adList.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int wt = edges[i][2];

            adList.get(src).add(new Pair(dest, wt));
            adList.get(dest).add(new Pair(src, wt));
        }

        return adList;
    }

    public static void main(String[] args) {
        int V = 3,  src = 2;
        int[][] edges = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};
        int[] dist = dijkstra(V, edges, src);
        System.out.println(Arrays.toString(dist));

    }
}
