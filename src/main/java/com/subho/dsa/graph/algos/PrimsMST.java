package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsMST {
    static class Pair {
        int wt;
        int dest;

        Pair(int wt, int dest) {
            this.wt = wt;
            this.dest = dest;
        }
    }

    static class State {
        int wt;
        int dest;
        int parent;

        State(int wt, int dest, int parent) {
            this.wt = wt;
            this.dest = dest;
            this.parent = parent;
        }
    }

    public static int findMSTCost(int V, int[][] edges) {
        int sum = 0;
        List<List<Pair>> adList = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adList.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[V];
        List<int[]> mst = new ArrayList<>();

        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adList.get(u).add(new Pair(w, v));
            adList.get(v).add(new Pair(w, u));            
        }

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.offer(new State(0, 0, -1));
        while(!pq.isEmpty()) {
            State currState = pq.poll();
            int currWt = currState.wt;
            int currNode = currState.dest;
            int currParent = currState.parent;
            
            if(visited[currNode]) continue;
            
            if(currParent != -1) {
                mst.add(new int[] {currParent, currNode});
            }

            visited[currNode] = true;
            sum += currWt;

            List<Pair> adNbrs = adList.get(currNode);

            for(Pair nbr : adNbrs) {
                pq.offer(new State(nbr.wt, nbr.dest, currNode));
            }
        }

        mst.forEach(m -> System.out.println(m[0] + " " + m[1]));


        return sum;
    }



    public static void main(String[] args) {
       int  V = 3, E = 3;
       int edges[][] = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};

       System.out.println(findMSTCost(V, edges));   
    }
}
