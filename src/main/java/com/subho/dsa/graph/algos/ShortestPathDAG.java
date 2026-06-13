package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathDAG {

    static class Pair {
        int dest;
        int wt;

        Pair(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }

        public String toString() {
            return "(" + dest + " " + wt + ")";
        }
    }

    public static int[] shortestPath(int V, int E, int[][] edges) {

        List<List<Pair>> adList = new ArrayList<>();
        int[] indegree = new int[V];
        int[] path = new int[V];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[0] = 0;

        for(int i=0; i<V; i++) adList.add(new ArrayList<>());

        for(int i=0; i<V; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int wt = edges[i][2];
            adList.get(src).add(new Pair(dest, wt));
        }

        for(int i=0; i<V; i++) {
            for(Pair nbr : adList.get(i)) {
                indegree[nbr.dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while (!q.isEmpty()) {
            int curr = q.poll();
            
            List<Pair> nbrs = adList.get(curr);
            for(Pair nbr : nbrs) {
                indegree[nbr.dest]--;
                path[nbr.dest] = path[nbr.dest] == Integer.MAX_VALUE ? path[curr] + nbr.wt : Math.min(path[curr] + nbr.wt, path[curr]);
                if(indegree[nbr.dest] == 0) q.offer(nbr.dest); 
            }
        }
    
        return path;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,2}, {0,4,1}, {4,5,4}, {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1}};
        int V = 6, E = 7;
        int[] path = shortestPath(V, 0, edges);

        System.out.println(Arrays.toString(path));
    }
}
