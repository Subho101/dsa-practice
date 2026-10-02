package com.subho.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewTree {

    static class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public static ArrayList<Integer> topView(TreeNode root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode temp = p.node;
            int col = p.col;
            if (!map.containsKey(col)) {
                map.put(col, temp.val);
            }

            if (temp.left != null)
                q.offer(new Pair(temp.left, col - 1));
            if (temp.right != null)
                q.offer(new Pair(temp.right, col + 1));

        }

        // System.out.println(map);
        map.forEach((key, val) -> {
            ans.add(val);
        });
        return ans;
    }

    public static void main(String[] args) {
        Integer[] arr = { 10, 20, 30, 40, 60, 90, 100 };
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(topView(root));
    }
}
