package com.subho.dsa.graph.algos;

public class DisjointSet {

    public int[] rank;
    public int[] parent;

    public DisjointSet(int n) {
        // 1 based nodes
        rank = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int node) {
        if (node == parent[node]) return node;

        return parent[node] = findParent(parent[node]);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        } else if (rank[ulp_u] > rank[ulp_v]) {
            parent[ulp_v] = ulp_u;
        } else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    public static void main(String[] args) {
        DisjointSet djs = new DisjointSet(7);
        djs.unionByRank(1, 2);
        djs.unionByRank(2, 3);
        djs.unionByRank(4, 5);
        djs.unionByRank(6, 7);
        djs.unionByRank(5, 6);

        if (djs.findParent(3) == djs.findParent(7)) {
            System.out.println("Same parent");
        } else {
            System.out.println("Not Same parent");
        }

        djs.unionByRank(3, 7);
        System.out.println("=======================");
        if (djs.findParent(3) == djs.findParent(7)) {
            System.out.println("Same parent");
        } else {
            System.out.println("Not Same parent");
        }
    }
}
