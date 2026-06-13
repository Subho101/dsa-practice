package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventualSafeState {

    public static List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> safeNodes = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        boolean[] pathVisited = new boolean[graph.length];

        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                dfs(i, visited, pathVisited, graph, safeNodes);
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;
        
    }

    private static boolean dfs(int node, boolean[] visited, boolean[] pathVisited, 
        int[][] graph, List<Integer> safeNodes) {

        visited[node] = true;
        pathVisited[node] = true;

        int[] nbrs = graph[node];

        for(int nbr : nbrs) {
            if(!visited[nbr]) {
                boolean result = dfs(nbr, visited, pathVisited, graph, safeNodes);
                if(result) return true;
            } else if(pathVisited[nbr]) {
                return true;
            }
        }
        pathVisited[node] = false;
        safeNodes.add(node);
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> safenodes = eventualSafeNodes(graph);
        System.out.println(safenodes);
    }
}
