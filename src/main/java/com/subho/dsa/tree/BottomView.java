package com.subho.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

    static class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public static ArrayList<Integer> bottomView(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair it = q.poll();
            TreeNode temp = it.node;
            int col = it.col;
            int row = it.row;

            map.put(col, temp.val);

            if (temp.left != null)
                q.offer(new Pair(temp.left, row + 1, col - 1));

            if (temp.right != null)
                q.offer(new Pair(temp.right, row + 1, col + 1));
        }

        map.forEach((col, val) -> {
            ans.add(val);
        });

        return ans;

    }

    public static void main(String[] args) {
        Integer[] arr = { 20, 8, 22, 5, 3, 4, 25, null, null, 10, 14, null, null, 28, null };
        TreeNode root = TreeNode.buildTree(arr);

        System.out.println(bottomView(root));
    }
}
