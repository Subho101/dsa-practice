package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.subho.dsa.graph.util.AdjacencyList;

public class CountProvinces {

    private Traversal trv = new Traversal();
    
    public int numProvinces(int V, List<List<Integer>> edges) {
        boolean[] visited = new boolean[V+1];
        AdjacencyList adjacencyList = new AdjacencyList();
        List<List<Integer>> adList = adjacencyList.getAdListUndirected(V, edges);
        int count = 0;
        for(int i=1; i<visited.length; i++) {
            if(!visited[i]) {
                count++;
                //trv.dfs(V, i, visited, adList);
                trv.bfs(V, i, visited, adList);
            }
        }

        return count;
    }

    public int numProvincesUtil(int V, int[][] adjMatrix) {
        Set<List<Integer>> edges = new HashSet<>();


        for(int i=0; i<adjMatrix.length; i++) {
            for(int j=0; j<adjMatrix[i].length; j++) {
                if(adjMatrix[i][j] == 1 && (i != j)) {
                    List<Integer> edge = Arrays.asList(i+1, j+1);
                    Collections.sort(edge);
                    edges.add(edge);
                }
            }
        }

        System.out.println("Edges " + edges);

        return numProvinces(V, new ArrayList<>(edges));
    }

    public static void main(String[] args) {
        int[][] adjMatrix = {
            {1, 0, 0, 1}, 
            {0, 1, 1, 0}, 
            {0, 1, 1, 0}, 
            {1, 0, 0, 1} 
        };
        CountProvinces countProvinces = new CountProvinces();
        System.out.println("Num: " + countProvinces.numProvincesUtil(adjMatrix.length, adjMatrix));
    }

}
