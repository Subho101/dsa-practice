package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathUnDirected {

    public static int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        List<List<Integer>> adList = prepareAdList(V, edges);

        Stack<Integer> st = new Stack<>();
        st.push(src);

        while (!st.isEmpty()) {
            int node = st.pop();

            List<Integer> adNodes = adList.get(node);
            for (int adNode : adNodes) {
                if (dist[node] + 1 < dist[adNode]) {
                    dist[adNode] = dist[node] + 1;
                    st.push(adNode);
                }
            }
        }

        return dist;
    }

    private static List<List<Integer>> prepareAdList(int V, int[][] edges) {

        List<List<Integer>> adList = new ArrayList<>();

        for (int i = 0; i < V; i++) adList.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            adList.get(edges[i][0]).add(edges[i][1]);
            adList.get(edges[i][1]).add(edges[i][0]);
        }

        return adList;
    }

    public static void main(String[] args) {
        int V = 9, src = 0;
        int edges[][] = {{0, 1}, {0, 3}, {1, 2}, {3, 4}, {4, 5}, {2, 6}, {5, 6}, {6, 7}, {6, 8}, {7, 8}};

        int[] result = shortestPath(V, edges, src);
        System.out.println(Arrays.toString(result));
    }
}
