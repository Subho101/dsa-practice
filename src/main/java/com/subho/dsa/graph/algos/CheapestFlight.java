package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlight {

    static class Pair {
        int dest;
        int price;
        Pair(int dest, int price) {
            this.dest = dest;
            this.price = price;
        }
    }

    static class State {
        int stop;
        int node;
        int price;
        
        State(int stop, int node, int price) {
            this.stop = stop;
            this.node = node;
            this.price = price;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;


        List<List<Pair>> adList = prepareAdList(n, flights);
        Queue<State> q = new LinkedList<>();
        q.offer(new State(0, src, 0));

        while(!q.isEmpty()) {
            State currState = q.poll();
            int currNode = currState.node;
            int currStop = currState.stop;
            int currPrice = currState.price;

            if(currStop > k) continue;

            List<Pair> adNbrs = adList.get(currNode);
            for(Pair nbr : adNbrs) {
                
                int nbrNode = nbr.dest;
                int nbrPrice = nbr.price;

                if(currPrice + nbrPrice < dist[nbrNode]) {
                    dist[nbrNode] = currPrice + nbrPrice;
                    q.offer(new State(currStop+1, nbrNode, dist[nbrNode]));
                }
            }
            
        }

        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];


    }

    private static List<List<Pair>> prepareAdList(int n, int[][] flights) {
        List<List<Pair>> adList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adList.add(new ArrayList<>());
        }

        for(int i=0; i<flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int price = flights[i][2];

            adList.get(src).add(new Pair(dest, price));
        }

        return adList;
    }

    public static void main(String[] args) {
        //int n = 4,  src = 0, dst = 3, k = 1;
        //int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        //int n = 3,  src = 0, dst = 2, k = 1;
        //int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int n = 4,  src = 0, dst = 3, k = 1;
        int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        int output = findCheapestPrice(n, flights, src, dst, k);
        System.out.println(output);
    }
}
