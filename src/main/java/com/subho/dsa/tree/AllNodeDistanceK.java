package com.subho.dsa.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AllNodeDistanceK {
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();

        Map<TreeNode, TreeNode> parentMap = makeParentMap(root);
        // Map<TreeNode, Boolean> visitedMap = new HashMap<>();
        Set<TreeNode> visitedMap = new HashSet<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visitedMap.add(target);
        int currDist = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            if (currDist == k)
                break;
            currDist++;

            for (int i = 0; i < size; i++) { // traversing a particular level
                TreeNode curr = q.poll(); // so here we are polling only the node that are present in this level
                if (curr.left != null && !visitedMap.contains(curr.left)) {
                    visitedMap.add(curr.left);
                    q.offer(curr.left);
                }

                if (curr.right != null && !visitedMap.contains(curr.right)) {
                    visitedMap.add(curr.right);
                    q.offer(curr.right);
                }

                if (parentMap.get(curr) != null && !visitedMap.contains(parentMap.get(curr))) {
                    visitedMap.add(parentMap.get(curr));
                    q.offer(parentMap.get(curr));
                }
            }
        }

        while (!q.isEmpty()) {
            ans.add(q.poll().val);
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

    private static TreeNode gTreeNode(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;

        TreeNode left = gTreeNode(root.left, val);
        TreeNode right = gTreeNode(root.right, val);
        if (left != null)
            return left;

        return right;
    }

    public static void main(String[] args) {
        Integer[] arr = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
        int k = 2;
        TreeNode root = TreeNode.buildTree(arr);
        TreeNode target = gTreeNode(root, 5);
        System.out.println(target);

        System.out.println(distanceK(root, target, k));
    }
}
