package com.subho.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class RightViewTree {

    static class Pair {
        TreeNode node;
        int row;

        Pair(TreeNode node, int row) {
            this.node = node;
            this.row = row;
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair it = q.poll();
            TreeNode temp = it.node;
            int row = it.row;

            map.put(row, temp.val);

            if (temp.left != null)
                q.offer(new Pair(temp.left, row + 1));
            if (temp.right != null)
                q.offer(new Pair(temp.right, row + 1));
        }

        map.forEach((k, v) -> {
            ans.add(v);
        });

        return ans;
    }

    public static List<Integer> rightSideViewRecursive(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traversePreOrder(root, 0, ans);
        return ans;
    }

    private static void traversePreOrder(TreeNode node, int level, List<Integer> ans) {
        if (node == null)
            return;

        if (level == ans.size())
            ans.add(node.val);

        traversePreOrder(node.right, level + 1, ans);
        traversePreOrder(node.left, level + 1, ans);
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, null, null, null, 5 };
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(rightSideViewRecursive(root));
    }
}
