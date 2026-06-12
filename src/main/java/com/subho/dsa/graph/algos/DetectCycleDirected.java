package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirected {

    public static boolean detectCycle(int V, int[][] edges) {

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        List<List<Integer>> adList = prepareAdjList(V, edges);

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                if(dfs(i, adList, visited, pathVisited)) return true;
            }
        }

        return false;
    }

    private static boolean dfs(int node, List<List<Integer>> adList, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        List<Integer> nbrs = adList.get(node);

        for(int nbr : nbrs) {
            if(!visited[nbr]) {
                boolean result = dfs(nbr, adList, visited, pathVisited);
                if(result) return true;
            } else if(pathVisited[nbr]) {
                return true;
            }
        }

        pathVisited[node] = false;
        return false;
    }

    private static List<List<Integer>> prepareAdjList(int V, int[][] edges) {
        List<List<Integer>> adList = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adList.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++) {
            int src = edges[i][0], dest = edges[i][1];
            adList.get(src).add(dest);
        }
        

        return adList;
    }
    public static void main(String[] args) {
        int V = 4; 
        int edges[][] = {{0, 1}, {1, 2}, {2, 0}, {2, 3}};
        System.out.println(detectCycle(V, edges));
    }
}
