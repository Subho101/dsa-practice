package com.subho.dsa.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTravel {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        int level = 0;
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = q.poll();
                if (currNode.left != null)
                    q.offer(currNode.left);
                if (currNode.right != null)
                    q.offer(currNode.right);

                if (level % 2 == 1) {
                    subList.addFirst(currNode.val);
                } else {
                    subList.add(currNode.val);
                }

            }
            ans.add(subList);
            level++;
        }

        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = TreeNode.buildTree(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        List<List<Integer>> ans = zigzagLevelOrder(root);
        System.out.println(ans);
    }
}
