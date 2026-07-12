package com.subho.dsa.graph.algos;

import com.subho.dsa.graph.util.AdjacencyList;
import com.subho.dsa.graph.util.ReadGraph;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversal {

    public void bfs(int V, int startNode, boolean[] visited, List<List<Integer>> adList) {

        System.out.println("AdList " + adList);
        Queue<Integer> queue = new LinkedList<>();
        // int[] visited = new int[V+1];
        visited[startNode] = true;
        queue.offer(startNode);

        System.out.println("Queue Now " + queue);

        while (!queue.isEmpty()) {

            int currNode = queue.poll();
            // System.out.println("Queue Now " + queue);
            System.out.print(currNode + ",");

            List<Integer> nbrs = adList.get(currNode);
            if (!nbrs.isEmpty()) {
                nbrs.forEach(nbr -> {
                    if (!visited[nbr]) {
                        visited[nbr] = true;
                        queue.offer(nbr);
                    }
                });
            }
        }
    }

    public void dfs(int V, int startNode, boolean[] visited, List<List<Integer>> adList) {

        System.out.println("AdList " + adList);
        visited[startNode] = true;
        dfsUtil(startNode, adList, visited);
    }

    private void dfsUtil(int node, List<List<Integer>> adList, boolean[] visited) {
        visited[node] = true;
        System.out.println("Processed " + node);

        List<Integer> nbrs = adList.get(node);

        for (Integer nbr : nbrs) {
            if (!visited[nbr]) {
                dfsUtil(nbr, adList, visited);
            }
        }
    }

    public static void main(String[] args) {
        ReadGraph rg = new ReadGraph();
        Traversal trv = new Traversal();
        List<List<Integer>> edges = rg.getGraph();
        AdjacencyList adjacencyList = new AdjacencyList();
        List<List<Integer>> adList = adjacencyList.getAdListUndirected(9, edges);

        boolean[] visited = new boolean[10];
        System.out.println("DFS");
        trv.dfs(9, 1, visited, adList);
        System.out.println("BFS");
        visited = new boolean[10];
        trv.bfs(9, 1, visited, adList);
    }
}
