package com.subho.dsa.graph.util;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
    
    public List<List<Integer>> getAdListUndirected(int V, List<List<Integer>> edges) {
        List<List<Integer>> adList = new ArrayList<>();

        for(int i=0; i<=V; i++) {
            adList.add(new ArrayList<>());
        }

        for(List<Integer> edge : edges) {
            int src = edge.get(0);
            int dest = edge.get(1);
            adList.get(src).add(dest);
            adList.get(dest).add(src);
        }

        return adList;
    }

    public void display(List<List<Integer>> list) {
        for(int i=0; i<list.size(); i++) {
            System.out.println(i + " --> " + list.get(i));
        }
    }

    public static void main(String[] args) {
        ReadGraph rGraph = new ReadGraph();
        AdjacencyList list = new AdjacencyList();
        List<List<Integer>> grp = rGraph.getGraph();
        System.out.println(grp);
        System.out.println("--------------");
        list.display(list.getAdListUndirected(9, grp));
    }

}
