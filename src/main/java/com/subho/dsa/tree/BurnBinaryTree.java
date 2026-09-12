package com.subho.dsa.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BurnBinaryTree {
    public static int amountOfTime(TreeNode root, int start) {
        if (root == null) {
            return -1;
        }

        Map<TreeNode, TreeNode> parentMap = makeParentMap(root);
        TreeNode startNode = getTargetNode(root, start);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visitedSet = new HashSet<>();
        q.offer(startNode);
        visitedSet.add(startNode);
        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false; // check if at least one adjacent node is infected / burned

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                if (curr.left != null && !visitedSet.contains(curr.left)) {
                    q.offer(curr.left);
                    visitedSet.add(curr.left);
                    flag = true;
                }

                if (curr.right != null && !visitedSet.contains(curr.right)) {
                    q.offer(curr.right);
                    visitedSet.add(curr.right);
                    flag = true;
                }

                if (parentMap.get(curr) != null && !visitedSet.contains(parentMap.get(curr))) {
                    q.offer(parentMap.get(curr));
                    visitedSet.add(parentMap.get(curr));
                    flag = true;
                }
            }

            if (flag) { // if at least one adjacent node is infected / burned, then increment the time
                ans++;
            }
        }

        return ans;
    }

    private static Map<TreeNode, TreeNode> makeParentMap(TreeNode root) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                map.put(curr.left, curr);
                q.offer(curr.left);
            }

            if (curr.right != null) {
                map.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
        return map;
    }

    private static TreeNode getTargetNode(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;

        TreeNode left = getTargetNode(root.left, val);
        TreeNode right = getTargetNode(root.right, val);

        if (left != null)
            return left;

        return right;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 5, 3, null, 4, 10, 6, 9, 2 };
        TreeNode root = TreeNode.buildTree(arr);
        int start = 3;
        System.out.println(amountOfTime(root, start));
    }
}
