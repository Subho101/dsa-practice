package com.subho.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalOrderTree {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        traverseTree(root, 0, 0, map);
        System.out.println(map);
        map.forEach((key, val) -> {
            List<Integer> subList = new ArrayList<>();
            val.forEach((row, pq) -> {
                while (!pq.isEmpty()) {
                    subList.add(pq.poll());
                }
            });
            ans.add(subList);
        });

        return ans;
    }

    private static void traverseTree(TreeNode node, int row, int col,
            TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null) {
            return;
        }

        traverseTree(node.left, row + 1, col - 1, map);
        traverseTree(node.right, row + 1, col + 1, map);

        // col --> row --> sorted value
        map
                .computeIfAbsent(col, k -> new TreeMap<>())
                .computeIfAbsent(row, k -> new PriorityQueue<>())
                .offer(node.val);

    }

    public static void main(String[] args) {
        // Integer[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        Integer[] arr = { 0, 2, 1, 3, null, 5, 22, 9, 4, 12, 25, null, null, 13, 14, 8, 6, null, null, null, null, null,
                27, 24, 26, null, 17, 7, null, 28, null, null, null, null, null, 19, null, 11, 10, null, null, null, 23,
                16, 15, 20, 18, null, null, null, null, null, 21, null, null, 29 };
        TreeNode root = TreeNode.buildTree(arr);

        System.out.println(verticalTraversal(root));
    }
}
