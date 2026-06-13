package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.subho.dsa.graph.util.AdjacencyList;

public class TopoSort {
    
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();

        List<List<Integer>> adList = AdjacencyList.prepareAdjListDirected(V, edges);

        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                dfs(i, visited, st, adList);
            }
        }

        while(!st.isEmpty()) {
            result.add(st.pop());
        }

        return result;        
    }

    private static void dfs(int node, boolean[] visited, Stack<Integer> st, List<List<Integer>> adList) {
        visited[node] = true;

        List<Integer> nbrs = adList.get(node);

        for(int nbr : nbrs) {
            if(!visited[nbr]) {
                dfs(nbr, visited, st, adList);
            }
        }

        st.push(node);
    }

    public static ArrayList<Integer> topoSortBFS(int V, int[][] edges) {

        // Kahn's Algorithm
        
        ArrayList<Integer> result = new ArrayList<>();
        List<List<Integer>> adList = AdjacencyList.prepareAdjListDirected(V, edges);
        int[] indegree = new int[V];

        for(int i=0; i<V; i++) {
            for(int adnbr : adList.get(i)) indegree[adnbr]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);

            for(int nbr : adList.get(curr)) {
                indegree[nbr]--;
                if(indegree[nbr] == 0) q.offer(nbr);
            }
        }
        

        return result;        
    }



    public static void main(String[] args) {
        int V = 4;
        int edges[][] = {{3, 0}, {1, 0}, {2, 0}};
        System.out.println(topoSortBFS(V, edges));
    }
}
