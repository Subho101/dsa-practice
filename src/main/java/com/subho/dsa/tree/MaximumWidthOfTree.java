package com.subho.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfTree {

    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        int ans = Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().index; // min id will present at the top of queue
            int first = 0, last = 0; // index of first and last

            for (int i = 0; i < size; i++) {
                Pair it = q.poll();
                int currId = it.index - min; // substracting the min, to mitigate the overflow issue
                TreeNode currNode = it.node;
                if (i == 0) {
                    first = currId; // index of node present at the first in a level
                }
                if (i == size - 1) {
                    last = currId; // index of node present at the last in a level
                }

                if (currNode.left != null) {
                    q.offer(new Pair(currNode.left, currId * 2 + 1));
                }

                if (currNode.right != null) {
                    q.offer(new Pair(currNode.right, currId * 2 + 2));
                }
            }

            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 3, 2, 5, 3, null, 9 };
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(widthOfBinaryTree(root));
    }
}
