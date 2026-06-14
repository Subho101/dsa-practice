package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        List<List<Pair>> adList = prepareAdList(V, edges);
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                dfs(i, visited, st, adList);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        while(!st.isEmpty()) {
            int node =  st.pop();
            if(dist[node] != Integer.MAX_VALUE) {

                List<Pair> adNodes = adList.get(node);
                for(Pair p : adNodes) {
                    dist[p.dest] = Math.min(dist[p.dest], dist[node] + p.wt);
                }
            }
        }

        return dist;

    }

    private static void dfs(int node, boolean[] visited, Stack<Integer> st, List<List<Pair>> adList) {

        visited[node] = true;

        List<Pair> adNbrs = adList.get(node);
        for(Pair nbr : adNbrs) {
            if(!visited[nbr.dest]) {
                dfs(nbr.dest, visited, st, adList);
            }
        }

        st.push(node);
    }

    private static List<List<Pair>> prepareAdList(int V, int[][] edges) {
        List<List<Pair>> adList = new ArrayList<>();

        for(int i=0; i<V; i++) {
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
        int[][] edges = {{0,1,2}, {0,4,1}, {4,5,4}, {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1}};
        int V = 6, E = 7;
        int[] path = shortestPath(V, 0, edges);

        System.out.println(Arrays.toString(path));
    }
}
