package com.subho.dsa.graph.algos;

import com.subho.dsa.graph.util.Pair;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleUndirected {

    private static boolean isCycleDetectedWithBfs(int src, boolean[] visited, List<List<Integer>> adList) {

        if (adList.isEmpty() || adList.size() == 1) {
            return false;
        }

        Queue<Pair> q = new LinkedList<>();
        visited[src] = true;
        q.offer(new Pair(src, -1));

        while (!q.isEmpty()) {

            Pair curr = q.poll();
            int node = curr.i();
            int parent = curr.j();

            for (int adjNode : adList.get(node)) {
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    q.offer(new Pair(adjNode, node));

                } else if (adjNode != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isCycleDetectedWithDfs(int src, boolean[] visited, List<List<Integer>> adList) {
        return dfsUtil(new Pair(src, -1), visited, adList);
    }

    private static boolean dfsUtil(Pair currPair, boolean[] visited, List<List<Integer>> adList) {

        if (adList.isEmpty() || adList.size() == 1) return false;

        int currNode = currPair.i();
        int currParent = currPair.j();

        visited[currNode] = true;

        for (int adjNode : adList.get(currNode)) {
            if (!visited[adjNode]) {

                visited[adjNode] = true;
                boolean result = dfsUtil(new Pair(adjNode, currNode), visited, adList);
                if (result) return true;

            } else if (adjNode != currParent) {
                return true;
            }
        }

        return false;
    }

    public static boolean isCycle(int V, List<List<Integer>> adList) {
        boolean[] visited = new boolean[V]; // zero based
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // if(isCycleDetectedWithBfs(i, visited, adList)) return true;
                if (isCycleDetectedWithDfs(i, visited, adList)) return true;
            }
        }

        return false;
    }
}
